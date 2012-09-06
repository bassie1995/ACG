package bas.sie.Antonius;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class AntoniusActivity extends SherlockFragmentActivity {

	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;
	ActionBar actionBar;
	WebView mWebView;
	AlertDialog alertDialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.pager);
		setContentView(mViewPager);
		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mTabsAdapter = new TabsAdapter(this, mViewPager);
		mTabsAdapter.addTab(actionBar.newTab().setText("Links"),
				External.class, null);
		mTabsAdapter.addTab(actionBar.newTab().setText("Roosters"), Home.class,
				null);
		mTabsAdapter.addTab(actionBar.newTab().setText("Contact"),
				Contact.class, null);
		actionBar.setSelectedNavigationItem(1);

		/*
		 * BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
		 * R.drawable.bg_striped); bg.setTileModeXY(TileMode.REPEAT,
		 * TileMode.REPEAT); getSupportActionBar().setBackgroundDrawable(bg);
		 */

		final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
		if (activeNetwork != null
				&& activeNetwork.getState() == NetworkInfo.State.CONNECTED) {

		} else {
			new AlertDialog.Builder(this)
					.setTitle("Internetverbinding")
					.setMessage("Internet is niet actief. Doorgaan?")
					.setPositiveButton("Ja",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									Log.d("AlertDialog", "Positive");
								}
							})
					.setNegativeButton("Nee",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									System.exit(0);
									Log.d("AlertDialog", "Negative");
								}
							}).show();
		}

		ChangeLog cl = new ChangeLog(this);
		if (cl.firstRun())
			cl.getFullLogDialog().show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings: // Settings item
			Intent i = new Intent(this, Settings.class); // Start Settings.java
															// Activity
			startActivity(i);
			return true;

		case R.id.about: // About item
			Intent about = new Intent(this, About.class); // Start About.java
															// Activity
			startActivity(about);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void onBackPressed() {
		System.exit(0);
	}

	public class TabsAdapter extends FragmentPagerAdapter implements
			ActionBar.TabListener, ViewPager.OnPageChangeListener {
		private final Context mContext;
		private final ActionBar mActionBar;
		private final ViewPager mViewPager;
		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

		final class TabInfo {
			private final Class<?> clss;
			private final Bundle args;

			TabInfo(Class<?> _class, Bundle _args) {
				clss = _class;
				args = _args;
			}
		}

		/*
		 * Constructor method that adds a TabsAdapter to each tab that is
		 * created. It also adds the ViewPager to each tab so that the user can
		 * swipe to change tabs.
		 */
		public TabsAdapter(SherlockFragmentActivity activity, ViewPager pager) {
			super(activity.getSupportFragmentManager());
			mContext = activity;
			mActionBar = activity.getSupportActionBar();
			mViewPager = pager;
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);
		}

		/*
		 * A fairly simple method that sets the TabInfo for each tab so that the
		 * TabsAdapter knows which class the tab that is being added actually
		 * belonds to. It also updates the UI interface when each tab is added.
		 */
		public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
			TabInfo info = new TabInfo(clss, args);
			tab.setTag(info);
			tab.setTabListener(this);
			mTabs.add(info);
			mActionBar.addTab(tab);
			notifyDataSetChanged();
		}

		public int getCount() {
			return mTabs.size();
		}

		/*
		 * A method that is used in other classes to allow each tab Fragment to
		 * access its inherited methods from a mother-class, in this case,
		 * SherlockFragment
		 */
		public Fragment getItem(int position) {
			TabInfo info = mTabs.get(position);
			return Fragment.instantiate(mContext, info.clss.getName(),
					info.args);
		}

		/*
		 * This method reads the user's selection for a new tab and sets that
		 * tab as the new current focus.
		 */
		public void onPageSelected(int position) {
			mActionBar.setSelectedNavigationItem(position);

			selectInSpinnerIfPresent(position, true);
		}

		private void selectInSpinnerIfPresent(int position, boolean animate) {
			try {
				View actionBarView = findViewById(R.id.abs__action_bar);
				if (actionBarView == null) {
					int id = getResources().getIdentifier("action_bar", "id",
							"android");
					actionBarView = findViewById(id);
				}

				Class<?> actionBarViewClass = actionBarView.getClass();
				Field mTabScrollViewField = actionBarViewClass
						.getDeclaredField("mTabScrollView");
				mTabScrollViewField.setAccessible(true);

				Object mTabScrollView = mTabScrollViewField.get(actionBarView);
				if (mTabScrollView == null) {
					return;
				}

				Field mTabSpinnerField = mTabScrollView.getClass()
						.getDeclaredField("mTabSpinner");
				mTabSpinnerField.setAccessible(true);

				Object mTabSpinner = mTabSpinnerField.get(mTabScrollView);
				if (mTabSpinner == null) {
					return;
				}

				Method setSelectionMethod = mTabSpinner
						.getClass()
						.getSuperclass()
						.getDeclaredMethod("setSelection", Integer.TYPE,
								Boolean.TYPE);
				setSelectionMethod.invoke(mTabSpinner, position, animate);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		public void onPageScrollStateChanged(int state) {
		}

		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
		}

		/*
		 * This is the method that actually draws the newest tab onto the screen
		 * when it is selected.
		 */
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mViewPager.setCurrentItem(tab.getPosition());
			Object tag = tab.getTag();
			for (int i = 0; i < mTabs.size(); i++) {
				if (mTabs.get(i) == tag) {
					mViewPager.setCurrentItem(i);
				}
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}

		public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		}

		public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		}
	}

}
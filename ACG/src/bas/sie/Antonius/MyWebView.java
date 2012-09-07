package bas.sie.Antonius;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;

public class MyWebView extends SherlockActivity {

	String URLhome;
	String Title;
	WebView mWebView;
	private ProgressDialog pDialog;
	public static final int progress_bar_type = 0;
	private static String file_url;

	final Activity activity = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Adds Progress bar Support
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.mywebview);

		Intent startingIntent = getIntent();
		URLhome = startingIntent.getStringExtra("home");
		Title = startingIntent.getStringExtra("title");

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		mWebView = (WebView) findViewById(R.id.Mywebview);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.setInitialScale(80);
		mWebView.getSettings().setUseWideViewPort(true);

		mWebView.setWebChromeClient(new WebChromeClient() {

			public void onProgressChanged(WebView view, int progress) {
				setTitle("Laden...");
				setSupportProgress(progress * 100);
				if (progress == 100)
					setTitle(Title);
			}
		});

		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				setSupportProgressBarIndeterminateVisibility(false);
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(MyWebView.this, "Fout " + description,
						Toast.LENGTH_SHORT).show();
			}
		});

		final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
		if (activeNetwork != null
				&& activeNetwork.getState() == NetworkInfo.State.CONNECTED) {
			mWebView.loadUrl(URLhome);
		} else {
			new AlertDialog.Builder(this)
					.setTitle("Internetverbinding")
					.setMessage("De webpagina kon niet geladen worden.\nIs internet ingeschakeld?")
					.setPositiveButton("Ja",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							})
					.setNegativeButton("Nee",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									finish();
								}
							})
			.show();
			setTitle(Title);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.menu_webview, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home: // Home item
			finish(); //Not an Intent to AntoniusActivity, because that resets the position of AA to the Home tab.
			/*
			 * Intent intent = new Intent(this, AntoniusActivity.class);
			 * intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 * startActivity(intent);
			 */
			return true;

		case R.id.web:
			Intent web = new Intent(Intent.ACTION_VIEW);
			web.setData(Uri.parse(mWebView.getUrl()));
			startActivity(web);
			return true;

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

		case R.id.save: // Save item
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				Log.d("MyApp", "No SDCARD");
			} else {
				File directory = new File(Environment
						.getExternalStorageDirectory().getPath()
						+ "/data/"
						+ getPackageName() + "/");
				directory.mkdirs();
			}
			// starting new Async Task

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void onBackPressed() {
		mWebView.clearCache(true);
		finish();
	}

	public static boolean deleteDir(File dir) {
		if (dir != null && dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		// The directory is now empty so delete it
		return dir.delete();
	}
}

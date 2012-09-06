package bas.sie.Antonius;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class TeacherInfo extends SherlockActivity {

	String URLhome;
	String Info;
	String TeacherAb;
	TextView mTxtvInfo;
	Button mBtnTeacherStSchedule;
	Button mBtnTeacherDaySchedule;
	private static String mainUrl = "http://www.carmelcollegegouda.nl/site_ant/";
	private static String endUrl = ".htm";
	private static String[] myUrls = { "roosters/dagroosters/Doc_V1_",
			"roosters/standaardroosters/Doc1_" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactinfo);
		setTitle("Over deze leraar");

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		mTxtvInfo = (TextView) findViewById(R.id.TxtvTeacher);

		Intent startingIntent = getIntent();
		Info = startingIntent.getStringExtra("contact");
		mTxtvInfo.setText(Info);
		TeacherAb = startingIntent.getStringExtra("abbrev");
		
		mBtnTeacherDaySchedule = (Button) findViewById(R.id.btnTeacherDaySchedule);
		mBtnTeacherStSchedule = (Button) findViewById(R.id.btnTeacherStSchedule);

		mBtnTeacherDaySchedule.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				URLhome = makeUrl(0);

				Intent i = new Intent(TeacherInfo.this, MyWebView.class);
				i.putExtra("home", URLhome);
				i.putExtra("title", TeacherAb);
				startActivityForResult(i, 0);
			}
		});

		mBtnTeacherStSchedule.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				URLhome = makeUrl(1);

				Intent i = new Intent(TeacherInfo.this, MyWebView.class);
				i.putExtra("home", URLhome);
				i.putExtra("title", TeacherAb);
				startActivityForResult(i, 0);
			}
		});

	}

	private String makeUrl(int index) {
		String s = mainUrl + myUrls[index] + TeacherAb + endUrl;
		return s;
	}// makeurl

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getSupportMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case android.R.id.home: // Home item
	    	Intent intent = new Intent(this, AntoniusActivity.class);
	    	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	startActivity(intent);
	    	return true;
	    	
	    case R.id.settings: // Settings item
	        Intent i = new Intent(this, Settings.class); // Start Settings.java Activity
	        startActivity(i);
	        return true;

	    case R.id.about: // About item
	        Intent about = new Intent(this, About.class); // Start About.java Activty
	        startActivity(about);
	        return true;

	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}

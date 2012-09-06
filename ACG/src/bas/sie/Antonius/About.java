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

public class About extends SherlockActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		setTitle("Over de app");

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		TextView mTxtvAbout = (TextView) findViewById(R.id.txtvAbout);
		mTxtvAbout
				.setText("Deze app is gemaakt door Bas Verhoog."
						+ "\nAls er problemen zijn met de app, of u heeft suggesties, druk dan op de knop hieronder om mij te mailen.");

		Button mBtnMail = (Button) findViewById(R.id.btnMail);

		mBtnMail.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.setType("plain/text");
				emailIntent.putExtra(Intent.EXTRA_EMAIL,
						new String[] { getString(R.string.app_email_address) });
				emailIntent.putExtra(Intent.EXTRA_SUBJECT,
						getString(R.string.app_info_email_subject));
				emailIntent.setType("message/rfc822");
				startActivity(Intent.createChooser(emailIntent,
						"Zend mail met:"));
			}
		});

		TextView mTxtvCredits = (TextView) findViewById(R.id.txtvCredits);
		mTxtvCredits.setText("Met dank aan: \n\n" 
				+ "Phyll (AndDev) \n"
				+ "David J Kelley, op StackOverflow en daarbuiten: "
				+ "davidjkelley.net \n"
				+ "Jake Wharton (ActionBarSherlock) \n" 
				+ "Ollie C (StackOverflow) \n"
				+ "Xavi Rigua (StackOverflow) \n"
				+ "Rick Verhoog \n"
				+ "fifarunnerr (AndroidWorld) \n"
				+ "Mart Jans-Rat (AndroidWorld en daarbuiten) \n"
				+ "Eerder gestelde vragen op StackOverflow");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getSupportMenuInflater();
	    inflater.inflate(R.menu.menu_about, menu);
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
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}

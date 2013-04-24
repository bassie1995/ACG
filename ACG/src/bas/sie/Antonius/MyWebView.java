package bas.sie.Antonius;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
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
	public static final int progress_bar_type = 0;

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
		mWebView.getSettings().setLoadWithOverviewMode(true);
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
					.setMessage(
							"Er is geen internetverbinding.\nLaatst opgeslagen lokale versie gebruiken?")
					.setPositiveButton("Ja",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									mWebView.loadUrl("file://"
											+ Environment
													.getExternalStorageDirectory()
													.getPath() + "/data/"
											+ getPackageName()
											+ "/webpage.html");
								}
							})
					.setNegativeButton("Nee",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									finish();
								}
							}).show();
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
			finish(); // Not an Intent to AntoniusActivity, because that resets
						// the position of AA to the Home tab.
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
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {

				setSupportProgressBarIndeterminateVisibility(true);
				setTitle("Bestand downloaden");

				// execute this when the downloader must be fired
				DownloadFile downloadFile = new DownloadFile();
				downloadFile.execute(URLhome);

				setSupportProgressBarIndeterminateVisibility(false);
				setTitle(Title);

				Toast.makeText(this, "Bestand opgeslagen", Toast.LENGTH_SHORT)
						.show();

			} else {
				Toast.makeText(this, "Kan niet naar de telefoon schrijven",
						Toast.LENGTH_LONG).show();
			}

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	// usually, subclasses of AsyncTask are declared inside the activity class.
	// that way, you can easily modify the UI thread from here
	private class DownloadFile extends AsyncTask<String, Integer, String> {
		@Override
		protected String doInBackground(String... sUrl) {
			try {
				URL url = new URL(URLhome);
				URLConnection connection = url.openConnection();
				connection.connect();

				// download the file
				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream(Environment
						.getExternalStorageDirectory().getPath()
						+ "/data/"
						+ getPackageName() + "/webpage.html");

				byte data[] = new byte[1024];
				int count;
				try {
					while ((count = input.read(data)) != -1)
						output.write(data, 0, count);
				} catch (IOException e) {
					e.printStackTrace();
				}

				output.flush();
				output.close();
				input.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return null;
		}
	}
}

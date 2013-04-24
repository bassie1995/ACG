/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bas.sie.Antonius;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.service.dreams.DreamService;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class Screensaver extends DreamService {

	public static final String PREFS_NAMES = "bas.sie.Antonius_preferences";
	SharedPreferences prefs = this.getSharedPreferences(PREFS_NAMES, 0);
	String studentId = prefs.getString("StudentID", "");
	
	private class LinkLauncher extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
			return true;
		}
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		
		setContentView(R.layout.main);
		
		setFullscreen(false);

		final String url = "http://www.carmelcollegegouda.nl/site_ant/roosters/dagroosters/Lee_V1_53088.htm";

		final boolean interactive = prefs.getBoolean("interactive", false);
		
		Log.v("WebViewDream", String.format("loading %s in %s mode", url,
				interactive ? "interactive" : "noninteractive"));
		setInteractive(interactive);

		WebView webview = (WebView) findViewById(R.id.Mywebview);
		webview.setWebViewClient(new LinkLauncher());

		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(false);

		webview.loadUrl(url);
	}

}
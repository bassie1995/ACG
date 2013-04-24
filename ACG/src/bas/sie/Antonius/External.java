package bas.sie.Antonius;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;


public class External extends SherlockFragment implements OnClickListener {

	private View mainLayout;
	Button mBtnOuderPortaal;
	Button mBtnTeletop;
	Button mBtnWebmail;
	Button mBtnInfobord;
	Button mBtnTwitter;
	Button mBtnFacebook;
	Button mBtnYouTube;
	String URLhome;
	String Title;

	@Override
	public void onResume() {
		super.onResume();
		
		mBtnOuderPortaal = (Button) getActivity().findViewById(
				R.id.btnOuderPortaal);
		mBtnOuderPortaal.setOnClickListener(this);
		mBtnTeletop = (Button) getActivity().findViewById(R.id.btnTeletop);
		mBtnTeletop.setOnClickListener(this);
		mBtnWebmail = (Button) getActivity().findViewById(R.id.btnWebmail);
		mBtnWebmail.setOnClickListener(this);
		mBtnInfobord = (Button) getActivity().findViewById(R.id.btnInfobord);
		mBtnInfobord.setOnClickListener(this);
		mBtnTwitter = (Button) getActivity().findViewById(R.id.btnTwitter);
		mBtnTwitter.setOnClickListener(this);
		mBtnFacebook = (Button) getActivity().findViewById(R.id.btnFacebook);
		mBtnFacebook.setOnClickListener(this);
		mBtnYouTube = (Button) getActivity().findViewById(R.id.btnYouTube);
		mBtnYouTube.setOnClickListener(this);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.external, container, false);
		this.mainLayout = v;

		return mainLayout;
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnFacebook:
			showFBDialog();
			break;
		case R.id.btnTwitter:
			showDialog();
			break;
		case R.id.btnInfobord:
			URLhome = "http://carmelcollegegouda.nl/site_ant/index.php?option=com_content&view=article&id=182&Itemid=131&lang=nl";
			Title = "Infobord";

			Intent bord = new Intent();
			bord.setClass(getActivity(), MyWebView.class);
			bord.putExtra("home", URLhome);
			bord.putExtra("title", Title);
			startActivity(bord);
			break;
		case R.id.btnOuderPortaal:
			URLhome = "https://portaal.mijnsom.nl/login/ccg";
			Title = "Onderwijsportaal";

			Intent portaal = new Intent();
			portaal.setClass(getActivity(), MyWebView.class);
			portaal.putExtra("home", URLhome);
			portaal.putExtra("title", Title);
			startActivity(portaal);
			break;
		case R.id.btnTeletop:
			URLhome = "http://antoniuscollege.teletop.nl/";

			Intent teletop = new Intent();
			teletop.setClass(getActivity(), MyWebView.class);
			teletop.putExtra("home", URLhome);
			teletop.putExtra("title", Title);
			startActivity(teletop);
			break;
		case R.id.btnWebmail:
			URLhome = "https://webmail.carmelcollegegouda.nl/";
			Title = "Webmail";

			Intent mail = new Intent();
			mail.setClass(getActivity(), MyWebView.class);
			mail.putExtra("home", URLhome);
			mail.putExtra("title", Title);
			startActivity(mail);
			break;
		case R.id.btnYouTube:
			URLhome = "http://m.youtube.com/results?search_query=Antoniuscollege&oq=Antoniuscollege&aq=f&aqi=&aql=&gs_l=youtube-psuggest.3...4430l12422l0l12750l31l31l9l1l2l0l122l1657l20j1l21l0.";
			Title = "YouTube";
			
			Intent youtube = new Intent();
			youtube.setClass(getActivity(), MyWebView.class);
			youtube.putExtra("home", URLhome);
			youtube.putExtra("title", Title);
			startActivity(youtube);
			break;
		}
	}

	private void showDialog() {
        FragmentManager fm = getFragmentManager();
        TwitterDialog TwitDialog = new TwitterDialog();
        TwitDialog.show(fm, "fragment_edit_name");
    }

	private void showFBDialog() {
        FragmentManager fm = getFragmentManager();
        FacebookDialog FaceDialog = new FacebookDialog();
        FaceDialog.show(fm, "fragment_edit_name");
    }
	
}
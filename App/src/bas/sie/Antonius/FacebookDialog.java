package bas.sie.Antonius;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

public class FacebookDialog extends DialogFragment implements
		DialogInterface.OnClickListener {

	String URLhome;
	String Title;

	public static FacebookDialog newInstance() {
		FacebookDialog dialog = new FacebookDialog();
		Bundle bundle = new Bundle();
		dialog.setArguments(bundle);
		return dialog;
	}

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setCancelable(true);
		int style = DialogFragment.STYLE_NORMAL, theme = 0;
		setStyle(style, theme);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Kies Facebook-account");
		builder.setNegativeButton("Annuleren", this);
		LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View dialogLayout = inflater.inflate(R.layout.dialog, null);
		builder.setView(dialogLayout);

		final String[] items = {"Antoniuscollege Gouda", "SPOT Antoniuscollege Gouda",  "ACG Mediagroep" };

		builder.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, items),
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							URLhome = "http://m.facebook.com/Antoniuscollege";
							Title = "Facebook ACG";
							
							Intent ACG = new Intent();
							ACG.setClass(getActivity(), MyWebView.class);
							ACG.putExtra("home", URLhome);
							ACG.putExtra("title", Title);
							startActivity(ACG);
							break;
						case 1:
							URLhome = "http://m.facebook.com/spotcarmelcollege";
							Title = "Facebook ACG Spot";
							
							Intent SPOT = new Intent();
							SPOT.setClass(getActivity(), MyWebView.class);
							SPOT.putExtra("home", URLhome);
							SPOT.putExtra("title", Title);
							startActivity(SPOT);
							break;
						case 2:
							URLhome = "http://m.facebook.com/pages/ACG-Media/128125633969183";
							Title = "Facebook ACG Media";

							Intent Media = new Intent();
							Media.setClass(getActivity(), MyWebView.class);
							Media.putExtra("home", URLhome);
							Media.putExtra("title", Title);
							startActivity(Media);
							break;

						}
					}
				});
		return builder.create();
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// Dummy method required for the Fragment
		
	}
}

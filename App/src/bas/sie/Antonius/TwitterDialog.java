package bas.sie.Antonius;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

public class TwitterDialog extends DialogFragment implements
		DialogInterface.OnClickListener {

	String URLhome;
	String Title;

	public static TwitterDialog newInstance() {
		TwitterDialog dialog = new TwitterDialog();
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
		builder.setTitle("Kies Twitter-account");
		builder.setNegativeButton("Annuleren", this);
		LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View dialogLayout = inflater.inflate(R.layout.dialog, null);
		builder.setView(dialogLayout);

		final String[] items = {"Antoniuscollege Gouda", "SPOT Antoniuscollege Gouda",  "ACG Mediatheek" };

		builder.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, items),
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							URLhome = "https://mobile.twitter.com/#!/ACGouda";

							Intent intent = new Intent(
									Intent.ACTION_VIEW);
							intent.setData(Uri.parse(URLhome));
							startActivity(intent);
							break;
						case 1:
							URLhome = "https://mobile.twitter.com/#!/Spot_ACG";

							Intent intent1 = new Intent(
									Intent.ACTION_VIEW);
							intent1.setData(Uri.parse(URLhome));
							startActivity(intent1);
							break;
						case 2:
							URLhome = "https://mobile.twitter.com/#!/ACGmediatheek";

							Intent intent2 = new Intent(
									Intent.ACTION_VIEW);
							intent2.setData(Uri.parse(URLhome));
							startActivity(intent2);
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

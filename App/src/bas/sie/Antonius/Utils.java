package bas.sie.Antonius;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
	private static int sTheme;

	public final static int THEME_DEFAULT = 0;
	public final static int THEME_SHERLOCK_LIGHT = 1;
	public final static int THEME_SHERLOCK = 2;

	/**
	 * Set the theme of the Activity, and restart it by creating a new Activity
	 * of the same type.
	 */
	public static void changeToTheme(Activity activity, int theme)
	{
		sTheme = theme;
		activity.finish();

		activity.startActivity(new Intent(activity, activity.getClass()));
	}

	/** Set the theme of the activity, according to the configuration. */
	public static void onActivityCreateSetTheme(Activity activity)
	{
		switch (sTheme)
		{
		default:
		case THEME_DEFAULT:
			break;
		case THEME_SHERLOCK_LIGHT:
			activity.setTheme(R.style.Theme_Sherlock_Light);
			break;
		case THEME_SHERLOCK:
			activity.setTheme(R.style.Theme_Sherlock);
			break;
		}
	}
}

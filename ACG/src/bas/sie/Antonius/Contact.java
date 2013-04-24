package bas.sie.Antonius;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;

public class Contact extends SherlockListFragment {

	String Info;
	String TeacherAb;

	@Override
	public void onActivityCreated(Bundle arg0) {
		super.onActivityCreated(arg0);
		String[] countries = getResources().getStringArray(R.array.teachers_array);
	    setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.contact, countries));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {
		case 0:
			TeacherAb = "gaa";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nGAalders@carmelcollegegouda.nl";
			break;
		case 1:
			TeacherAb = "wab";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nWAbspoel@carmelcollegegouda.nl";
			break;
		case 2:
			TeacherAb = "aba";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nABakker@carmelcollegegouda.nl";
			break;
		case 3:
			TeacherAb = "jbe";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJBenjamens@carmelcollegegouda.nl";
			break;
		case 4:
			TeacherAb = "pbe";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nPBenten@carmelcollegegouda.nl";
			break;
		case 5:
			TeacherAb = "jvb";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJvandenBerg@carmelcollegegouda.nl";
			break;
		case 6:
			TeacherAb = "avb";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nAvanBloois@carmelcollegegouda.nl";
			break;
		case 7:
			TeacherAb = "jbo";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJBode@carmelcollegegouda.nl";
			break;
		case 8:
			TeacherAb = "hbo";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHBolscher@carmelcollegegouda.nl";
			break;
		case 9:
			TeacherAb = "mbr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMBouwmeester@carmelcollegegouda.nl";
			break;
		case 10:
			TeacherAb = "mdb";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMdeBruijn@carmelcollegegouda.nl";
			break;
		case 11:
			TeacherAb = "jco";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJCox@carmelcollegegouda.nl";
			break;
		case 12:
			TeacherAb = "rvd";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nRvanDiermen@carmelcollegegouda.nl";
			break;
		case 13:
			TeacherAb = "ceb";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nCEbskamp@carmelcollegegouda.nl";
			break;
		case 14:
			TeacherAb = "wee";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nWEenhuizen@carmelcollegegouda.nl";
			break;
		case 15:
			TeacherAb = "cfe";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nCFernald@carmelcollegegouda.nl";
			break;
		case 16:
			TeacherAb = "cvg";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nCvanGend@carmelcollegegouda.nl";
			break;
		case 17:
			TeacherAb = "wgr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nWGrens@carmelcollegegouda.nl";
			break;
		case 18:
			TeacherAb = "agr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nAvanGroningen@carmelcollegegouda.nl";
			break;
		case 19:
			TeacherAb = "hgr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHGrootenhuijs@carmelcollegegouda.nl";
			break;
		case 20:
			TeacherAb = "mhe";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMHeerema@carmelcollegegouda.nl";
			break;
		case 21:
			TeacherAb = "jdh";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJdeHeij@carmelcollegegouda.nl";
			break;
		case 22:
			TeacherAb = "tho";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nTHorrevorts@carmelcollegegouda.nl";
			break;
		case 23:
			TeacherAb = "jin";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJInsulani@carmelcollegegouda.nl";
			break;
		case 24:
			TeacherAb = "cja";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nCJanssen@carmelcollegegouda.nl";
			break;
		case 25:
			TeacherAb = "mdg";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMdeJong@carmelcollegegouda.nl";
			break;
		case 26:
			TeacherAb = "lkr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nLKrijnen@carmelcollegegouda.nl";
			break;
		case 27:
			TeacherAb = "jkr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJKrijtenburg@carmelcollegegouda.nl";
			break;
		case 28:
			TeacherAb = "mla";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMLangeveld@carmelcollegegouda.nl";
			break;
		case 29:
			TeacherAb = "wlo";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nWLogtenberg@carmelcollegegouda.nl";
			break;
		case 30:
			TeacherAb = "amu";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nAMunting@carmelcollegegouda.nl";
			break;
		case 31:
			TeacherAb = "wot";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nWOtte@carmelcollegegouda.nl";
			break;
		case 32:
			TeacherAb = "hro";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHRomijn@carmelcollegegouda.nl";
			break;
		case 33:
			TeacherAb = "svs";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nSvanderSande@carmelcollegegouda.nl";
			break;
		case 34:
			TeacherAb = "dsc";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nDSchouten@carmelcollegegouda.nl";
			break;
		case 35:
			TeacherAb = "jsc";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJSchwarze@carmelcollegegouda.nl";
			break;
		case 36:
			TeacherAb = "psh";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nPShankar@carmelcollegegouda.nl";
			break;
		case 37:
			TeacherAb = "psm";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nPSmit@carmelcollegegouda.nl";
			break;
		case 38:
			TeacherAb = "jsp";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJSpitsbaard@carmelcollegegouda.nl";
			break;
		case 39:
			TeacherAb = "mvs";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMvanSwaaij@carmelcollegegouda.nl";
			break;
		case 40:
			TeacherAb = "mvk";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMVerbree@carmelcollegegouda.nl";
			break;
		case 41:
			TeacherAb = "hve";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHVester@carmelcollegegouda.nl";
			break;
		case 42:
			TeacherAb = "hvi";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHVink@carmelcollegegouda.nl";
			break;
		case 43:
			TeacherAb = "rvo";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHVoorsluijs@carmelcollegegouda.nl";
			break;
		case 44:
			TeacherAb = "evo";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nEVos@carmelcollegegouda.nl";
			break;
		case 45:
			TeacherAb = "adv";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nAdeVries@carmelcollegegouda.nl";
			break;
		case 46:
			TeacherAb = "ywe";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nYWesthuis@carmelcollegegouda.nl";
			break;
		case 47:
			TeacherAb = "mwi";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMWiekart@carmelcollegegouda.nl";
			break;
		case 48:
			TeacherAb = "bdw";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nBdeWilde@carmelcollegegouda.nl";
			break;
		case 49:
			TeacherAb = "fvz";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nFvanZoest@carmelcollegegouda.nl";
			break;
		case 50:
			TeacherAb = "imt";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nIMordhorst@carmelcollegegouda.nl";
			break;
		case 51:
			TeacherAb = "rpk";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nRPeek@carmelcollegegouda.nl";
			break;
		case 52:
			TeacherAb = "mht";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMvanderHorst@carmelcollegegouda.nl";
			break;
		case 53:
			TeacherAb = "jae";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJAdriaanse@carmelcollegegouda.nl";
			break;
		case 54:
			TeacherAb = "jvd";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJvanDriel@carmelcollegegouda.nl";
			break;
		case 55:
			TeacherAb = "jhn";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJHoebergen@carmelcollegegouda.nl";
			break;
		case 56:
			TeacherAb = "brn";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nBReuten@carmelcollegegouda.nl";
			break;
		case 57:
			TeacherAb = "ews";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nEWillems@carmelcollegegouda.nl";
			break;
		case 58:
			TeacherAb = "vmr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nVMeyer@carmelcollegegouda.nl";
			break;
		case 59:
			TeacherAb = "jvv";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJvandeVorst@carmelcollegegouda.nl";
			break;
		case 60:
			TeacherAb = "rgd";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nRGraafland@carmelcollegegouda.nl";
			break;
		case 61:
			TeacherAb = "mpr";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nMPrins@carmelcollegegouda.nl";
			break;
		case 62:
			TeacherAb = "jgs";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJGijsberts@carmelcollegegouda.nl";
			break;
		case 63:
			TeacherAb = "cvl";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nCvanderLinden@carmelcollegegouda.nl";
			break;
		case 64:
			TeacherAb = "hdv";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHdeVries@carmelcollegegouda.nl";
			break;
		case 65:
			TeacherAb = "jbh";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nJBosch@carmelcollegegouda.nl";
			break;
		case 66:
			TeacherAb = "mha";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nAHamidy@carmelcollegegouda.nl";
			break;
		case 67:
			TeacherAb = "svw";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nSvandeWerken@carmelcollegegouda.nl";
			break;
		case 68:
			TeacherAb = "hnu";
			Info = "Afkorting: \n" + TeacherAb
					+ "\n\nMailadres: \nHNuvelstein@carmelcollegegouda.nl";
			break;
		}
		Intent contact = new Intent();
		contact.setClass(getActivity(), TeacherInfo.class);
		contact.putExtra("contact", Info);
		contact.putExtra("abbrev", TeacherAb);
		startActivityForResult(contact, 0);
	}
}
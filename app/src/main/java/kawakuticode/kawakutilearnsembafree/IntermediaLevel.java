package kawakuticode.kawakutilearnsembafree;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.File;

/**
 * @author Russelius Ernestius
 * 
 */

public class IntermediaLevel extends ListFragment {

	private String intermediats[];
	private Integer[] imageId;
	private ProgressDialog progressDialog;
	private String[] contents = new String[2];
	private Integer[] imageButton;

	public IntermediaLevel() {

		intermediats = new String[] { "giro basico", "saida homem",
				"saida mulher",  };

		imageId = new Integer[] { R.drawable.icones1, R.drawable.icones2,
				R.drawable.icones3};
		imageButton = new Integer[] { R.drawable.arrow, R.drawable.arrow,
				R.drawable.arrow};
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListAdapter listAdapter = new CustomList(getActivity(), intermediats,
				imageId, imageButton);
		setListAdapter(listAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {


        return inflater.inflate(R.layout.list_fragment, container, false);
	}

	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {

		String item = (String) list.getAdapter().getItem(position);

		String url = "";
		String folder = "/semba/";
		File toPlay;

		if (isExternalStorageAvailable() == true) {
			String imagePath = Environment.getExternalStorageDirectory()
					.toString() + folder;

			switch (item) {

			case "giro basico":

				toPlay = new File(imagePath, item);

				int sizegb = 22634150;

				if (toPlay.exists() && toPlay.length() == sizegb) {

					launchVideoPlayer(toPlay);

				} else if ((toPlay.exists() || toPlay.length() < sizegb)
						&& isOnline() == false) {

					showAlertDialog(getActivity(), "No Internet Connection",
							"Turn On your Connection to Download the file.",
							false);
					break;

				} else if ((toPlay.exists() || toPlay.length() < sizegb)
						&& isOnline() == true) {

					if (checkSpaceOnCard(sizegb) == true) {
						showAlertDialog(
								getActivity(),
								"No Enough Space ",
								"Delete some file on your sdCard and try again.",
								false);
						break;
					} else {

						url = "https://dl.dropboxusercontent.com/s/d0ltioff7w4r87r/giro%20basico.mp4?dl=1&token_hash=AAG-uoTDb9NunI6eZoblMGqaatgTIijAi96gtu1-rn7vrQ";
						contents[0] = url;
						contents[1] = toPlay.getName();

						new DownloadAsyncFile(getActivity(), progressDialog)
								.execute(contents);

					}
				}
				break;

			case "saida homem":

				toPlay = new File(imagePath, item);

				int sizesh = 14701029;

				if (toPlay.exists() && toPlay.length() == sizesh) {

					launchVideoPlayer(toPlay);

				} else if ((toPlay.exists() || toPlay.length() < sizesh)
						&& isOnline() == false) {

					showAlertDialog(getActivity(), "No Internet Connection",
							"Turn On your Connection to Download the file.",
							false);
					break;

				} else if ((toPlay.exists() || toPlay.length() < sizesh)
						&& isOnline() == true) {

					if (checkSpaceOnCard(sizesh) == true) {
						showAlertDialog(
								getActivity(),
								"No Enough Space ",
								"Delete some file on your sdCard and try again.",
								false);
						break;
					} else {

						url = "https://dl.dropboxusercontent.com/s/qi96qht83iuv1o7/saida%20homem.mp4?dl=1&token_hash=AAE7oo8PFJ4keOKgcUUmHqMq1MRN1d5JITIqZYk43nMJlQ";
						contents[0] = url;
						contents[1] = toPlay.getName();

						new DownloadAsyncFile(getActivity(), progressDialog)
								.execute(contents);

					}
				}
				break;
			case "saida mulher":

				toPlay = new File(imagePath, item);
				int sizesm = 21300811;
				if (toPlay.exists() && toPlay.length() == sizesm) {

					launchVideoPlayer(toPlay);

				} else if ((toPlay.exists() || toPlay.length() < sizesm)
						&& isOnline() == false) {

					showAlertDialog(getActivity(), "No Internet Connection",
							"Turn On your Connection to Download the file.",
							false);
					break;

				} else if ((toPlay.exists() || toPlay.length() < sizesm)
						&& isOnline() == true) {

					if (checkSpaceOnCard(sizesm) == true) {
						showAlertDialog(
								getActivity(),
								"No Enough Space ",
								"Delete some file on your sdCard and try again.",
								false);
						break;
					} else {

						url = "https://dl.dropboxusercontent.com/s/xe9uuewbbli4j9b/saida%20mulher.mp4?dl=1&token_hash=AAENUSft-LsyipNkN0ikCGoVDcwMQJhrY6qnZRJBPlTuqA";
						contents[0] = url;
						contents[1] = toPlay.getName();

						new DownloadAsyncFile(getActivity(), progressDialog)
								.execute(contents);
					}
				}
				break;
			default:
				break;
			}
		}

		else {
			showAlertDialog(getActivity(), "External Card Not Available",
					"Insert Your SDCard to Read/Write Files", false);
		}

	}

	public void launchVideoPlayer(File videoFile) {

		Intent myIntent = new Intent(getActivity(), VideoViewActivity.class);

		myIntent.putExtra("pathVideo", videoFile.getAbsolutePath());
		getActivity().startActivity(myIntent);

	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getActivity()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

	/**
	 * Function to display simple Alert Dialog
	 * 
	 * @param context
	 *            - application context
	 * @param title
	 *            - alert dialog title
	 * @param message
	 *            - alert message
	 * @param status
	 *            - success/failure (used to set icon)
	 * */
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		// Setting alert dialog icon
		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}

	@SuppressLint("NewApi")
	public boolean checkSpaceOnCard(int sizeOfFile)

	{
		return Environment.getExternalStorageDirectory().getTotalSpace() < sizeOfFile ? true
				: false;
	}

	public boolean isExternalStorageAvailable() {
		String state = Environment.getExternalStorageState();

		return Environment.MEDIA_MOUNTED.equals(state) ? true : false;
	}

}

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

public class ConfirmedLevel extends ListFragment {

	private String confirmeds[];
	private Integer[] imageId;

	private ProgressDialog progressDialog;
	private String[] contents = new String[2];
	private Integer[] imageButton;

	public ConfirmedLevel() {
		confirmeds = new String[] { "saida jajao", "saida invertida",
		};

		imageId = new Integer[] { R.drawable.icones5, R.drawable.icones6,};

		imageButton = new Integer[] { R.drawable.arrow, R.drawable.arrow,
				};
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListAdapter listAdapter = new CustomList(getActivity(), confirmeds,
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

			case "saida jajao":

				toPlay = new File(imagePath, item);

				int sizesj = 14206758;
				if (toPlay.exists() && toPlay.length() == sizesj) {

					launchVideoPlayer(toPlay);

				} else if ((toPlay.exists() || toPlay.length() < sizesj)
						&& isOnline() == false) {

					showAlertDialog(getActivity(), "No Internet Connection",
							"Turn On your Connection to Download the file.",
							false);
					break;

				} else if ((toPlay.exists() || toPlay.length() < sizesj)
						&& isOnline() == true) {

					if (checkSpaceOnCard(sizesj) == true) {
						showAlertDialog(
								getActivity(),
								"No Enough Space ",
								"Delete some file on your sdCard and try again.",
								false);
						break;
					} else {

						url = "https://dl.dropboxusercontent.com/s/805phjqe6eqh9vc/toque%202014_1.mp4?dl=1&token_hash=AAGKUJ85prPzEmswBTnbtwIKixAlnb2HTEykyyhv4hLDFg";
						contents[0] = url;
						contents[1] = toPlay.getName();

						new DownloadAsyncFile(getActivity(), progressDialog)
								.execute(contents);

					}
				}
				break;
			case "saida invertida":

				toPlay = new File(imagePath, item);

				int sizesi = 17155466;
				if (toPlay.exists() && toPlay.length() == sizesi) {

					launchVideoPlayer(toPlay);

				} else if ((toPlay.exists() || toPlay.length() < sizesi)
						&& isOnline() == false) {

					showAlertDialog(getActivity(), "No Internet Connection",
							"Turn On your Connection to Download the file.",
							false);
					break;

				} else if ((toPlay.exists() || toPlay.length() < sizesi)
						&& isOnline() == true) {

					if (checkSpaceOnCard(sizesi) == true) {
						showAlertDialog(
								getActivity(),
								"No Enough Space ",
								"Delete some file on your sdCard and try again.",
								false);
						break;
					} else {

						url = "https://dl.dropboxusercontent.com/s/3gg6gu9ouo8t1n3/toque%202014_2.mp4?dl=1&token_hash=AAH0ClTyn2m07Psz6eDkLtsTncIApAWWZ1-ALvaUxyFi4A";
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
		} else {
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
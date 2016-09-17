package kawakuticode.kawakutilearnsembafree;

/**
 * @author Russelius Ernestius
 */

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

import static android.content.Context.CONNECTIVITY_SERVICE;

@SuppressLint("NewApi")
public class BeginnersLevel extends ListFragment {


    private String beginners[];
    Integer[] imageId;
    Integer[] imageButton;

    private ProgressDialog progressDialog;
    private String[] contents = new String[2];

    public BeginnersLevel() {

        beginners = new String[]{"welcome", "a pega", "a base",
                "ginga homem", "ginga mulher",};

        imageId = new Integer[]{R.drawable.welcome, R.drawable.pega,
                R.drawable.base, R.drawable.xhomem, R.drawable.gmulher,

        };
        imageButton = new Integer[]{R.drawable.ic_play_lesson, R.drawable.ic_play_lesson,
                R.drawable.ic_play_lesson, R.drawable.ic_play_lesson, R.drawable.ic_play_lesson};


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter listAdapter = new CustomList(getActivity(), beginners,
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

                case "welcome":

                    toPlay = new File(imagePath, item);

                    int filesize = 21382365;

                    if (toPlay.exists() && toPlay.length() == filesize) {

                        launchVideoPlayer(toPlay);

                    } else if ((toPlay.exists() || (toPlay.length() < filesize))
                            && isOnline() == false) {

                        showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((toPlay.exists() || toPlay.length() < filesize)
                            && isOnline() == true) {

                        if (checkSpaceOnCard(filesize) == true) {
                            showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                        } else {
                            url = "https://dl.dropboxusercontent.com/s/61b28019t0yhfc1/welcome.mp4?dl=1&token_hash=AAHY3jSqBALx9ESRGYJdqKOtWNicej7_AeVxNSMNoNj2tw";
                            contents[0] = url;
                            contents[1] = toPlay.getName();

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);
                        }
                    }

                    break;

                case "a pega":

                    toPlay = new File(imagePath, item);
                    int filesizep = 26072785;

                    if (toPlay.exists() && toPlay.length() == filesizep) {

                        launchVideoPlayer(toPlay);

                    } else if ((toPlay.exists() || toPlay.length() < filesizep)
                            && isOnline() == false) {

                        showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((toPlay.exists() || toPlay.length() < filesizep)
                            && isOnline() == true) {
                        if (checkSpaceOnCard(filesizep) == true) {
                            showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {
                            url = "https://dl.dropboxusercontent.com/s/dkighbg2pa30veq/apega.mp4?dl=1&token_hash=AAGY3omz_EJ7o-pjdSuUhoHuOWiKXnBsyB1HfbOS_ay6XA";

                            contents[0] = url;
                            contents[1] = toPlay.getName();

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);
                        }
                    }
                    break;

                case "a base":

                    toPlay = new File(imagePath, item);
                    int filesizeb = 34119704;

                    if (toPlay.exists() && toPlay.length() == filesizeb) {

                        launchVideoPlayer(toPlay);

                    } else if ((toPlay.exists() || toPlay.length() < filesizeb)
                            && isOnline() == false) {

                        showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((toPlay.exists() || toPlay.length() < filesizeb)
                            && isOnline() == true) {

                        if (checkSpaceOnCard(filesizeb) == true) {
                            showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {

                            url = "https://dl.dropboxusercontent.com/s/zo1uly0zoz10wpb/base.mp4?dl=1&token_hash=AAFdlttc_DWe9legfev7rwe3v179xqlZHa7FiVu8iW9-GA";
                            contents[0] = url;
                            contents[1] = toPlay.getName();

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);
                        }
                    }
                    break;

                case "ginga homem":

                    toPlay = new File(imagePath, item);

                    int filesizegm = 48068344;

                    if (toPlay.exists() && toPlay.length() == filesizegm) {

                        launchVideoPlayer(toPlay);

                    } else if ((toPlay.exists() || toPlay.length() < filesizegm)
                            && isOnline() == false) {

                        showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((toPlay.exists() || toPlay.length() < filesizegm)
                            && isOnline() == true) {

                        if (checkSpaceOnCard(filesizegm) == true) {
                            showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {

                            url = "https://dl.dropboxusercontent.com/s/9qu65cqfx7vil5c/gingahomem.mp4?dl=1&token_hash=AAFxyGrfdC34vKvordZVBRl30lQMMDDSVH3ZBpbeoZp2Fg";
                            contents[0] = url;
                            contents[1] = toPlay.getName();

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);

                        }
                    }
                    break;

                case "ginga mulher":

                    toPlay = new File(imagePath, item);

                    int filesizegl = 41607264;

                    if (toPlay.exists() && toPlay.length() == filesizegl) {

                        launchVideoPlayer(toPlay);

                    } else if ((toPlay.exists() || toPlay.length() < filesizegl)
                            && isOnline() == false) {

                        showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On Your Connection to Download the file.",
                                false);
                        break;

                    } else if ((toPlay.exists() || toPlay.length() < filesizegl)
                            && isOnline() == true) {

                        if (checkSpaceOnCard(filesizegl) == true) {
                            showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {

                            url = "https://dl.dropboxusercontent.com/s/uczu9ln0hc45r3a/gingamulher.mp4?dl=1&token_hash=AAF53vcHJfAKjS1APGRf6bOAxKv-57FP4ACDIyu5Z1VaCA";

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
        startActivity(myIntent);

    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity()
                .getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    /**
     * Function to display simple Alert Dialog
     *
     * @param context - application context
     * @param title   - alert dialog title
     * @param message - alert message
     * @param status  - success/failure (used to set icon)
     */
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
package kawakuticode.kawakutilearnsembafree;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;

import java.io.File;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by russeliusernestius on 26/12/16.
 */

public class Utilities {

    private FragmentActivity frag_activity;
    private Context mContext;


    public Utilities(FragmentActivity frag_activity) {
        this.frag_activity = frag_activity;
    }

    public Utilities(Context mContext) {
        this.mContext = mContext;
    }

    public FragmentActivity getFrag_activity() {
        return frag_activity;
    }

    public void setFrag_activity(FragmentActivity frag_activity) {
        this.frag_activity = frag_activity;
    }

    public void launchVideoPlayer(File videoFile) {
        Intent myIntent = new Intent(this.getFrag_activity(), VideoViewActivity.class);
        myIntent.putExtra("pathVideo", videoFile.getAbsolutePath());
        this.getFrag_activity().startActivity(myIntent);
    }


    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getFrag_activity().getSystemService(CONNECTIVITY_SERVICE);
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

    public void checkExternalCard() {
        if (isExternalStorageAvailable() != true) {
            showAlertDialog(this.getFrag_activity(), "External Card Not Available",
                    "Insert Your SDCard to Read/Write Files", false);
        }
    }
    /* Receive filePath from doInBackgroung and launch the video player */

    public void launchVideoPlayerByPath(String filepath) {
        Intent myIntent = new Intent(mContext, VideoViewActivity.class);
        myIntent.putExtra("pathVideo", filepath);
        mContext.startActivity(myIntent);
    }


    private String getFileExtension(String path) {
        String name = path;
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}

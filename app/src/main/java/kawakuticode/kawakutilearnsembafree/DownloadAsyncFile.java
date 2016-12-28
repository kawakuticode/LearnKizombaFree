package kawakuticode.kawakutilearnsembafree;

/**
 * @author Russelius Ernestius
 */

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@SuppressLint("NewApi")
public class DownloadAsyncFile extends AsyncTask<String, Integer, String> {

    private static final String APP_TAG = "l_semba";
    private Context mContext;
    ProgressDialog mProgress;
    Utilities utilities;
    SurfaceHolder holder;

    public DownloadAsyncFile(Context context, ProgressDialog progressDialog) {
        this.mContext = context;
        this.mProgress = progressDialog;
        utilities = new Utilities(context);

    }

    @Override
    public void onPreExecute() {
        mProgress = new ProgressDialog(mContext);
        mProgress.setMessage("Downloading the video Lesson \nPlease wait...");
        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgress.setIndeterminate(false);
        mProgress.setMax(100);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        mProgress.setProgress(values[0]);

    }

    @Override
    protected String doInBackground(String... f_url) {

        int count;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        File videoFile = null;
        FileOutputStream fileOutput;
        File sdDir = Environment.getExternalStorageDirectory();
        String folder = "/semba";

        if (sdDir.exists() && sdDir.canWrite()) {

            File testDir = new File(sdDir + folder);
            testDir.mkdir();

            if (testDir.exists() && testDir.canWrite()) {

                videoFile = new File(testDir + "/" + f_url[1]);

                try {

                    videoFile.createNewFile();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (videoFile.exists() && videoFile.canWrite()) {

                    try {

                        URL url = new URL(f_url[0]);
                        URLConnection conection = url.openConnection();
                        conection.connect();

                        // getting file length
                        int lenghtOfFile = Integer.parseInt(f_url[2]);
                        // input stream to read file - with 8k buffer
                        InputStream input = new BufferedInputStream(
                                url.openStream(), 8192);

                        // Output stream to write file
                        fileOutput = new FileOutputStream(videoFile);

                        byte data[] = new byte[1024];

                        long total = 0;

                        while ((count = input.read(data)) != -1) {
                            if (isCancelled()) {

                                break;
                            }

                            total += count;
                            // publishing the progress....
                            // After this onProgressUpdate will be called
                            publishProgress((int) ((total * 100) / lenghtOfFile));

                            // writing data to file
                            fileOutput.write(data, 0, count);

                        }

                        // flushing output
                        fileOutput.flush();

                        // closing streams
                        fileOutput.close();
                        input.close();

                    } catch (Exception e) {

                        Log.e(APP_TAG, e.getMessage());

                    }

                } else {

                    Log.e(APP_TAG, "error writing to file");
                }

            } else {
                Log.e(APP_TAG, "ERROR, unable to write to /sdcard/test_folder");
            }
            // } else {
            Log.e(APP_TAG, "ERROR, /sdcard path not available");
        }

        return videoFile.getAbsolutePath();

    }

    @Override
    protected void onPostExecute(String f_url) {
        mProgress.dismiss();
        utilities.launchVideoPlayerByPath(f_url);
    }


}

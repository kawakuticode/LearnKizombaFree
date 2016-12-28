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
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

@SuppressLint("NewApi")
public class BeginnersLevel extends ListFragment {

    ListView classListView = null;
    private List<Lesson> beginner_lessons;

    private String[] titles;
    Integer[] thumbnails;
    Integer[] imageButton;

    Utilities utilities;

    private ProgressDialog progressDialog;
    private String[] contents = new String[3];


    private void prepareLesson() {

        titles = new String[]{"welcome", "a pega", "a base",
                "ginga homem", "ginga mulher"};

        thumbnails = new Integer[]{R.drawable.welcome, R.drawable.pega,
                R.drawable.base, R.drawable.xhomem, R.drawable.gmulher};

    }

    public BeginnersLevel() {
        prepareLesson();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter listAdapter = new CustomList(getActivity(), titles,
                thumbnails, imageButton);
        setListAdapter(listAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);

        return rootView;
    }


    @Override
    public void onListItemClick(ListView list, View v, int position, long id) {

        String item = (String) list.getAdapter().getItem(position);

        String url = "";

        String folder = "/semba/";
        File temp_file;
        int temp_file_size;
        utilities = new Utilities(getActivity());

        if (utilities.isExternalStorageAvailable() == true) {

            String imagePath = Environment.getExternalStorageDirectory()
                    .toString() + folder;

            switch (item) {

                case "welcome":
                    temp_file = new File(imagePath, item);
                    temp_file_size = new Integer(11128489);

                    if (temp_file.exists() && temp_file.length() == temp_file_size) {

                        utilities.launchVideoPlayer(temp_file);

                    } else if ((temp_file.exists() || (temp_file.length() < temp_file_size))
                            && utilities.isOnline() == false) {

                        utilities.showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == true) {

                        if (utilities.checkSpaceOnCard(temp_file_size) == true) {
                            utilities.showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                        } else {
                            url = "https://drive.google.com/uc?export=download&id=0B2w_WoypwqQGUlJIdjdwREI0QzQ";
                            contents[0] = url;
                            contents[1] = temp_file.getName();
                            contents[2] = String.valueOf(temp_file_size);

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);
                        }
                    }

                    break;

                case "a pega":

                    temp_file = new File(imagePath, item);
                    temp_file_size = new Integer(16840132);

                    if (temp_file.exists() && temp_file.length() == temp_file_size) {

                        utilities.launchVideoPlayer(temp_file);

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == false) {

                        utilities.showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == true) {
                        if (utilities.checkSpaceOnCard(temp_file_size) == true) {
                            utilities.showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {
                            url = "https://drive.google.com/uc?export=download&id=0B2w_WoypwqQGOElpVjc2eDV2cVE";
                            contents[0] = url;
                            contents[1] = temp_file.getName();
                            contents[2] = String.valueOf(temp_file_size);

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);
                        }
                    }
                    break;

                case "a base":

                    temp_file = new File(imagePath, item);
                    temp_file_size = new Integer(21176620);

                    if (temp_file.exists() && temp_file.length() == temp_file_size) {

                        utilities.launchVideoPlayer(temp_file);

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == false) {

                        utilities.showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == true) {

                        if (utilities.checkSpaceOnCard(temp_file_size) == true) {
                            utilities.showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {

                            url = "https://drive.google.com/uc?export=download&id=0B2w_WoypwqQGSVY3aWRQS1BvczQ";
                            contents[0] = url;
                            contents[1] = temp_file.getName();
                            contents[2] = String.valueOf(temp_file_size);

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);
                        }
                    }
                    break;

                case "ginga homem":

                    temp_file = new File(imagePath, item);

                    temp_file_size = new Integer(9091789);

                    if (temp_file.exists() && temp_file.length() == temp_file_size) {

                        utilities.launchVideoPlayer(temp_file);

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == false) {

                        utilities.showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On your Connection to Download the file.",
                                false);
                        break;

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == true) {

                        if (utilities.checkSpaceOnCard(temp_file_size) == true) {
                            utilities.showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {

                            url = "https://drive.google.com/uc?export=download&id=0B2w_WoypwqQGVFh2dzlkRUgwcWc";                            contents[0] = url;
                            contents[1] = temp_file.getName();
                            contents[2] = String.valueOf(temp_file_size);

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);

                        }
                    }
                    break;

                case "ginga mulher":
                    temp_file = new File(imagePath, item);
                    temp_file_size = new Integer(25531633);

                    if (temp_file.exists() && temp_file.length() == temp_file_size) {
                        utilities.launchVideoPlayer(temp_file);
                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == false) {

                        utilities.showAlertDialog(getActivity(), "No Internet Connection",
                                "Turn On Your Connection to Download the file.",
                                false);
                        break;

                    } else if ((temp_file.exists() || temp_file.length() < temp_file_size)
                            && utilities.isOnline() == true) {

                        if (utilities.checkSpaceOnCard(temp_file_size) == true) {
                            utilities.showAlertDialog(
                                    getActivity(),
                                    "No Enough Space ",
                                    "Delete some file on your sdCard and try again.",
                                    false);
                            break;
                        } else {
                            url = "https://drive.google.com/uc?export=download&id=0B2w_WoypwqQGMzNXdmt4MWRzWFk";
                            contents[0] = url;
                            contents[1] = temp_file.getName();
                            contents[2] = String.valueOf(temp_file_size);

                            new DownloadAsyncFile(getActivity(), progressDialog)
                                    .execute(contents);

                        }
                    }
                    break;


                default:
                    break;
            }
        } else {
            utilities.showAlertDialog(getActivity(), "External Card Not Available",
                    "Insert Your SDCard to Read/Write Files", false);
        }
    }


}

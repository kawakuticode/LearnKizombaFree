package kawakuticode.kawakutilearnsembafree;
/**
 * @author Russelius Ernestius
 *
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    private final Integer[] imageButton;


    public CustomList(Activity context, String[] web, Integer[] imageId, Integer[] imageButton) {


        super(context, R.layout.row_lesson, web);

        this.context = context;
        this.web = web;
        this.imageId = imageId;
        this.imageButton = imageButton;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        View rowView;
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Configuration config = context.getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 400) {
            rowView = inflater.inflate(R.layout.row_lesson_tablet, parent, false);
        } else {
            rowView = inflater.inflate(R.layout.row_lesson, parent, false);
        }

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        txtTitle.setGravity(Gravity.CENTER_VERTICAL);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        ImageView playIcon = (ImageView) rowView.findViewById(R.id.playbutton);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);
        //playIcon.setImageResource(imageButton[position]);


        return rowView;
    }
}
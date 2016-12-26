package kawakuticode.kawakutilearnsembafree;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by russeliusernestius on 26/12/16.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.MyViewHolder> {



    private Context mContext;
    private List<Lesson> lessons = Collections.emptyList();


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail, star_status;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.txt);
            star_status = (ImageView) itemView.findViewById(R.id.starbutton);
            thumbnail = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public LessonAdapter(Context mContext, List<Lesson> lessons) {
        this.mContext = mContext;
        this.lessons = lessons;
    }


    @Override
    public LessonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lesson, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LessonAdapter.MyViewHolder holder, int position) {

        Lesson lesson = lessons.get(position);
        holder.title.setText(lesson.getTitle());
        holder.thumbnail.setImageResource(lesson.getThumbnail());
        holder.star_status.setImageResource(lesson.getStar_status());
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }
}

package kawakuticode.kawakutilearnsembafree;

/**
 * Created by russeliusernestius on 26/12/16.
 */

public class Lesson {




    private String title;
    private int thumbnail;
    private int star_status;


 public  Lesson() {

 }
    public Lesson(String title, int thumbnail, int star_status) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.star_status = star_status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getStar_status() {
        return star_status;
    }

    public void setStar_status(int star_status) {
        this.star_status = star_status;
    }
}

package inclass_06.group5.com.foxnewsapp;

import android.content.Context;

/**
 * Created by pawan on 2/22/2016.
 */
public class News {

    String title,description,pubDate,link,thumbnail;
    Context context;

    public News() {
    }

    public News(Context context){
        this.context = context;
    }

    public News(String title, String description, String pubDate, String link, String thumbnail) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

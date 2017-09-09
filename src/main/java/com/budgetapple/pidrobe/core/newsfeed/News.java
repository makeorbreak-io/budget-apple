package com.budgetapple.pidrobe.core.newsfeed;


import java.io.Serializable;
import java.util.Calendar;

/**
 * Class that represents a news feed containing source, title, date and an image
 *
 * @author ricardo
 * @project pidrobe
 */
public class News implements Serializable {

    /**
     * News feed source
     */
    private final String source;
    /**
     * News feed title
     */
    private final String title;
    /**
     * Date news feed was published
     */
    private final Calendar publishedAt;
    /**
     * News feed imageURL
     */
    private final String imageURL;

    /**
     * Default constructor for a news feed
     *
     * @param source      news feed source
     * @param title       news feed title
     * @param publishedAt date
     * @param imageURL    imageURL
     */
    public News(String source, String title, Calendar publishedAt, String imageURL) {
        this.source = source;
        this.title = title;
        this.publishedAt = publishedAt;
        this.imageURL = imageURL;
    }

    //GETTERS

    /**
     * @return news source
     */
    public String getSource() {
        return source;
    }

    /**
     * @return news title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return news feed date
     */
    public Calendar getPublishedAt() {
        return publishedAt;
    }

    /**
     * @return news feed imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param o
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (!source.equals(news.source)) return false;
        if (!title.equals(news.title)) return false;
        if (!publishedAt.equals(news.publishedAt)) return false;
        return imageURL.equals(news.imageURL);
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + publishedAt.hashCode();
        result = 31 * result + imageURL.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\nSource: " + source +
                "\nTitle: " + title +
                "\nPublished at: " + publishedAt.getTime() +
                "\nImage url: " + imageURL.toString();
    }
}

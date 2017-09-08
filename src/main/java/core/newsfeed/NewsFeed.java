package core.newsfeed;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class NewsFeed implements Serializable {

    private final List<News> newsList;

    public NewsFeed() {
        newsList = new LinkedList<>();
    }

    public List<News> getNews() {
        return newsList;
    }

    public boolean addNews(News news) {
        return newsList.add(news);
    }

    public boolean removeNews(News news) {
        return newsList.remove(news);
    }
}

package com.budgetapple.pidrobe.core.services;

import com.budgetapple.pidrobe.core.newsfeed.News;
import com.budgetapple.pidrobe.core.newsfeed.NewsFeed;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class NewsService extends Thread {

    private static final String ARTICLES_URL = "https://newsapi.org/v1/articles";
    private static final String SOURCES_URL = "https://newsapi.org/v1/sources?language=en";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    /**
     * Hourly update
     */
    private static final int TIMEOUT = 3600 * 1000;
    private static NewsFeed newsFeed = null;
    private String apiKey;

    private String source;

    public NewsService(String apiKey) {
        this.apiKey = apiKey;
    }

    public static NewsFeed getNews() {
        return newsFeed;
    }

    @Override
    public void run() {
        try {
            //TODO Choose source
            newsFeed = getNews("ign");

            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Grabs the top news from a given source
     *
     * @param sourceID Source
     * @return List of news
     */
    private NewsFeed getNews(String sourceID) {
        RestService restService = new RestService();
        NewsFeed newsFeed = new NewsFeed();

        try {
            //Gets the source by the sourceID
            JSONObject jsonResponse = restService.sendGet(SOURCES_URL);
            getSource(jsonResponse, sourceID);

            jsonResponse = restService.sendGet(ARTICLES_URL + "?source=" + sourceID + "&apiKey=" + apiKey);

            //Adds parsed news to the news feed
            parseNews(jsonResponse, newsFeed);
        } catch (IOException | java.text.ParseException | ParseException e) {
            e.printStackTrace();
        }

        return newsFeed;
    }

    /**
     * Will parse Json News Response.
     *
     * @param jsonObject
     * @return
     * @throws ParseException
     */
    private void parseNews(JSONObject jsonObject, NewsFeed newsFeed) throws ParseException, IOException, java.text.ParseException {
        JSONArray articleList = (JSONArray) jsonObject.get("articles");

        for (Object jsonObj : articleList) {

            //Gets title
            String title = (String) ((JSONObject) jsonObj).get("title");

            //Gets URL Image
            String urlToImage = (String) ((JSONObject) jsonObj).get("urlToImage");

            //Gets publishing date
            Calendar publishedAt = getPublishedAt((JSONObject) jsonObj);

            //Adds news to the list
            newsFeed.addNews(createNews(title, urlToImage, publishedAt));
        }
    }

    public Calendar getPublishedAt(JSONObject jsonObject) throws java.text.ParseException {
        String date = (String) (jsonObject).get("publishedAt");

        Calendar publishedAt = Calendar.getInstance();
        publishedAt.setTime(dateFormat.parse(date));

        return publishedAt;
    }


    private News createNews(String title, String urlToImage, Calendar publishedAt) throws MalformedURLException {
        return new News(source, title, publishedAt, urlToImage);
    }

    /**
     * Gets the correct source name given a source ID
     *
     * @param jsonObject
     * @param sourceID
     */
    private void getSource(JSONObject jsonObject, String sourceID) {
        JSONArray sourceList = (JSONArray) jsonObject.get("sources");

        for (Object jsonObj : sourceList) {
            String thisSourceID = (String) ((JSONObject) jsonObj).get("id");

            if (sourceID.equals(thisSourceID)) {
                source = (String) ((JSONObject) jsonObj).get("name");
                break;
            }
        }
    }
}



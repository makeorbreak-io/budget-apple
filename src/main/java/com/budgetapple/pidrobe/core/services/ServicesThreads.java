package com.budgetapple.pidrobe.core.services;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class ServicesThreads {

    private static final String NEWS_API_KEY = "2d183a8bd561481aba8065ae504d88ac";

    private static final String APP_ID = "f26768c8c6cae1724b64060af97ecff9";

    private static final String CITY_ID = "2735941";

    public ServicesThreads() {
        startThreads();
    }

    private void startThreads() {
        new NewsService(NEWS_API_KEY).start();
        new ForecastService(APP_ID, CITY_ID).start();
    }


}

package com.budgetapple.pidrobe.application.weather;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.newsfeed.News;
import com.budgetapple.pidrobe.core.weather.Temperature;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller
 *
 * Created by Ricardo
 */
public class DefaultScreenController {

    private final PiDrobe piDrobe;
    private Temperature currentTemperature;

    public DefaultScreenController() {
        this.piDrobe = PiDrobe.getInstance();
        temperature();
    }

    /**
     * Returns the local date
     * @return current date
     */
    public String localDate(){
        LocalDate localDate = LocalDate.now();
        return DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
    }

    /**
     * Method that retrieves the current temperature
     */
    private void temperature(){
       currentTemperature = piDrobe.getForecast().getCurrent().getTemperature();
    }
    /**
     * Return the maximum temp
     * @return maximum temp
     */
    public String maxTemp(){
        return String.valueOf(currentTemperature.getMaximum());
    }

    /**
     * Return the minimum temp
     * @return minimum temp
     */
    public String minTemp(){
        return String.valueOf(currentTemperature.getMinimum());
    }

    /**
     * Return current temp
     * @return current temp
     */
    public String currentTemp(){
        return String.valueOf(currentTemperature.getCurrent());
    }

    /**
     * Return news source
     * @return news source outlet
     */
    public String newsSource(){
        return piDrobe.getNewsFeed().getSource();
    }

    /**
     * Returns the news list
     * @return news list
     */
    public List<News> newsFeed(){
        return piDrobe.getNewsFeed().getNews();
    }



}

package com.budgetapple.pidrobe.application.weather;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.newsfeed.News;
import com.budgetapple.pidrobe.core.weather.Temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        return String.valueOf(round(toCelsius(currentTemperature.getMaximum()),1));
    }

    /**
     * Return the minimum temp
     * @return minimum temp
     */
    public String minTemp(){
        return String.valueOf(round(toCelsius(currentTemperature.getMinimum()),1));
    }

    /**
     * Return current temp
     * @return current temp
     */
    public String currentTemp(){
        return String.valueOf(round(toCelsius(currentTemperature.getCurrent()),0));

    }

    public String weatherDesc(){
        return piDrobe.getForecast().getCurrent().getWeatherDescription();
    }

    /**
     *
     * @return
     */
    public String chanceOfPrecipitation(){
       return String.valueOf(round(piDrobe.getForecast().getCurrent().getRain(),2));
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

    /**
     * Converts value from kelvin to celsius
     * @param value
     * @return
     */
    private double toCelsius(Double value) {
        return value-272.15;
    }

    /**
     * Method that rounds a number
     * @param value
     * @param places
     * @return
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}

package com.budgetapple.pidrobe.webapp;

import com.budgetapple.pidrobe.application.weather.DefaultScreenController;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.ui.UI;

import java.io.File;


/**
 * The Default Screen page serves has the main page for the user
 * after the he first interacts with the application
 */
public class DefaultScreenView extends DefaultScreenDesign implements View {

    /**
     * Allows navigation between views
     */
    private Navigator navigator;
    /**
     * View Navigator ID
     */
    public static final String NAME = "default_screen";
    /**
     * Default Screen Controller
     */
    private DefaultScreenController theController;

    /**
     *
     */
    public DefaultScreenView() {
        navigator = UI.getCurrent().getNavigator();
        theController = new DefaultScreenController();
        labelsLogic();
        weatherImageLoader();
        buttonAction();
        newsHandler();
    }

    /**
     * This method contains all of this view label's logic
     */
    private void labelsLogic() {

        //Displays the current date ("yyy/MM/dd")
        dateLabel.setValue("<b><font color=\"white\">" + theController.localDate() + "</font></b>");

        //Displays the maximum temp expected for the day
        maxTempLabel.setValue("<b><font color=\"white\"> Max (ºC) " + theController.maxTemp() + "</font></b>");

        //Displays the minimum temp expected for the day
        minTempLabel.setValue("<b><font color=\"white\"> Min (ºC) " + theController.minTemp() + "</font></b>");

        //Displays the current temp
        currentTempLabel.setValue("<font size=\"7\" color=\"white\">" + theController.currentTemp() + "ºC</font>");

        //Chance of Precipitation
        precipLabel.setValue("<b><font color=\"white\"> Chance of Precipitation (%) "
                + theController.chanceOfPrecipitation() + "</font></b>");


    }

    /**
     * Weather Image Loader method
     */
    private void weatherImageLoader() {

        //Template for the Weather Image loader Algorithm
        if (theController.weatherDesc().equalsIgnoreCase("clear sky")) {
            weatherImage.setSource(new FileResource(new File("../src/main/resources/" +
                            "com/budgetapple/pidrobe/icons/clear.png")));
        } else if (theController.weatherDesc().equalsIgnoreCase("light rain")) {
            weatherImage.setSource(new FileResource(new File("../src/main/resources/" +
                            "com/budgetapple/pidrobe/icons/rain.png")));
        }
    }


    /**
     * Method responsible for handling the news headlines
     *
     * (HARDCODED)
     */
    private void newsHandler() {

        newsLayout.setCaption("<b>" + theController.newsSource() + " Headlines </b>");

        news1Title.setValue(theController.newsFeed().get(0).getTitle());
        news2Title.setValue(theController.newsFeed().get(1).getTitle());
        news3Title.setValue(theController.newsFeed().get(2).getTitle());

        news1Image.setSource(new ExternalResource(theController.newsFeed().get(0).getImageURL()));
        news2Image.setSource(new ExternalResource(theController.newsFeed().get(1).getImageURL()));
        news3Image.setSource(new ExternalResource(theController.newsFeed().get(2).getImageURL()));


    }

    /**
     *
     */
    private void buttonAction() {

        myClosetButton.addClickListener(clickEvent -> {
            //FIXME java.lang.IllegalArgumentException: bound must be positive
            // navigator.navigateTo(DisplayOutfitView.NAME);
        });
    }


}
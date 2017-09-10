package com.budgetapple.pidrobe.webapp;

import com.budgetapple.pidrobe.application.weather.DefaultScreenController;
import com.budgetapple.pidrobe.core.clothes.Gender;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.ui.UI;

import java.io.File;
import java.util.LinkedList;
import java.util.List;


/**
 * The Default Screen page serves has the main page for the user
 * after the he first interacts with the application
 */
public class DefaultScreenView extends DefaultScreenDesign implements View {

    /**
     * View Navigator ID
     */
    public static final String NAME = "default_screen";
    /**
     * Allows navigation between views
     */
    private Navigator navigator;
    /**
     * Default Screen Controller
     */
    private DefaultScreenController theController;

    private Gender gender;

    /**
     *
     */
    public DefaultScreenView() {
        navigator = UI.getCurrent().getNavigator();
        theController = new DefaultScreenController();
        myClosetButton.setEnabled(false);

        comboLogic();
        labelsLogic();
        weatherImageLoader();
        buttonAction();
        newsHandler();
    }

    private void comboLogic() {
        List<String> genders = new LinkedList<>();
        genders.add("Male");
        genders.add("Female");

        genderComboBox.setEmptySelectionAllowed(false);
        genderComboBox.setItems(genders);

        genderComboBox.addValueChangeListener(event -> {
            switch (event.getValue()){
                case "Male":
                    gender = Gender.MALE;
                    break;

                case "Female":
                    gender = Gender.FEMALE;
                    break;
            }

            myClosetButton.setEnabled(true);
        });
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
            weatherImage.setSource(new FileResource(new File("files/weather/clear.png")));
        } else if (theController.weatherDesc().equalsIgnoreCase("light rain")) {
            weatherImage.setSource(new FileResource(new File("files/weather/rain.png")));
        }
    }


    /**
     * Method responsible for handling the news headlines
     * <p>
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
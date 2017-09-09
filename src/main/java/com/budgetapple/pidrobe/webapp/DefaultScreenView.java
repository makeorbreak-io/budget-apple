package com.budgetapple.pidrobe.webapp;

import com.budgetapple.pidrobe.application.weather.DefaultScreenController;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Image;
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

    }

    /**
     * This method contains all of this view label's logic
     */
    private void labelsLogic() {

        //Displays the current date ("yyy/MM/dd")
        dateLabel.setValue("<b>"+theController.localDate()+"</b>");

        //Displays the maximum temp expected for the day
        maxTempLabel.setValue("Max (ºC) " + theController.maxTemp());

        //Displays the minimum temp expected for the day
        minTempLabel.setValue("Min (ºC) " + theController.minTemp());

        //Displays the current temp
        currentTempLabel.setValue("<font size=\"190\">"+theController.currentTemp()+"ºC</font>");

    }

    /**
     *
     */
    private void weatherImageLoader(){

        //Template
        weatherImageLayout.addComponentAsFirst(new Image("Clear",
                new FileResource(new File("/home/ricardo/BudgetApple (Porto Summer Code)" +
                        "/src/main/resources/com/budgetapple/pidrobe/icons/clear.png"))));

    }

    /**
     *
     */
    private void newsHandler(){
        newsLayout.setCaption(theController.newsSource());

       /* for(News news : theController.newsFeed()){
            news
        }*/


    }

    /**
     *
     */
    private void buttonAction(){

        myClosetButton.addClickListener(clickEvent -> {
           //navigator.navigateTo();
        });
    }




}
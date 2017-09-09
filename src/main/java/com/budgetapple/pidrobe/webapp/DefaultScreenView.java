package com.budgetapple.pidrobe.webapp;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.UI;


/**
 * The FrontPage serves as an entry point to the main app
 * User is asked for his city (next view)
 */
public class DefaultScreenView extends DefaultScreenDesign implements View {


    Navigator navigator;
    public static final String NAME = "default_screen";

    public DefaultScreenView() {
        navigator = UI.getCurrent().getNavigator();
        buttonLogic();

    }

    /**
     * This method holds all the logic present in the frontpage
     */
    private void buttonLogic() {

       // navigator.navigateTo();

    }
}
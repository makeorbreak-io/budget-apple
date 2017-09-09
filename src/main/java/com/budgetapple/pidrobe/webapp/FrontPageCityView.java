package com.budgetapple.pidrobe.webapp;

import com.budgetapple.pidrobe.PiDrobe;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The FrontPage serves as an entry point to the main app
 * User is asked for his city (next view)
 */
public class FrontPageCityView extends FrontPageCityDesign implements View {

    /**
     * Allows the navigation between views
     */
    Navigator navigator;
    /**
     * View Navigator ID
     */
    public static final String NAME = "frontpage_city";
    /**
     * Application Instance
     */
    private PiDrobe piDrobe;

    public FrontPageCityView() {
        navigator = UI.getCurrent().getNavigator();
        piDrobe = PiDrobe.getInstance();
        buttonLogic();

    }

    /**
     * This method holds all the logic present in the frontpage
     */
    private void buttonLogic() {


        forwardButton.addClickListener(clickEvent -> {
            String name = nameTextField.getValue();

            if (name.isEmpty()) {
                Notification.show("Please insert your city name to proceed!", Notification.Type.WARNING_MESSAGE);
                nameTextField.focus();
                nameTextField.clear();
            } else {
                Pattern p = Pattern.compile("^\\w+$");
                Matcher m = p.matcher(name);
                if (m.find()) {
                    // match
                    //Notification.show("Your town is " + name + "!", Notification.Type.HUMANIZED_MESSAGE);
                    navigator.navigateTo(DefaultScreenView.NAME);

                } else {
                    Notification.show("Enter a correct name");
                    nameTextField.focus();
                    nameTextField.clear();
                }
            }

        });

        forwardButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }
}

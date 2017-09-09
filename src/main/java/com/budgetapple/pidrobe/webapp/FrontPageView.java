package com.budgetapple.pidrobe.webapp;

import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The FrontPage serves as an entry point to the main app
 * User is asked for his name and city (next view)
 */
public class FrontPageView extends FrontPageDesign implements View {

    Navigator navigator;
    public static final String NAME = "frontpage_name";

    public FrontPageView() {
        navigator = UI.getCurrent().getNavigator();
        buttonLogic();
    }

    /**
     * This method holds all the logic present in the frontpage
     */
    private void buttonLogic() {

        forwardButton.addClickListener(clickEvent -> {
            String name = nameTextField.getValue();

            if (name.isEmpty()) {
                Notification.show("Please insert your name to proceed!", Notification.Type.WARNING_MESSAGE);
                nameTextField.focus();
                nameTextField.clear();
            } else {
                Pattern p = Pattern.compile("^[A-Z][a-z]+\\s[A-Z][a-z]+|[A-Z][a-z]+$");
                Matcher m = p.matcher(name);
                if (m.find()) {
                    // match
                    navigator.navigateTo(FrontPageCityView.NAME);
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

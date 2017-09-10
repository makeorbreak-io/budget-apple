package com.budgetapple.pidrobe.webapp;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.application.Outfit.CreateOutfitPresetController;
import com.budgetapple.pidrobe.core.clothes.Outfit;
import com.budgetapple.pidrobe.core.clothes.Preset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class NewPresetView extends NewPresetDesign implements View {

    private Navigator navigator;
    private Window window;
    private Outfit outfit;

    public NewPresetView(Window window, Outfit outfit) {
        navigator = UI.getCurrent().getNavigator();
        this.window = window;
        this.outfit = outfit;
        buttonAction();
    }

    private void buttonAction() {
        backButton.addClickListener(clickEvent -> {
            window.close();
        });

        saveButton.addClickListener(clickEvent -> {
            savePreset();
            window.close();
        });

    }

    private void savePreset() {
        String name = nameTextField.getValue();
        CreateOutfitPresetController controller = new CreateOutfitPresetController();
        controller.setUpperBodyItems(outfit.getUpperBody());
        controller.setLowerBodyItem(outfit.getLowerBody());
        controller.setFootwear(outfit.getFootwear());
        controller.save(name);
        Notification.show("Preset has been saved!");
    }

}

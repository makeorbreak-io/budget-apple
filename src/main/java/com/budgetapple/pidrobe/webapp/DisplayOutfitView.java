package com.budgetapple.pidrobe.webapp;

import com.budgetapple.pidrobe.application.Outfit.SuggestOutfitController;
import com.budgetapple.pidrobe.application.weather.DefaultScreenController;
import com.budgetapple.pidrobe.core.clothes.Gender;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Outfit;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DisplayOutfitView extends DisplayOutfitDesign implements View {

    public static final String NAME = "outfit_menu";
    Navigator navigator;
    Item lowerBody;
    Item footwear;
    private SuggestOutfitController controller;
    private Outfit outfit;
    private DefaultScreenController theController;

    public DisplayOutfitView(Gender gender) throws IOException {

        navigator = UI.getCurrent().getNavigator();
        controller = new SuggestOutfitController(gender);
        theController = new DefaultScreenController();
        bootUpOutfit();
        bootUpWeatherInfo();
        buttonAction();
    }

    private void bootUpOutfit() throws IOException {

        outfit = controller.generateSuggestedOutfit();

        lowerBody = outfit.getLowerBody();
        footwear = outfit.getFootwear();

        List<Item> upperBodyMap = outfit.getUpperBody();

        byte[] imageLowerBodyByte = Base64.getDecoder().decode(lowerBody.getImageBase64());
        byte[] imageFootwearByte = Base64.getDecoder().decode(footwear.getImageBase64());
        byte[][] imagesUpperBodyByte;

        imagesUpperBodyByte = new byte[3][];

        int cont = 0;
        for (Item item : upperBodyMap) {

            if (cont == 0) {
                imagesUpperBodyByte[0] = Base64.getDecoder().decode(item.getImageBase64());
            }

            if (cont == 1) {
                imagesUpperBodyByte[1] = Base64.getDecoder().decode(item.getImageBase64());
            }

            if (cont == 2) {
                imagesUpperBodyByte[2] = Base64.getDecoder().decode(item.getImageBase64());
            }

            cont++;
        }

        FileOutputStream fos = new FileOutputStream("tempFile");
        fos.write(imageLowerBodyByte);
        FileResource resLowerBody = new FileResource(new File("tempFile"));
        fos.write(imageFootwearByte);
        FileResource resFootwear = new FileResource(new File("tempFile"));

        LinkedList<FileResource> upperBodyResourceList = new LinkedList<>();

        for (int i = 0; i < cont; i++) {
            fos.write(imagesUpperBodyByte[i]);
            upperBodyResourceList.add(new FileResource(new File("tempFile")));

            if (i == 0) {
                upperBodyImage0.setSource(upperBodyResourceList.get(0));
            }
            if (i == 1) {
                upperBodyImage1.setSource(upperBodyResourceList.get(1));
            }
            if (i == 2) {
                upperBodyImage2.setSource(upperBodyResourceList.get(2));
            }
        }

        fos.close();

        lowerBodyImage.setSource(resLowerBody);
        footwearImage.setSource(resFootwear);

    }

    private void bootUpWeatherInfo() {

        /*currentTempLabel.setValue("<font size=\"7\" color=\"white\">" + theController.currentTemp() + "ºC</font>");

        if (theController.weatherDesc().equalsIgnoreCase("clear sky")) {
            weatherImage.setSource(new FileResource(new File("../src/main/resources/" +
                    "com/budgetapple/pidrobe/icons/clear.png")));
        } else if (theController.weatherDesc().equalsIgnoreCase("light rain")) {
            weatherImage.setSource(new FileResource(new File("../src/main/resources/" +
                    "com/budgetapple/pidrobe/icons/rain.png")));
        }*/

    }

    private void buttonAction() {
        backButton.addClickListener(clickEvent -> {
            navigator.navigateTo(DefaultScreenView.NAME);
        });

        saveNewPreset.addClickListener(clickEvent -> {
            Window window = new Window("Choose name for preset");
            window.setParent(this);
            window.center();
            window.setModal(true);
            window.setSizeFull();
            window.setContent(new NewPresetView(window, outfit));
            UI.getCurrent().addWindow(window);
        });
    }

}

package com.budgetapple.pidrobe.application.Outfit;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Outfit;
import com.budgetapple.pidrobe.core.weather.Temperature;
import com.budgetapple.pidrobe.core.weather.Weather;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class SuggestOutfitController {

    public Outfit generateSuggestedOutfit() {
        Outfit suggestedOutfit;

        Weather weather = PiDrobe.getInstance().getForecast().getCurrent();
        Temperature temperature = weather.getTemperature();

        double currentTemp = temperature.getCurrent();

        if (currentTemp > 25 && weather.getRain() == 0) {
            suggestedOutfit = summerOutfit();
        } else if (currentTemp > 15) {
            suggestedOutfit = springOutfit();
        } else if (currentTemp > 5) {
            suggestedOutfit = fallOutfit();
        } else {
            suggestedOutfit = winterOutfit();
        }

        return suggestedOutfit;
    }

    private Outfit summerOutfit() {
        Item lowerBody, footwear;
        List<Item> upperBody = new LinkedList<>();

        //Gets items with the most temperature index
        List<Item> allSummerItems = PiDrobe.getInstance().getItemsWithTempIndex(Item.MAX_TEMP_INDEX, Item.MAX_TEMP_INDEX);

        List<Item> tShirts = new LinkedList<>();
        List<Item> shorts = new LinkedList<>();
        List<Item> shoes = new LinkedList<>();

        for (Item item : allSummerItems) {
            if (item.getCategoryID() == 10) {   //If T-Shirts
                tShirts.add(item);
            } else if (item.getCategoryID() == 5) { //If shorts
                shorts.add(item);
            } else if (item.getCategoryID() == 2 || item.getCategoryID() == 4) {    //If flip-flops or normal shoes
                shoes.add(item);
            }
        }

        upperBody.add(getRandomItemFromList(tShirts));
        lowerBody = getRandomItemFromList(shorts);
        footwear = getRandomItemFromList(shoes);

        return new Outfit(upperBody, lowerBody, footwear);
    }

    private Outfit springOutfit() {
        return null;
    }

    private Outfit fallOutfit() {
        return null;
    }

    private Outfit winterOutfit() {
        return null;
    }

    public Item getRandomItemFromList(List<Item> items) {
        Random random = new Random();
        int index = random.nextInt(items.size());
        return items.get(index);
    }
}

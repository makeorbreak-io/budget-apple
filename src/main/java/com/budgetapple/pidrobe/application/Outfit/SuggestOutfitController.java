package com.budgetapple.pidrobe.application.Outfit;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Gender;
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

    Item lowerBody, footwear;
    List<Item> upperBody = new LinkedList<>();
    List<Item> upperBodyHotterList = new LinkedList<>();
    List<Item> upperBodyLighterList = new LinkedList<>();
    List<Item> lowerBodyList = new LinkedList<>();
    List<Item> shoesList = new LinkedList<>();
    private Gender gender;

    public SuggestOutfitController(Gender gender) {
        this.gender = gender;
    }

    public Outfit generateSuggestedOutfit() {
        Outfit suggestedOutfit;

        //Weather weather = PiDrobe.getInstance().getForecast().getCurrent();
        //Temperature temperature = weather.getTemperature();

        //double currentTemp = temperature.getCurrent() - 272.15;
        double currentTemp = 22.0;

        //if (currentTemp > 25 && weather.getRain() == 0) {
        if(currentTemp > 25) {
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

        //Gets items with the most temperature index
        List<Item> allSummerItems = PiDrobe.getInstance().getItemsWithTempIndex(Item.MAX_TEMP_INDEX, Item.MAX_TEMP_INDEX);

        //Filters by gender
        allSummerItems = filterByGender(allSummerItems);

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

        return new Outfit(gender, upperBody, lowerBody, footwear);
    }

    private Outfit springOutfit() { //sugerir 2 peças para upper body

        /*Weather weather = PiDrobe.getInstance().getForecast().getCurrent();
        Temperature temperature = weather.getTemperature();

        double currentTemp = temperature.getCurrent();*/
        double currentTemp = 22;

        List<Item> allSpringItems = PiDrobe.getInstance().getItemsWithTempIndex(2, 3);

        allSpringItems = filterByGender(allSpringItems);

        for (Item item : allSpringItems) {
            if (item.getCategoryID() == 10 && (item.getTemperatureIndex() == 3 || item.getTemperatureIndex() == 4)) {
                upperBodyLighterList.add(item);
            } else if (item.getCategoryID() == 3 || item.getCategoryID() == 6 || item.getCategoryID() == 8) {
                upperBodyHotterList.add(item);
            } else if (item.getCategoryID() == 5 || item.getCategoryID() == 9) {
                lowerBodyList.add(item);
            } else if (item.getCategoryID() == 4) {
                shoesList.add(item);
            }
        }

        upperBody.add(getRandomItemFromList(upperBodyLighterList));
        upperBody.add(getRandomItemFromList(upperBodyHotterList));
        lowerBody = getRandomItemFromList(lowerBodyList);
        footwear = getRandomItemFromList(shoesList);
        System.out.println("\nupper: "+upperBodyLighterList.get(0).getCategoryID()+"upper2: "+upperBodyHotterList.get(0).getCategoryID()+"lower: "+lowerBody.getCategoryID()+"footwear:"+footwear.getCategoryID()+"\n");

        return new Outfit(gender, upperBody, lowerBody, footwear);

    }

    private Outfit fallOutfit() {
        Weather weather = PiDrobe.getInstance().getForecast().getCurrent();
        Temperature temperature = weather.getTemperature();

        double currentTemp = temperature.getCurrent();

        List<Item> allFallItems = PiDrobe.getInstance().getItemsWithTempIndex(1, 2);

        allFallItems = filterByGender(allFallItems);

        for (Item item : allFallItems) {
            if (item.getCategoryID() == 8 && item.getCategoryID() == 10) {
                upperBodyLighterList.add(item);
            } else if (item.getCategoryID() == 3 || item.getCategoryID() == 6 || item.getCategoryID() == 1) {
                upperBodyHotterList.add(item);
            } else if (item.getCategoryID() == 9) {
                lowerBodyList.add(item);
            } else if (item.getCategoryID() == 4 || item.getCategoryID() == 0) {
                shoesList.add(item);
            }
        }

        upperBody.add(getRandomItemFromList(upperBodyLighterList));
        upperBody.add(getRandomItemFromList(upperBodyHotterList));
        lowerBody = getRandomItemFromList(lowerBodyList);
        footwear = getRandomItemFromList(shoesList);

        return new Outfit(gender, upperBody, lowerBody, footwear);

    }

    private Outfit winterOutfit() {
        Weather weather = PiDrobe.getInstance().getForecast().getCurrent();
        Temperature temperature = weather.getTemperature();

        double currentTemp = temperature.getCurrent();

        List<Item> allWinterItems = PiDrobe.getInstance().getItemsWithTempIndex(0, 1);

        allWinterItems = filterByGender(allWinterItems);

        for (Item item : allWinterItems) {
            if (item.getCategoryID() == 8 || item.getCategoryID() == 6) {
                upperBodyLighterList.add(item);
            } else if (item.getCategoryID() == 3 || item.getCategoryID() == 6 || item.getCategoryID() == 1) {
                upperBodyHotterList.add(item);
            } else if (item.getCategoryID() == 9) {
                lowerBodyList.add(item);
            } else if (item.getCategoryID() == 0) {
                shoesList.add(item);
            }
        }

        upperBody.add(getRandomItemFromList(upperBodyLighterList));
        upperBody.add(getRandomItemFromList(upperBodyHotterList));
        upperBody.add(getRandomItemFromList(upperBodyHotterList));
        lowerBody = getRandomItemFromList(lowerBodyList);
        footwear = getRandomItemFromList(shoesList);

        return new Outfit(gender, upperBody, lowerBody, footwear);
    }

    public Item getRandomItemFromList(List<Item> items) {
        /*Random random = new Random();

        System.out.println("\n size:"+items.size()+"\n");

        int randomNum = random.nextInt((items.size()));

        int index = randomNum;

        System.out.println("\n random:"+randomNum+"\n");*/
        return items.get(0);
    }

    private List<Item> filterByGender(List<Item> items) {
        List<Item> itemList = new LinkedList<>();

        for (Item item : items) {
            if (item.getGender().equals(gender) || item.getGender().equals(Gender.UNISEX)) {
                itemList.add(item);
            }
        }

        return itemList;
    }
}

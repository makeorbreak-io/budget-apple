package com.budgetapple.pidrobe.bootstrap.core;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Item;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miguel Cardoso on 10/09/2017.
 */
public class ItemBootstrap {

    public ItemBootstrap() {
        PiDrobe.getInstance().setAllItems(generateItems());
    }

    private List<Item> generateItems() {
        Item tshirt1 = new Item(-1, 10, imageBase64("green_shirt"), "#00ff00", Item.MAX_TEMP_INDEX, true);
        Item tshirt2 = new Item(-1, 10, imageBase64("red_shirt"), "#ff0000", Item.MAX_TEMP_INDEX, true);
        Item tshirt3 = new Item(-1, 10, imageBase64("blue_shirt"), "#0000ff", Item.MAX_TEMP_INDEX, true);
        Item tshirt4 = new Item(-1, 10, imageBase64("white_shirt"), "#ffffff", Item.MAX_TEMP_INDEX, true);
        Item tshirt5 = new Item(-1, 10, imageBase64("black_shirt"), "#000000", Item.MAX_TEMP_INDEX, true);

        Item jeans1 = new Item(-1, 9, imageBase64("jeans1"), "#1560BD", 3, true);
        Item jeans2 = new Item(-1, 9, imageBase64("jeans2"), "#696969", 3, true);
        Item jeans3 = new Item(-1, 9, imageBase64("jeans3"), "#000000", 3, true);
        Item shorts1 = new Item(-1, 5, imageBase64("shorts1"), "#1560BD", Item.MAX_TEMP_INDEX, true);
        Item shorts2 = new Item(-1, 5, imageBase64("shorts2"), "#000000", Item.MAX_TEMP_INDEX, true);

        Item shoes1 = new Item(-1, 4, imageBase64("shoes1"), "#000000", 2, true);
        Item shoes2 = new Item(-1, 4, imageBase64("shoes2"), "#000000", 2, true);
        Item shoes3 = new Item(-1, 4, imageBase64("shoes3"), "#111111", 2, true);
        Item flipflop1 = new Item(-1, 2, imageBase64("flipflop1"), "#000000", Item.MAX_TEMP_INDEX, true);
        Item flipflop2 = new Item(-1, 2, imageBase64("flipflop2"), "#00ff00", Item.MAX_TEMP_INDEX, true);

        Item boots1 = new Item(-1, 0, imageBase64("male_boots"), "#A0522D", 1, true);
        Item boots2 = new Item(-1, 0, imageBase64("female_boots"), "#654321", 1, true);

        Item coat1 = new Item(-1, 1, imageBase64("male_coat"), "#393c16", 1, true);
        Item coat2 = new Item(-1, 1, imageBase64("female_coat"), "#f5f5dc", 1, true);

        Item jacket1 = new Item(-1, 3, imageBase64("male_jacket"), "#A0522D", 2, true);
        Item jacket2 = new Item(-1, 3, imageBase64("female_jacket"), "#696969", 2, true);

        Item sleeves1 = new Item(-1, 6, imageBase64("male_shirts"), "#1560BD", 3, true);
        Item sleeves2 = new Item(-1, 6, imageBase64("female_shirts"), "#add8e6", 3, true);

        Item suit1 = new Item(-1, 7, imageBase64("male_suit"), "#000080", 2, true);
        Item suit2 = new Item(-1, 7, imageBase64("female_suit"), "#696969", 2, true);

        Item sweater1 = new Item(-1, 8, imageBase64("male_sweater"), "#696969", 1, true);
        Item sweater2 = new Item(-1, 8, imageBase64("female_sweater"), "#ffa500", 1, true);

        Item vest1 = new Item(-1, 11, imageBase64("male_vest"), "#696969", 2, true);
        Item vest2 = new Item(-1, 11, imageBase64("female_vest"), "#ffa500", 2, true);

        List<Item> itemList = new LinkedList<>();
        itemList.add(tshirt1);
        itemList.add(tshirt2);
        itemList.add(tshirt3);
        itemList.add(tshirt4);
        itemList.add(tshirt5);

        itemList.add(jeans1);
        itemList.add(jeans2);
        itemList.add(jeans3);
        itemList.add(shorts1);
        itemList.add(shorts2);

        itemList.add(shoes1);
        itemList.add(shoes2);
        itemList.add(shoes3);
        itemList.add(flipflop1);
        itemList.add(flipflop2);

        itemList.add(boots1);
        itemList.add(boots2);

        itemList.add(coat1);
        itemList.add(coat2);

        itemList.add(jacket1);
        itemList.add(jacket2);

        itemList.add(sleeves1);
        itemList.add(sleeves2);

        itemList.add(suit1);
        itemList.add(suit2);

        itemList.add(sweater1);
        itemList.add(sweater2);

        itemList.add(vest1);
        itemList.add(vest2);

        return itemList;
    }

    private String imageBase64(String file) {
        try {

            String image = "files/items/" + file + ".jpg";
            byte[] data = Files.readAllBytes(new File(image).toPath());

            return Base64.getEncoder().encodeToString(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

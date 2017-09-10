package com.budgetapple.pidrobe.bootstrap.core;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.vaadin.server.FileResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Item tshirt1 = new Item(10, imageBase64("green_shirt"), "#00ff00", Item.MAX_TEMP_INDEX, true);
        Item tshirt2 = new Item(10, imageBase64("red_shirt"), "#ff0000", Item.MAX_TEMP_INDEX, true);
        Item tshirt3 = new Item(10, imageBase64("blue_shirt"), "#0000ff", Item.MAX_TEMP_INDEX, true);
        Item tshirt4 = new Item(10, imageBase64("white_shirt"), "#ffffff", Item.MAX_TEMP_INDEX, true);
        Item tshirt5 = new Item(10, imageBase64("black_shirt"), "#000000", Item.MAX_TEMP_INDEX, true);

        Item jeans1 = new Item(9, imageBase64("jeans1"), "#1560BD", 3, true);
        Item jeans2 = new Item(9, imageBase64("jeans2"), "#696969", 3, true);
        Item jeans3 = new Item(9, imageBase64("jeans3"), "#000000", 3, true);
        Item shorts1 = new Item(5, imageBase64("shorts1"), "#1560BD", 3, true);
        Item shorts2 = new Item(5, imageBase64("shorts2"), "#000000", 3, true);

        Item shoes1 = new Item(4, imageBase64("shoes1"), "#000000", 3, true);
        Item shoes2 = new Item(4, imageBase64("shoes2"), "#000000", 3, true);
        Item shoes3 = new Item(4, imageBase64("shoes3"), "#111111", 3, true);
        Item flipflop1 = new Item(2, imageBase64("flipflop1"), "#000000", 3, true);
        Item flipflop2 = new Item(2, imageBase64("flipflop2"), "#00ff00", 3, true);

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

        return itemList;
    }

    private String imageBase64(String file) {
        try {

            String image = "C:\\Users\\Miguel Cardoso\\Desktop\\Git\\piDrobe\\src\\main\\resources\\com\\budgetapple\\pidrobe\\icons\\items\\" + file + ".jpg";
            byte[] data = Files.readAllBytes(new File(image).toPath());

            return Base64.getEncoder().encodeToString(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

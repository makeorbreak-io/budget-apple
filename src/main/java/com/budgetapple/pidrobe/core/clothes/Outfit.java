package com.budgetapple.pidrobe.core.clothes;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Outfit implements Serializable {

    /**
     * Links the order of clothing to the item. Example: 0 - T-Shirt, 1 - Shirt on top of T-Shirt, 2 - Coat
     */
    private LinkedHashMap<Integer, Item> upperBody;

    /**
     * Lower body item. Example: pants, shorts, skirts, etc...
     */
    private Item lowerBody;

    /**
     * Shoes, boots, etc...
     */
    private Item footwear;

    /**
     * Rings, glasses, etc...
     */
    private List<Item> accessories;

    public Outfit() {

    }

    public Outfit(List<Item> upperBodyItems, Item lowerBodyItem, Item footwearItem) {
        setUpperBodyItems(upperBodyItems);
        setLowerBodyItem(lowerBodyItem);
        setFootwearItem(footwearItem);
    }

    public void setUpperBodyItems(List<Item> upperBodyItems) {
        int i = 0;

        for (Item item : upperBodyItems) {
            upperBody.put(i, item);
            i++;
        }
    }

    /**
     * Replaces an upperbody item at the given index by the given item
     *
     * @param index
     * @param item
     */
    public void replaceUpperBodyItem(int index, Item item) {
        upperBody.put(index, item);
    }

    public void setLowerBodyItem(Item lowerBody) {
        this.lowerBody = lowerBody;
    }

    public void setAccessories(List<Item> accessories) {
        this.accessories = accessories;
    }

    public void setFootwearItem(Item footwearItem) {
        this.footwear = footwearItem;
    }

    public LinkedHashMap<Integer, Item> getUpperBody() {
        return upperBody;
    }

    public Item getLowerBody() {
        return lowerBody;
    }

    public Item getFootwear() {
        return footwear;
    }

    public List<Item> getAccessories() {
        return accessories;
    }
}

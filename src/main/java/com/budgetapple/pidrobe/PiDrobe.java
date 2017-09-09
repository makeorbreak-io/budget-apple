package com.budgetapple.pidrobe;

import com.budgetapple.pidrobe.core.clothes.Category;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Outfit;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class PiDrobe implements Serializable {

    private List<Item> allItems;

    private List<Outfit> allOutfits;

    private List<Category> allCategories;

    public PiDrobe() {
        this.allItems = new LinkedList<>();
        this.allOutfits = new LinkedList<>();
        this.allCategories = new LinkedList<>();
    }

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }

    public boolean addItem(Item item) {
        return this.allItems.add(item);
    }

    public boolean removeItem(Item item) {
        return this.allItems.remove(item);
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public void setAllOutfits(List<Outfit> allOutfits) {
        this.allOutfits = allOutfits;
    }

    public boolean addOutfit(Outfit outfit) {
        return this.allOutfits.add(outfit);
    }

    public boolean removeOutfit(Outfit outfit) {
        return this.allOutfits.remove(outfit);
    }

    public List<Outfit> getAllOutfits() {
        return allOutfits;
    }

    public void setAllCategories(List<Category> allCategories) {
        this.allCategories = allCategories;
    }

    public boolean addCategory(Category category) {
        return this.allCategories.add(category);
    }

    public boolean removeCategories(Category category) {
        return this.allCategories.remove(category);
    }

    public List<Category> getAllCategories() {
        return allCategories;
    }
}

package com.budgetapple.pidrobe;

import com.budgetapple.pidrobe.core.clothes.Category;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Outfit;
import com.budgetapple.pidrobe.core.clothes.Preset;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class PiDrobe implements Serializable {

    private List<Item> allItems;

    private List<Category> allCategories;

    private List<Preset> allPresets;

    public PiDrobe() {
        this.allItems = new LinkedList<>();
        this.allPresets = new LinkedList<>();
        this.allCategories = new LinkedList<>();
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

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
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

    public void setAllCategories(List<Category> allCategories) {
        this.allCategories = allCategories;
    }

    public List<Preset> getAllPresets() {
        return allPresets;
    }

    public void setAllPresets(List<Preset> allPresets) {
        this.allPresets = allPresets;
    }

    public boolean addPreset(Preset preset) {
        return this.allPresets.add(preset);
    }

    public boolean removePreset(Preset preset) {
        return this.allPresets.remove(preset);
    }
}

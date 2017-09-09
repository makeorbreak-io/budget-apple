package com.budgetapple.pidrobe;

import com.budgetapple.pidrobe.core.clothes.Category;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Preset;
import com.budgetapple.pidrobe.core.newsfeed.NewsFeed;
import com.budgetapple.pidrobe.core.services.ForecastService;
import com.budgetapple.pidrobe.core.services.NewsService;
import com.budgetapple.pidrobe.core.services.ServicesThreads;
import com.budgetapple.pidrobe.core.utils.IO;
import com.budgetapple.pidrobe.core.weather.Forecast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class PiDrobe implements Serializable {

    private static PiDrobe instance;

    private List<Item> allItems;

    private List<Category> allCategories;

    private List<Preset> allPresets;

    private PiDrobe() {
        bootUp();
    }

    public static PiDrobe getInstance() {
        if (instance == null) {
            instance = new PiDrobe();
        }

        return instance;
    }

    private void bootUp() {
        this.allItems = new LinkedList<>();
        this.allPresets = new LinkedList<>();
        this.allCategories = new LinkedList<>();
        new ServicesThreads();

        load();
    }

    private void load() {
        try {
            PiDrobe piDrobe = (PiDrobe) IO.readBinFile("temp");

            this.setAllCategories(piDrobe.allCategories);
            this.setAllItems(piDrobe.allItems);
            this.setAllPresets(piDrobe.allPresets);

        } catch (Exception e) {
            System.out.println("No configuration file found. New instance created.");
        }
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

    public Forecast getForecast() {
        return ForecastService.getForecast();
    }

    public NewsFeed getNewsFeed() {
        return NewsService.getNews();
    }

    private void fillCategories() {
        Category boots = new Category(0, "Boots");
        Category coat = new Category(1, "Coat");
        Category flipflop = new Category(2, "Flip Flop");
        Category jacket = new Category(3, "Jacket");
        Category shoes = new Category(4, "Shoes");
        Category shorts = new Category(5, "Shorts");
        Category sleeves = new Category(6, "Sleeves");
        Category suit = new Category(7, "Suit");
        Category sweater = new Category(8, "Sweater");
        Category trouser = new Category(9, "Trousers");
        Category tshirt = new Category(10, "T-Shirt");
        Category vest = new Category(11, "Vest");

        List<Category> categoriesList = new ArrayList();
        categoriesList.add(boots);
        categoriesList.add(coat);
        categoriesList.add(flipflop);
        categoriesList.add(jacket);
        categoriesList.add(shoes);
        categoriesList.add(shorts);
        categoriesList.add(sleeves);
        categoriesList.add(suit);
        categoriesList.add(sweater);
        categoriesList.add(trouser);
        categoriesList.add(tshirt);
        categoriesList.add(vest);

        allCategories = categoriesList;

    }
}

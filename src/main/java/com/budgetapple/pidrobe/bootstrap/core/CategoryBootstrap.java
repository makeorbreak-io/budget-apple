package com.budgetapple.pidrobe.bootstrap.core;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Category;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miguel Cardoso on 10/09/2017.
 */
public class CategoryBootstrap {

    public CategoryBootstrap() {
        PiDrobe.getInstance().setAllCategories(generateCategories());
    }

    private List<Category> generateCategories() {
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

        List<Category> categoriesList = new LinkedList<>();
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

        return categoriesList;
    }
}

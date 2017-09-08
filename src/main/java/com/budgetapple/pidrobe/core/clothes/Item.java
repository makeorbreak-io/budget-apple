package com.budgetapple.pidrobe.core.clothes;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Item implements Serializable {
    private Category category;

    private String name;

    private Image image;

    private boolean isAvailable;

    public Item(Category category, String name, Image image) {
        this.category = category;
        this.name = name;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Category: " + category + "\nName: " + name;
    }

}

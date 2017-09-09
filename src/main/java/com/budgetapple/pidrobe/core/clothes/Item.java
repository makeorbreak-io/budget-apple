package com.budgetapple.pidrobe.core.clothes;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Item implements Serializable {
    private Category category;

    private String name;

    private Color color;

    private int temperatureIndex;

    private Image image;

    private boolean isAvailable;

    public Item() {

    }

    public Item(Category category, String name, Image image, Color color, int temperatureIndex) {
        this.category = category;
        this.name = name;
        this.image = image;
        this.color = color;
        this.temperatureIndex = temperatureIndex;
        this.isAvailable = true;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getColorName() {
        return color.toString();
    }

    public int getTemperatureIndex() {
        return temperatureIndex;
    }

    public void setTemperatureIndex(int temperatureIndex) {
        this.temperatureIndex = temperatureIndex;
    }

    @Override
    public String toString() {
        return "Category: " + category + "\nName: " + name + "\nColor: " + color.toString();
    }

}

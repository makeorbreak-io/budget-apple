package com.budgetapple.pidrobe.core.clothes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Item implements Serializable {
    private Category category;

    private String name;

    private String colorHexa;

    private int temperatureIndex;

    private String imageBase64;

    private boolean isAvailable;

    public Item() {

    }

    @JsonCreator
    public Item(@JsonProperty("category") Category category,
                @JsonProperty("name") String name,
                @JsonProperty("image") String imageBase64,
                @JsonProperty("color_hexa") String colorHexa,
                @JsonProperty("temperature_index") int temperatureIndex,
                @JsonProperty("available") boolean isAvailable) {
        this.category = category;
        this.name = name;
        this.imageBase64 = imageBase64;
        this.colorHexa = colorHexa;
        this.temperatureIndex = temperatureIndex;
        this.isAvailable = isAvailable;
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

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getColorHexa() {
        return colorHexa;
    }

    public void setColorHexa(String colorHexa) {
        this.colorHexa = colorHexa;
    }

    public int getTemperatureIndex() {
        return temperatureIndex;
    }

    public void setTemperatureIndex(int temperatureIndex) {
        this.temperatureIndex = temperatureIndex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (temperatureIndex != item.temperatureIndex) return false;
        if (category != null ? !category.equals(item.category) : item.category != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (colorHexa != null ? !colorHexa.equals(item.colorHexa) : item.colorHexa != null) return false;
        return imageBase64 != null ? imageBase64.equals(item.imageBase64) : item.imageBase64 == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (colorHexa != null ? colorHexa.hashCode() : 0);
        result = 31 * result + temperatureIndex;
        result = 31 * result + (imageBase64 != null ? imageBase64.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", colorHexa=" + colorHexa +
                ", temperatureIndex=" + temperatureIndex +
                ", imageBase64=" + imageBase64 +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

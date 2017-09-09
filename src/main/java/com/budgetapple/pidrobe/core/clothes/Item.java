package com.budgetapple.pidrobe.core.clothes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Item implements Serializable {
    private static int counter = 0;

    public final int id;

    private int categoryID;

    private String colorHexa;

    private int temperatureIndex;

    private String imageBase64;

    private boolean isAvailable;

    public Item() {
        this.id = ++counter;
    }

    @JsonCreator
    public Item(@JsonProperty("id") int id,
                @JsonProperty("categoryID") int categoryID,
                @JsonProperty("image") String imageBase64,
                @JsonProperty("color_hexa") String colorHexa,
                @JsonProperty("temperature_index") int temperatureIndex,
                @JsonProperty("available") boolean isAvailable) {
        this.id = ++counter;
        this.categoryID = categoryID;
        this.imageBase64 = imageBase64;
        this.colorHexa = colorHexa;
        this.temperatureIndex = temperatureIndex;
        this.isAvailable = isAvailable;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getId() {
        return id;
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

        if (categoryID != item.categoryID) return false;
        if (id != item.id) return false;
        if (temperatureIndex != item.temperatureIndex) return false;
        if (isAvailable != item.isAvailable) return false;
        if (colorHexa != null ? !colorHexa.equals(item.colorHexa) : item.colorHexa != null) return false;
        return imageBase64 != null ? imageBase64.equals(item.imageBase64) : item.imageBase64 == null;
    }

    @Override
    public int hashCode() {
        int result = categoryID;
        result = 31 * result + id;
        result = 31 * result + (colorHexa != null ? colorHexa.hashCode() : 0);
        result = 31 * result + temperatureIndex;
        result = 31 * result + (imageBase64 != null ? imageBase64.hashCode() : 0);
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "categoryID=" + categoryID +
                ", id='" + id + '\'' +
                ", colorHexa=" + colorHexa +
                ", temperatureIndex=" + temperatureIndex +
                ", imageBase64=" + imageBase64 +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

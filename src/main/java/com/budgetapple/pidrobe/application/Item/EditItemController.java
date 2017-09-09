package com.budgetapple.pidrobe.application.Item;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Category;
import com.budgetapple.pidrobe.core.clothes.Item;

import java.awt.*;
import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class EditItemController {

    private final PiDrobe piDrobe;

    private final Item item;

    public EditItemController(Item item) {
        this.piDrobe = PiDrobe.getInstance();
        this.item = item;
    }

    public List<Category> getCategories() {
        return piDrobe.getAllCategories();
    }

    public void chooseCategory(Category category) {
        this.item.setCategory(category);
    }

    public void changeName(String name) {
        this.item.setName(name);
    }

    public void changeImage(Image image) {
        this.item.setImage(image);
    }

    public void changeColor(Color color) {
        this.item.setColor(color);
    }

    public void changeTemperatureIndex(int temperatureIndex) {
        this.item.setTemperatureIndex(temperatureIndex);
    }
}

package com.budgetapple.pidrobe.application.Item;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Category;
import com.budgetapple.pidrobe.core.clothes.Item;

import java.awt.*;
import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class CreateItemController {

    private final PiDrobe piDrobe;

    private final Item item;

    public CreateItemController(PiDrobe piDrobe){
        this.piDrobe = piDrobe;
        this.item = new Item();
    }

    public List<Category> getCategories(){
        return piDrobe.getAllCategories();
    }

    public void chooseCategory(Category category){
        this.item.setCategory(category);
    }

    public void setName(String name){
        this.item.setName(name);
    }

    public void setImage(Image image){
        this.item.setImage(image);
    }

    public void setColor(Color color){
        this.item.setColor(color);
    }

    public void setTemperatureIndex(int temperatureIndex){
        this.item.setTemperatureIndex(temperatureIndex);
    }

    public boolean save(){
        return this.piDrobe.addItem(item);
    }
}

package com.budgetapple.pidrobe.application.Item;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Category;
import com.budgetapple.pidrobe.core.clothes.Item;

import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class CreateItemController {

    private final PiDrobe piDrobe;

    private final Item item;

    public CreateItemController(){
        this.piDrobe = PiDrobe.getInstance();
        this.item = new Item();
    }

    public List<Category> getCategories(){
        return piDrobe.getAllCategories();
    }

    public void chooseCategory(Category category){
        this.item.setCategoryID(category.getId());
    }

    public void setImage(String image){
        this.item.setImageBase64(image);
    }

    public void setColor(String color){
        this.item.setColorHexa(color);
    }

    public void setTemperatureIndex(int temperatureIndex){
        this.item.setTemperatureIndex(temperatureIndex);
    }

    public boolean save(){
        return this.piDrobe.addItem(item);
    }
}

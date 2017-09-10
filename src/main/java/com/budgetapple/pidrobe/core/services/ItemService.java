package com.budgetapple.pidrobe.core.services;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;


/**
 * @author Luis on 09/09/2017.
 * @project pidrobe
 */
public class ItemService {
    public ItemService() {
    }

    public String getJsonAllItems() {
        JSONArray array = new JSONArray();

        PiDrobe piDrobe = PiDrobe.getInstance();

        List<Item> items = piDrobe.getAllItems();

        for (Item i : items) {
            JSONObject object = new JSONObject();

            object.put("id", i.getId());
            object.put("category_id", i.getCategoryID());
            object.put("color_hexa", i.getColorHexa());
            object.put("temperature_index", i.getTemperatureIndex());
            object.put("available", i.isAvailable());
            object.put("image", i.getImageBase64());

            array.add(object);
        }

        return array.toJSONString();
    }

    public boolean addNewItem(Item item) {
        if (!PiDrobe.getInstance().getAllItems().contains(item)) {

            PiDrobe.getInstance().addItem(item);

            return true;
        } else {
            return false;
        }
    }
}

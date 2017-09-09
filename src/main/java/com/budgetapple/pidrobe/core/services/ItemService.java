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

    public String getJsonAllItems(){
        JSONArray array = new JSONArray();

        PiDrobe piDrobe = PiDrobe.getInstance();

        List<Item> items = piDrobe.getAllItems();

        for (Item i :
                items) {
            JSONObject object = new JSONObject();
            object.put("name", i.getName());
            object.put("category_name", i.getCategory().getName());
            object.put("color", Integer.toHexString(i.getColor().getRGB()).substring(2));
            object.put("temperature_index", i.getTemperatureIndex());
            object.put("available", i.isAvailable());

            array.add(object);
        }

        JSONObject response = new JSONObject();

        response.put("items", array);

        return response.toJSONString();
    }
}

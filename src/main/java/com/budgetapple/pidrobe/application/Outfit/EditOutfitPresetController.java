package com.budgetapple.pidrobe.application.Outfit;

import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Preset;

import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class EditOutfitPresetController {
    private final Preset preset;

    public EditOutfitPresetController(Preset preset) {
        this.preset = preset;
    }

    public void replaceUpperBodyItem(int i, Item item) {
        preset.getOutfit().replaceUpperBodyItem(i, item);
    }

    public void changeLowerBodyItem(Item lowerBodyItem) {
        preset.getOutfit().setLowerBodyItem(lowerBodyItem);
    }

    public void changeAccessories(List<Item> accessories) {
        preset.getOutfit().setAccessories(accessories);
    }

    public void changeFootwear(Item footwear) {
        preset.getOutfit().setFootwearItem(footwear);
    }

}

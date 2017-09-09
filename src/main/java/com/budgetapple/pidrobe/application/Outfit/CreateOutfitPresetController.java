package com.budgetapple.pidrobe.application.Outfit;

import com.budgetapple.pidrobe.PiDrobe;
import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Outfit;
import com.budgetapple.pidrobe.core.clothes.Preset;

import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class CreateOutfitPresetController {

    private final PiDrobe piDrobe;
    private final Outfit outfit;

    public CreateOutfitPresetController(PiDrobe piDrobe) {
        this.piDrobe = piDrobe;
        this.outfit = new Outfit();
    }

    public void setUpperBodyItems(List<Item> upperBodyItems) {
        this.outfit.setUpperBodyItems(upperBodyItems);
    }

    public void setLowerBodyItem(Item lowerBodyItem) {
        this.outfit.setLowerBodyItem(lowerBodyItem);
    }

    public void setAccessories(List<Item> accessories) {
        this.outfit.setAccessories(accessories);
    }

    public void setFootwear(Item footwear) {
        this.outfit.setFootwearItem(footwear);
    }

    public boolean save() {
        return piDrobe.addOutfit(outfit);
    }
}

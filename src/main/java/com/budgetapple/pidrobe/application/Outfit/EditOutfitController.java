package com.budgetapple.pidrobe.application.Outfit;

import com.budgetapple.pidrobe.core.clothes.Item;
import com.budgetapple.pidrobe.core.clothes.Outfit;

import java.util.List;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class EditOutfitController {
    private final Outfit outfit;

    public EditOutfitController(Outfit outfit) {
        this.outfit = outfit;
    }

    public void replaceUpperBodyItem(int i, Item item) {
        this.outfit.replaceUpperBodyItem(i, item);
    }

    public void changeLowerBodyItem(Item lowerBodyItem) {
        this.outfit.setLowerBodyItem(lowerBodyItem);
    }

    public void changeAccessories(List<Item> accessories) {
        this.outfit.setAccessories(accessories);
    }

    public void changeFootwear(Item footwear) {
        this.outfit.setFootwearItem(footwear);
    }

}

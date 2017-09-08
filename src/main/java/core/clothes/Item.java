package core.clothes;

import java.awt.*;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Item {
    private Category category;

    private String name;

    private Image image;

    private boolean isAvailable;

    public Item(Category category, String name, Image image){
        this.category = category;
        this.name = name;
        this.image = image;
    }
}

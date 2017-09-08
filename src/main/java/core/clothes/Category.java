package core.clothes;

import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Category implements Serializable {
    private String category;

    public Category(String category){
        this.category = category;
    }

    public void setName(String category){
        this.category = category;
    }

    public String getName(){
        return category;
    }
}

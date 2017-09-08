package core.clothes;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Category {
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

package com.budgetapple.pidrobe.core.clothes;

/**
 * Created by Miguel Cardoso on 09/09/2017.
 */
public class Preset {

    private Outfit outfit;

    private String name;

    public Preset(){

    }

    public Preset(Outfit outfit, String name){
        this.outfit = outfit;
        this.name = name;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }
}

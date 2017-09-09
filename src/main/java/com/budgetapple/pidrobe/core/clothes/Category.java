package com.budgetapple.pidrobe.core.clothes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Category implements Serializable {
    private String category;

    @JsonCreator
    public Category(@JsonProperty("category") String category) {
        this.category = category;
    }

    public void setName(String category){
        this.category = category;
    }

    public String getName(){
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category1 = (Category) o;

        return category != null ? category.equals(category1.category) : category1.category == null;
    }

    @Override
    public int hashCode() {
        return category != null ? category.hashCode() : 0;
    }
}

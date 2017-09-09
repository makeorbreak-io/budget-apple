package com.budgetapple.pidrobe.core.clothes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class Category implements Serializable {
    private String category;

    private int id;

    @JsonCreator
    public Category(@JsonProperty("id") int id,
                    @JsonProperty("category") String category) {
        this.id = id;
        this.category = category;
    }

    public String getName() {
        return category;
    }

    public void setName(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category1 = (Category) o;

        if (id != category1.id) return false;
        return category != null ? category.equals(category1.category) : category1.category == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}

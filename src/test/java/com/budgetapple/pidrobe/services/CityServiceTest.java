package com.budgetapple.pidrobe.services;

import com.budgetapple.pidrobe.core.local.City;
import com.budgetapple.pidrobe.core.local.Coordinates;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author Luis on 09/09/2017.
 * @project pidrobe
 */
public class CityServiceTest {
    @Test
    public void getAllCities() throws Exception {
        CityService cityService = new CityService();

        HashMap<String,City> cityHashMap = cityService.getAllCities();

        City expected = new City("707860","Hurzuf","UA", new Coordinates(34.283333,44.549999));
        City actual = cityHashMap.get("707860");

        Assert.assertEquals("Expected is equal to result", expected, actual);

        System.out.println("City hashmap size: " + cityHashMap.size());
    }

}
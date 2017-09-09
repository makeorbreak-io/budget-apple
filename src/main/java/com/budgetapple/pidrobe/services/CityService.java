package com.budgetapple.pidrobe.services;

import com.budgetapple.pidrobe.core.local.City;
import com.budgetapple.pidrobe.core.local.Coordinates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class CityService {

    private static String FILE_DIR = "files/city.list.json";

    /**
     * Constructor
     */
    public CityService() {
    }

    /**
     * Sends a get . Parses Json, building all weathers and returning a new forecast.
     *
     * @return forescast for the next 5 days
     */
    public HashMap<String,City> getAllCities(){
        HashMap<String,City> cityHashMap = new HashMap<>();

        try {
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(new FileReader(new File(FILE_DIR)));
            JSONArray jsonArray = (JSONArray) parsed;


            for (Object obj :
                    jsonArray) {
                City city = parseCity((JSONObject) obj);
                cityHashMap.put(city.getId(), city);
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return cityHashMap;
    }

    /**
     * Parse weather from json object
     *
     * @param jsonCity
     * @return Weather
     */
    private City parseCity(JSONObject jsonCity){
        JSONObject jsonCoord = (JSONObject) jsonCity.get("coord");
        Double lon,lat;
        if(jsonCoord.get("lon") instanceof Long){
            lon = ((Long) jsonCoord.get("lon")).doubleValue();
        }else {
            lon = (Double) jsonCoord.get("lon");
        }
        if(jsonCoord.get("lat") instanceof Long){
            lat = ((Long) jsonCoord.get("lat")).doubleValue();
        }else {
            lat = (Double) jsonCoord.get("lat");
        }

            Coordinates coordinates = new Coordinates(
                lon,
                lat
        );

        City city = new City(
                String.valueOf(jsonCity.get("id")),
                (String) jsonCity.get("name"),
                (String) jsonCity.get("country"),
                coordinates
        );

        return city;
    }
}

package com.budgetapple.pidrobe.services;

import com.budgetapple.pidrobe.core.local.City;
import com.budgetapple.pidrobe.core.local.Coordinates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class CityService {

    private static String FILE_DIR = "city.list.json";

    private String appId;

    /**
     * Constructor
     * @param appId API key
     */
    public CityService(String appId) {
        this.appId = appId;
    }

    /**
     * Sends a get . Parses Json, building all weathers and returning a new forecast.
     *
     * @return forescast for the next 5 days
     */
    public ArrayList<City> getAllCities(){
        ArrayList<City> listCities = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            //TODO Implement DIR of file into here
            Object parsed = parser.parse(new FileReader(FILE_DIR));
            JSONArray jsonArray = (JSONArray) parsed;


            for (Object obj :
                    jsonArray) {
                listCities.add(parseCity((JSONObject) obj));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listCities;
    }

    /**
     * Parse weather from json object
     *
     * @param jsonCity
     * @return Weather
     */
    private City parseCity(JSONObject jsonCity){
        JSONObject jsonCoord = (JSONObject) jsonCity.get("coord");
        Coordinates coordinates = new Coordinates(
                (Double) jsonCoord.get("lon"),
                (Double) jsonCoord.get("lat")
        );

        City city = new City(
                (String) jsonCity.get("id"),
                (String) jsonCity.get("name"),
                (String) jsonCity.get("country"),
                coordinates
        );

        return city;
    }
}

package services;

import core.local.City;
import core.local.Coordinates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class CityService {

    private static String DIR = "city.list.json";

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
            Object parsed = parser.parse("FILE HERE");
            JSONArray jsonArray = (JSONArray) parsed;


            for (Object obj :
                    jsonArray) {
                listCities.add(parseCity((JSONObject) obj));
            }

        } catch (ParseException e) {
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

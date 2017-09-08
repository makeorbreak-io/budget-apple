package services;

import core.weather.Forecast;
import core.weather.Temperature;
import core.weather.Weather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class ForecastService {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?";

    private String appId;

    /**
     * Constructor
     * @param appId API key
     */
    public ForecastService(String appId) {
        this.appId = appId;
    }

    /**
     * Sends a get Forecast. Parses Json, building all weathers and returning a new forecast.
     *
     * @param cityId City ID
     * @return forescast for the next 5 days
     */
    public Forecast getForecast(String cityId){
        LinkedList<Weather> listWeathers = new LinkedList<>();
        RestService restService = new RestService();

        try {
            JSONObject json = restService.sendGet(BASE_URL + "id=" + cityId + "&APPID=" + appId);

            JSONArray jsonWeatherArray = (JSONArray) json.get("list");

            for (Object obj :
                     jsonWeatherArray) {
                listWeathers.add(parseWeather((JSONObject) obj));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Forecast forecast = new Forecast(listWeathers);
        return forecast;
    }

    /**
     * Parse weather from json object
     *
     * @param jsonWeather
     * @return Weather
     */
    private Weather parseWeather(JSONObject jsonWeather){
        Weather weather = new Weather();
        weather.setDate(new Date((Long) jsonWeather.get("dt")));

        JSONObject main = (JSONObject) jsonWeather.get("main");
        Temperature temperature = new Temperature(
                Double.parseDouble((String) main.get("temp")),
                Double.parseDouble((String) main.get("temp_min")),
                Double.parseDouble((String) main.get("temp_max"))
        );
        weather.setTemperature(temperature);
        weather.setPressure(Double.parseDouble((String) main.get("pressure")));
        weather.setSeaLevel(Double.parseDouble((String) main.get("sea_level")));
        weather.setGroundLevel(Double.parseDouble((String) main.get("grnd_level")));
        weather.setHumidity(Integer.parseInt((String) main.get("humidity")));

        JSONObject wt = (JSONObject) ((JSONArray) jsonWeather.get("weather")).get(0);
        weather.setWeather((String) wt.get("main"));
        weather.setWeatherDescription((String) wt.get("description"));

        JSONObject clouds = (JSONObject) jsonWeather.get("clouds");
        weather.setCloudiness(Integer.parseInt((String) clouds.get("all")));

        JSONObject rain = (JSONObject) jsonWeather.get("rain");
        if(rain != null){
            weather.setRain(Double.parseDouble((String) rain.get("3h")));
        }

        JSONObject snow = (JSONObject) jsonWeather.get("snow");
        if(snow != null){
            weather.setSnow(Double.parseDouble((String) rain.get("3h")));
        }

        return weather;
    }
}

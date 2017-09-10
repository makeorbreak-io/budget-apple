package com.budgetapple.pidrobe.core.services;

import com.budgetapple.pidrobe.core.weather.Forecast;
import com.budgetapple.pidrobe.core.weather.Temperature;
import com.budgetapple.pidrobe.core.weather.Weather;
import com.budgetapple.pidrobe.core.weather.Wind;
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
public class ForecastService extends Thread {

    /**
     * Updates every 15 min
     */
    private static final int TIMEOUT = 900 * 1000;
    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?";
    private static Forecast forecast = null;
    private String appId;
    private String cityId;
    /**
     * Constructor
     *
     * @param appId API key
     */
    public ForecastService(String appId,String cityId) {
        this.appId = appId;
        this.cityId = cityId;
    }


    public static Forecast getForecast() {
        return forecast;
    }

    @Override
    public void run() {
        try {
            forecast = getForecast(cityId);

            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a get Forecast. Parses Json, building all weathers and returning a new forecast.
     *
     * @param cityId City ID
     * @return forescast for the next 5 days
     */
    private Forecast getForecast(String cityId) {
        LinkedList<Weather> listWeathers = new LinkedList<>();
        RestService restService = new RestService();

        try {
            JSONObject json = restService.sendGet(BASE_URL + "id=" + cityId + "&APPID=" + appId);

            JSONArray jsonWeatherArray = (JSONArray) json.get("list");

            System.out.println(jsonWeatherArray.toJSONString());
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
    private Weather parseWeather(JSONObject jsonWeather) {
        Weather weather = new Weather();
        weather.setDate(new Date((Long) jsonWeather.get("dt")));

        JSONObject main = (JSONObject) jsonWeather.get("main");

        Double temp,temp_min,temp_max;

        if (main.get("temp") instanceof Long) {
            temp = ((Long) main.get("temp")).doubleValue();
        } else {
            temp = (Double) main.get("temp");
        }
        if (main.get("temp_min") instanceof Long) {
            temp_min = ((Long) main.get("temp_min")).doubleValue();
        } else {
            temp_min = (Double) main.get("temp_min");
        }
        if (main.get("temp_max") instanceof Long) {
            temp_max = ((Long) main.get("temp_max")).doubleValue();
        } else {
            temp_max = (Double) main.get("temp_max");
        }
        Temperature temperature = new Temperature(temp,temp_min,temp_max);

        weather.setTemperature(temperature);
        weather.setPressure((Double) main.get("pressure"));
        if (main.get("sea_level") instanceof Long) {
            weather.setSeaLevel(((Long) main.get("sea_level")).doubleValue());
        } else {
            weather.setSeaLevel((Double) main.get("sea_level"));
        }
        weather.setGroundLevel((Double) main.get("grnd_level"));
        weather.setHumidity(Math.toIntExact((Long) main.get("humidity")));

        JSONObject wt = (JSONObject) ((JSONArray) jsonWeather.get("weather")).get(0);
        weather.setWeather((String) wt.get("main"));
        weather.setWeatherDescription((String) wt.get("description"));

        JSONObject clouds = (JSONObject) jsonWeather.get("clouds");
        weather.setCloudiness(Math.toIntExact((Long) clouds.get("all")));

        JSONObject rain = (JSONObject) jsonWeather.get("rain");
        if (rain != null && rain.get("3h") != null) {
            weather.setRain((Double) rain.get("3h"));
        }

        JSONObject snow = (JSONObject) jsonWeather.get("snow");
        if (snow != null) {
            weather.setSnow((Double) rain.get("3h"));
        }

        /*JSONObject wind = (JSONObject) jsonWeather.get("wind");
        if (wind != null) {
            weather.setWind(new Wind((Double)jsonWeather.get("speed"),(Double)jsonWeather.get("deg")));
        }*/

        return weather;
    }


}

package services;

import core.weather.Weather;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class WeatherService {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?";

    private String appId;

    public WeatherService(String appId) {
        this.appId = appId;
    }

    public Weather getWeather(String cityId){
        Weather weather = new Weather();
        RestService restService = new RestService();

        try {
            JSONObject jsonResponse = restService.sendGet(BASE_URL + "id=" + cityId + "&APPID=" + appId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return weather;
    }
}

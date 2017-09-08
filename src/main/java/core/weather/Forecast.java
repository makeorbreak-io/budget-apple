package core.weather;

import java.util.ArrayList;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Forecast {

    private ArrayList<Weather> forecast;

    /**
     * Constructor
     *
     * @param forecast list of weathers that built the forecast
     */
    public Forecast(ArrayList<Weather> forecast) {
        this.forecast = forecast;
    }

    public ArrayList<Weather> getForecast() {
        return forecast;
    }

    /**
     * @return Current weather
     */
    public Weather getCurrent(){
        return forecast.get(0);
    }
}

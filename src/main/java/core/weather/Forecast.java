package core.weather;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Forecast implements Serializable {

    private LinkedList<Weather> forecast;

    /**
     * Constructor
     *
     * @param forecast list of weathers that built the forecast
     */
    public Forecast(LinkedList<Weather> forecast) {
        this.forecast = forecast;
    }

    public void setForecast(LinkedList<Weather> forecast) {
        this.forecast = forecast;
    }

    public LinkedList<Weather> getForecast() {
        return forecast;
    }

    /**
     * @return Current weather
     */
    public Weather getCurrent(){
        return forecast.get(0);
    }
}

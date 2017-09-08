package services;

import core.weather.Forecast;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class ForecastServiceTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getForecast() {
        ForecastService forecastService = new ForecastService("f26768c8c6cae1724b64060af97ecff9");

        Forecast forecast = forecastService.getForecast("2735941");

        Assert.assertTrue(forecast.getForecast().size() == 40);
    }

}
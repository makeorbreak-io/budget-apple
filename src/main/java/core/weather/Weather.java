package core.weather;

import java.util.Date;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Weather {

    private Date date;
    private Temperature temperature;
    private Double pressure;
    private Double seaLevel;
    private Double groundLevel;
    private Double humidity;
    private String weather;
    private String weatherDescription;
    private double cloudiness;
    private double rain;
    private double snow;
    private Wind wind;

    /**
     * Constructor
     *
     * @param date Time of effective weather
     * @param temperature Temperature
     * @param pressure Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
     * @param seaLevel Atmospheric pressure on the sea level, hPa
     * @param groundLevel Atmospheric pressure on the ground level, hPa
     * @param humidity Humidity, %
     * @param weather Group of weather parameters (Rain, Snow, Extreme etc.)
     * @param weatherDescription Weather condition within the group
     * @param cloudiness Cloudiness, %
     * @param rain Rain volume for the last 3 hours
     * @param snow Snow volume for the last 3 hours
     * @param wind Wind
     */
    public Weather(Date date, Temperature temperature, Double pressure, Double seaLevel, Double groundLevel,
                   Double humidity, String weather, String weatherDescription, double cloudiness, double rain,
                   double snow, Wind wind) {
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
        this.humidity = humidity;
        this.weather = weather;
        this.weatherDescription = weatherDescription;
        this.cloudiness = cloudiness;
        this.rain = rain;
        this.snow = snow;
        this.wind = wind;
    }

    /**
     * Constructor
     * @param date Time of effective weather
     * @param temperature Temperature, Kelvin
     * @param pressure Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
     * @param seaLevel Atmospheric pressure on the sea level, hPa
     * @param groundLevel Atmospheric pressure on the ground level, hPa
     * @param humidity Humidity, %
     * @param weather Group of weather parameters (Rain, Snow, Extreme etc.)
     * @param weatherDescription Weather condition within the group
     * @param cloudiness Cloudiness, %
     * @param wind Snow volume for the last 3 hours
     */
    public Weather(Date date, Temperature temperature, Double pressure, Double seaLevel, Double groundLevel,
                   Double humidity, String weather, String weatherDescription, double cloudiness, Wind wind) {
        this.date = date;
        this.temperature = temperature;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
        this.humidity = humidity;
        this.weather = weather;
        this.weatherDescription = weatherDescription;
        this.cloudiness = cloudiness;
        this.wind = wind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(Double groundLevel) {
        this.groundLevel = groundLevel;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}

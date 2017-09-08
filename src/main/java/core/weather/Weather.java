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
    private Integer humidity;
    private String weather;
    private String weatherDescription;
    private Integer cloudiness;
    private double rain;
    private double snow;
    private Wind wind;

    /**
     * Constructor
     *  @param date Time of effective weather
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
                   Integer humidity, String weather, String weatherDescription, Integer cloudiness, double rain,
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
                   Integer humidity, String weather, String weatherDescription, Integer cloudiness, Wind wind) {
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

    /**
     * Empty Constructor
     */
    public Weather() {
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

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
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

    public void setCloudiness(Integer cloudiness) {
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

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather1 = (Weather) o;

        if (Double.compare(weather1.cloudiness, cloudiness) != 0) return false;
        if (Double.compare(weather1.rain, rain) != 0) return false;
        if (Double.compare(weather1.snow, snow) != 0) return false;
        if (date != null ? !date.equals(weather1.date) : weather1.date != null) return false;
        if (temperature != null ? !temperature.equals(weather1.temperature) : weather1.temperature != null)
            return false;
        if (pressure != null ? !pressure.equals(weather1.pressure) : weather1.pressure != null) return false;
        if (seaLevel != null ? !seaLevel.equals(weather1.seaLevel) : weather1.seaLevel != null) return false;
        if (groundLevel != null ? !groundLevel.equals(weather1.groundLevel) : weather1.groundLevel != null)
            return false;
        if (humidity != null ? !humidity.equals(weather1.humidity) : weather1.humidity != null) return false;
        if (weather != null ? !weather.equals(weather1.weather) : weather1.weather != null) return false;
        if (weatherDescription != null ? !weatherDescription.equals(weather1.weatherDescription) : weather1.weatherDescription != null)
            return false;
        return wind != null ? wind.equals(weather1.wind) : weather1.wind == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (pressure != null ? pressure.hashCode() : 0);
        result = 31 * result + (seaLevel != null ? seaLevel.hashCode() : 0);
        result = 31 * result + (groundLevel != null ? groundLevel.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        result = 31 * result + (weatherDescription != null ? weatherDescription.hashCode() : 0);
        temp = Double.doubleToLongBits(cloudiness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rain);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(snow);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        return result;
    }
}

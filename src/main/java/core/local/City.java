package core.local;

import java.io.Serializable;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class City implements Serializable {

    private String id;
    private String name;
    private String country;
    private Coordinates coordinates;

    /**
     * Constructor
     * @param id Unique ID
     * @param name City name
     * @param country Country name
     * @param coordinates Coordinates
     */
    public City(String id, String name, String country, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (country != null ? !country.equals(city.country) : city.country != null) return false;
        return coordinates != null ? coordinates.equals(city.coordinates) : city.coordinates == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}

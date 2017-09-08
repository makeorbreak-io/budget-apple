package core.local;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Coordinates {

    private double lon;
    private double lat;

    /**
     * Constructor
     *
     * @param lon longitude
     * @param lat latitude
     */
    public Coordinates(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Double.compare(that.lon, lon) != 0) return false;
        return Double.compare(that.lat, lat) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lon);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}

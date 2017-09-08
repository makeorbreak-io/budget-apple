package core.weather;

import java.io.Serializable;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Wind implements Serializable {

    private double speed;
    private double direction;

    /**
     * Constructor
     *
     * @param speed Wind speed, m/s
     * @param direction Wind direction, degrees (meteorological)
     */
    public Wind(double speed, double direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wind wind = (Wind) o;

        if (Double.compare(wind.speed, speed) != 0) return false;
        return Double.compare(wind.direction, direction) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(speed);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(direction);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

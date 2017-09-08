package core.weather;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Wind {

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
}

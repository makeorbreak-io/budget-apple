package core.weather;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Temperature {

    private Double current;
    private Double minimum;
    private Double maximum;

    /**
     * Construtor
     *
     * @param current temperature, Kelvin
     * @param minimum Minimum temperature at the moment, Kelvin
     * @param maximum Maximum temperature at the moment, Kelvin
     */
    public Temperature(Double current, Double minimum, Double maximum) {
        this.current = current;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }
}

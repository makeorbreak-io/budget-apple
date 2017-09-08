package com.budgetapple.pidrobe.core.weather;

import java.io.Serializable;

/**
 * @author Luis on 08/09/2017.
 * @project pidrobe
 */
public class Temperature implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Temperature that = (Temperature) o;

        if (current != null ? !current.equals(that.current) : that.current != null) return false;
        if (minimum != null ? !minimum.equals(that.minimum) : that.minimum != null) return false;
        return maximum != null ? maximum.equals(that.maximum) : that.maximum == null;
    }

    @Override
    public int hashCode() {
        int result = current != null ? current.hashCode() : 0;
        result = 31 * result + (minimum != null ? minimum.hashCode() : 0);
        result = 31 * result + (maximum != null ? maximum.hashCode() : 0);
        return result;
    }
}

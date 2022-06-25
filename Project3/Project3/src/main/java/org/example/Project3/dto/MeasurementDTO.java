package org.example.Project3.dto;

import org.example.Project3.models.Sensor;

import javax.validation.constraints.*;

/**
 * created by dmitrii.fateev
 */
public class MeasurementDTO {

    @NotNull
    @Min(value = -100)
    @Max(value = 100)
    private float value;

    @NotNull
    private boolean raining;


    @NotNull
    private Sensor sensor;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}

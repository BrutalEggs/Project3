package org.example.Project3.models;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * created by dmitrii.fateev
 */
@Entity
@Table(name = "Measurements")
public class Measurement {

    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_id;

    @Column(name = "value")
    @NotNull
    @Min(value = -100)
    @Max(value = 100)
    private float value;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(float value, Sensor owner) {
        this.value = value;
        this.sensor = owner;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor owner) {
        this.sensor = owner;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }
}

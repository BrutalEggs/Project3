package org.example.Project3.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by dmitrii.fateev
 */
public class SensorDTO {

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 30, message = "Name of sensor should be between 3 and 30 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

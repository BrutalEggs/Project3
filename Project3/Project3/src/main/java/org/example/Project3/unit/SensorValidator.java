package org.example.Project3.unit;

import org.example.Project3.models.Sensor;
import org.example.Project3.services.SensorService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * created by dmitrii.fateev
 */
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if (sensorService.findById(sensor.getId()) != null)
            errors.rejectValue("name","", "This name is already exist");
    }
}

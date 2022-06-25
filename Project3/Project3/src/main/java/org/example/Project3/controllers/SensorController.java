package org.example.Project3.controllers;

import org.example.Project3.dto.SensorDTO;
import org.example.Project3.models.Sensor;
import org.example.Project3.services.SensorService;
import org.example.Project3.unit.SensorErrorResponse;
import org.example.Project3.unit.SensorNotCreatedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * created by dmitrii.fateev
 */

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for (FieldError f : fieldErrorList){
                errors.append(f.getField())
                        .append(" - ")
                        .append(f.getDefaultMessage())
                        .append(";");
            }
            throw new SensorNotCreatedException(errors.toString());
        }

        sensorService.create(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public Sensor convertToSensor(SensorDTO sensorDTO){
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    @ExceptionHandler
    public ResponseEntity<SensorErrorResponse> handleException(SensorNotCreatedException e){
        SensorErrorResponse sensorErrorResponse = new SensorErrorResponse(
                e.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(sensorErrorResponse, HttpStatus.BAD_REQUEST);
    }

}

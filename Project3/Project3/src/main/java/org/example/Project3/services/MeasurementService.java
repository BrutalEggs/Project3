package org.example.Project3.services;

import org.example.Project3.models.Measurement;
import org.example.Project3.models.Sensor;
import org.example.Project3.repositories.MeasurementRepository;
import org.example.Project3.repositories.SensorRepository;
import org.example.Project3.unit.MeasurementNotCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by dmitrii.fateev
 */
@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void add(Measurement measurement){
        Sensor sensor = measurement.getSensor();
        if (sensorRepository.findByName(sensor.getName()) == null)
            throw new MeasurementNotCreatedException("Sensor not found");
        else measurement.getSensor().setId(sensorRepository.findByName(sensor.getName()).getId());
        measurementRepository.save(measurement);
    }

    public List<Measurement> getAll(){
        return measurementRepository.findAll();
    }

    public List<Measurement> getAllWithRain(){
        return measurementRepository.findByRainingIsTrue();
    }
}

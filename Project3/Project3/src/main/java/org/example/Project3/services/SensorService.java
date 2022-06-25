package org.example.Project3.services;

import org.example.Project3.models.Sensor;
import org.example.Project3.repositories.SensorRepository;
import org.example.Project3.unit.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by dmitrii.fateev
 */
@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void create(Sensor sensor){
        sensorRepository.save(sensor);
    }

    public Sensor findById(int id){
        return sensorRepository.findById(id).orElse(null);
    }

}

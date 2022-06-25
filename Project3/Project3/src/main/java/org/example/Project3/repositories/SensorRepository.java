package org.example.Project3.repositories;

import org.example.Project3.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by dmitrii.fateev
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor,Integer> {

    Sensor findByName(String name);
}

package org.example.Project3.repositories;

import org.example.Project3.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by dmitrii.fateev
 */
@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    public List<Measurement> findByRainingIsTrue();
}

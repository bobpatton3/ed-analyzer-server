package com.bobpatton3.edanalyzer.service;

import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.Arrival;

public interface IArrivalService {

    Iterable<Arrival> findAll();
    
    Arrival save(Arrival schedule);
    
    void delete(UUID id);

}

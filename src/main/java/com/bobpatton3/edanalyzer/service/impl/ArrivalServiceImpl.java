package com.bobpatton3.edanalyzer.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.Arrival;
import com.bobpatton3.edanalyzer.persistence.repository.IArrivalRepository;
import com.bobpatton3.edanalyzer.service.IArrivalService;

@Service
public class ArrivalServiceImpl implements IArrivalService {
    
    @Autowired
    private IArrivalRepository arrivalRepository;

    @Override
    public Iterable<Arrival> findAll() {
        return arrivalRepository.findAll();
    }

    @Override
    public Arrival save(Arrival arrival) {
        return arrivalRepository.save(arrival);
    }

    @Override
    public void delete(UUID id) {
        arrivalRepository.deleteById(id);
    }

}

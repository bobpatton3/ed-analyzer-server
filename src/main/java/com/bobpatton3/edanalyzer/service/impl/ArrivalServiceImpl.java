package com.bobpatton3.edanalyzer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;
import com.bobpatton3.edanalyzer.persistence.repository.IArrivalRepository;
import com.bobpatton3.edanalyzer.service.IArrivalService;

@Service
public class ArrivalServiceImpl implements IArrivalService {
    
    @Autowired
    private IArrivalRepository arrivalRepository;

    @Override
    public Iterable<AggregatedArrivalHour> getAggregatedArrivals() {
        return arrivalRepository.findAll();
    }


}

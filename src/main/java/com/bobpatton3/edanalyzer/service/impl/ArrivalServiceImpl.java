package com.bobpatton3.edanalyzer.service.impl;

import java.util.UUID;

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
    public Iterable<AggregatedArrivalHour> getAggregatedArrivals(String _start_date,
        String _end_date,
        String _door_to_prov,
        UUID   _dept_id) {
        return arrivalRepository.aggregated_arrivals( _start_date, _end_date, _door_to_prov, _dept_id);
    }


}

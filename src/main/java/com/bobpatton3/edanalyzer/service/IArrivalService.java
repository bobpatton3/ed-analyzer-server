package com.bobpatton3.edanalyzer.service;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;

public interface IArrivalService {

    Iterable<AggregatedArrivalHour> getAggregatedArrivals(String _start_date,
        String _end_date,
        String _door_to_prov,
        String _client,
        String _fac,
        String _dept);

}

package com.bobpatton3.edanalyzer.service;


import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;

public interface IArrivalService {

    Iterable<AggregatedArrivalHour> getAggregatedArrivals();

}

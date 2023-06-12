package com.bobpatton3.edanalyzer.persistence.repository;


import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;

public interface IArrivalRepository extends CrudRepository<AggregatedArrivalHour, Integer>{

}

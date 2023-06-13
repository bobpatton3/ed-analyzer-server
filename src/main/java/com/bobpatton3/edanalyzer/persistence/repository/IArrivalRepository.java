package com.bobpatton3.edanalyzer.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;

public interface IArrivalRepository extends CrudRepository<AggregatedArrivalHour, Integer> {
    
    @Query(value = "SELECT * FROM public.aggregated_arrivals( ?1, ?2, ?3, ?4, ?5, ?6 )", 
        nativeQuery = true)
    public Iterable<AggregatedArrivalHour> aggregated_arrivals(
        String _start_date,
        String _end_date,
        String _door_to_prov,
        String _client,
        String _fac,
        String _dept);

}

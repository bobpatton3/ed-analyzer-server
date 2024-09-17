package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;

public interface IArrivalRepository extends CrudRepository<AggregatedArrivalHour, Integer> {
    
    @Query(value = "SELECT id, dow, hod, COALESCE(all_avg_rvus, 0.0) AS all_avg_rvus, COALESCE(l5cc_avg_rvus, 0.0) AS l5cc_avg_rvus FROM public.aggregated_arrivals( ?1, ?2, ?3, ?4 )", 
        nativeQuery = true)
    public Iterable<AggregatedArrivalHour> aggregated_arrivals(
        String _start_date,
        String _end_date,
        String _door_to_prov,
        UUID _dept_id);

}

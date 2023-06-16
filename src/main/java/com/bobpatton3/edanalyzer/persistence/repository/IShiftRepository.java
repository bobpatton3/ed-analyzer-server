package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bobpatton3.edanalyzer.persistence.model.Shift;

public interface IShiftRepository extends CrudRepository<Shift, UUID> {
    
    @Modifying
    @Query(value = "DELETE FROM Shifts WHERE schedule_id = :schedule_id ", nativeQuery = true)
    public void deleteAllForScheduleID(@Param("schedule_id") UUID schedule_id);


}

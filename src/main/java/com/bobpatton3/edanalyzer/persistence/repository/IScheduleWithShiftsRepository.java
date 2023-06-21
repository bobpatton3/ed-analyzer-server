package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bobpatton3.edanalyzer.persistence.model.ScheduleWithShifts;

public interface IScheduleWithShiftsRepository extends CrudRepository<ScheduleWithShifts, UUID> {

    @Query(value = "SELECT sc.creation_date, sc.update_date, sc.owner, sc.schedule_name, sh.schedule_id, " +
                      " sh.id as shift_id, sh.start_hour, sh.duration, sh.provider_type, sh.days_of_week, " +
                      " sc.department_id " +
                      " FROM schedules AS sc INNER JOIN shifts AS sh ON sh.schedule_id = sc.id " +
                      " WHERE sc.department_id = :department_id ",
                nativeQuery = true)
    public Iterable<ScheduleWithShifts> findAllForLocation( @Param("department_id") UUID department_id);
    
}

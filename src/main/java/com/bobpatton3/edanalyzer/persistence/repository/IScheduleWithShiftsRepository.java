package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.SchedulesWithShifts;

public interface IScheduleWithShiftsRepository extends CrudRepository<SchedulesWithShifts, UUID> {

    @Query(value = "SELECT sc.creation_date, sc.update_date, sc.owner, sc.schedule_name, sh.schedule_id, " +
                      " sh.id as shift_id, sh.start_hour, sh.duration, sh.provider_type, sh.days_of_week " +
                      " FROM schedules AS sc INNER JOIN shifts AS sh ON sh.schedule_id = sc.id " +
                      " WHERE sc.client_group = ?1 AND sc.facility = ?2 AND sc.department = ?3  ",
                nativeQuery = true)
    public Iterable<SchedulesWithShifts> findAllForLocation(String client, String fac, String dept);
    
}

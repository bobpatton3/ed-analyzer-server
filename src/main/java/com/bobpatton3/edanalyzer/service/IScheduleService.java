package com.bobpatton3.edanalyzer.service;

import java.util.List;
import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.NewScheduleWithShifts;
import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.model.ScheduleWithShifts;

public interface IScheduleService {
    
    Iterable<ScheduleWithShifts> findAllForLocation(UUID department_id);
    
    void delete(UUID id);
    
    UUID saveNewFullSchedule(List<NewScheduleWithShifts> newSchedule);


}

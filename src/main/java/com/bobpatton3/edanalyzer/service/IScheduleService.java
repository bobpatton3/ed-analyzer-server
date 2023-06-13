package com.bobpatton3.edanalyzer.service;

import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.model.SchedulesWithShifts;

public interface IScheduleService {
    
    Iterable<SchedulesWithShifts> findAllForLocation(String client, String fac, String dept);
    
    Schedule save(Schedule schedule);
    
    void delete(UUID id);

}

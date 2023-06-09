package com.bobpatton3.edanalyzer.service;

import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.Schedule;

public interface IScheduleService {
    
    Iterable<Schedule> findAll();
    
    Schedule save(Schedule schedule);
    
    void delete(UUID id);

}

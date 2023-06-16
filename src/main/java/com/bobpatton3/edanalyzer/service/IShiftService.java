package com.bobpatton3.edanalyzer.service;

import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.Shift;

public interface IShiftService {
    
    Iterable<Shift> findAll();
    
    Shift save(Shift shift);
    
    Iterable<Shift> saveAll(Iterable<Shift> shifts);
    
    void delete(UUID id);
    
    void deleteAllForScheduleID(UUID schedule_id);

}

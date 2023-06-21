package com.bobpatton3.edanalyzer.service;

import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.Shift;

public interface IShiftService {
    
    Iterable<Shift> saveAll(Iterable<Shift> shifts);
    
    void deleteAllForScheduleID(UUID schedule_id);

}

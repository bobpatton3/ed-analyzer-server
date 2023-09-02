package com.bobpatton3.edanalyzer.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.Shift;
import com.bobpatton3.edanalyzer.persistence.repository.IShiftRepository;
import com.bobpatton3.edanalyzer.service.IShiftService;

import jakarta.transaction.Transactional;

@Service
public class ShiftServiceImpl implements IShiftService {
    
    @Autowired
    private IShiftRepository shiftRepository;

    @Override
    public Iterable<Shift> saveAll(Iterable<Shift> shifts) {
        return shiftRepository.saveAll(shifts);
    }

    @Transactional
    @Override
    public void deleteAllForScheduleID(UUID schedule_id) {
        shiftRepository.deleteAllForScheduleID(schedule_id);
    }

}

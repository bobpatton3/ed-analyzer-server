package com.bobpatton3.edanalyzer.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.Shift;
import com.bobpatton3.edanalyzer.persistence.repository.IShiftRepository;
import com.bobpatton3.edanalyzer.service.IShiftService;

@Service
public class ShiftServiceImpl implements IShiftService {
    
    private static final Logger LOG = LoggerFactory.getLogger(ShiftServiceImpl.class);
    
    @Autowired
    private IShiftRepository shiftRepository;

    @Override
    public Iterable<Shift> findAll() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public void delete(UUID id) {
        shiftRepository.deleteById(id);
    }

}

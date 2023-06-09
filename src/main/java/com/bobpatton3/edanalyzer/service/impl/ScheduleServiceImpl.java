package com.bobpatton3.edanalyzer.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.repository.IScheduleRepository;
import com.bobpatton3.edanalyzer.service.IScheduleService;

import jakarta.transaction.Transactional;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    
    @Autowired
    private IScheduleRepository scheduleRepository;

    @Override
    public Iterable<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void delete(UUID id) {
        scheduleRepository.deleteById(id);
    }

}

package com.bobpatton3.edanalyzer.persistence.repository;

import com.bobpatton3.edanalyzer.EDAnalyzerApp;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bobpatton3.edanalyzer.persistence.model.Schedule;

@SpringBootTest
public class ScheduleRepositoryIntegrationTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(EDAnalyzerApp.class);
    
    
    @Autowired
    private IScheduleRepository scheduleRepository;
    
    @Test
    public void whenFindAll_thenSuccess() {
        Iterable<Schedule> schedules = scheduleRepository.findAll();
        
        //schedules.forEach(schedule -> { System.out.println(schedule.toString()); } );
        
        assertTrue(schedules.iterator().hasNext());
    }

}

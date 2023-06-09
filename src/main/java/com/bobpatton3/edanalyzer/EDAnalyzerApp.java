package com.bobpatton3.edanalyzer;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bobpatton3.edanalyzer.persistence.repository.IScheduleRepository;
import com.bobpatton3.edanalyzer.service.IScheduleService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EDAnalyzerApp {

    private static final Logger LOG = LoggerFactory.getLogger(EDAnalyzerApp.class);
    
    @Autowired
    IScheduleService scheduleService;
    
    @Autowired
    IScheduleRepository scheduleRepository;

    public static void main(String[] args) {
        SpringApplication.run(EDAnalyzerApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("Fetching all schedules: ");
        scheduleRepository.findAll().forEach(p -> LOG.info(p.toString()));
        
        //scheduleService.delete(UUID.fromString("a0558cc9-87bf-456e-81f5-dc4d7efb33de"));
    }
}

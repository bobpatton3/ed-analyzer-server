package com.bobpatton3.edanalyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bobpatton3.edanalyzer.persistence.repository.IScheduleRepository;
import com.bobpatton3.edanalyzer.service.IScheduleService;

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

    // @PostConstruct
    public void postConstruct() {
        LOG.info("Fetching all schedules: ");
        scheduleRepository.findAll().forEach(p -> LOG.info(p.toString()));
    }
}

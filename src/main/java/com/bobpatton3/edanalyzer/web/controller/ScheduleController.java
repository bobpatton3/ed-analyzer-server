package com.bobpatton3.edanalyzer.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.EDAnalyzerApp;
import com.bobpatton3.edanalyzer.persistence.model.NewScheduleWithShifts;
import com.bobpatton3.edanalyzer.persistence.model.ScheduleWithShifts;
import com.bobpatton3.edanalyzer.service.IScheduleService;

@RestController
@RequestMapping(value="/schedules")
public class ScheduleController {

    private static final Logger LOG = LoggerFactory.getLogger(EDAnalyzerApp.class);
    
    @Autowired
    private IScheduleService scheduleService;
    
    // URL:  http://localhost:8080/schedules/A1%20Emergency%20Physicians/Memorial%20Hospital/Main%20ED
    
    @GetMapping("/{client}/{fac}/{dept}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ScheduleWithShifts> findAllMap(
        @PathVariable String client,
        @PathVariable String fac,
        @PathVariable String dept
    ) {
        Iterable<ScheduleWithShifts> schedulesWithShiftsIter = scheduleService.findAllForLocation(client, fac, dept);
        
        List<ScheduleWithShifts> schedulesWithShifts = new ArrayList<ScheduleWithShifts>();
        schedulesWithShiftsIter.forEach(schedulesWithShifts::add);
        
        //        Map<UUID, ScheduleWithShiftsDto> returnSchedules = new HashMap<UUID, ScheduleWithShiftsDto>();
        //
        //        schedulesWithShifts.forEach(s -> {
        //            if (! returnSchedules.containsKey(s.getSchedule_id())) {
        //                Schedule sched = new Schedule(s.getSchedule_id(), s.getCreation_date(), s.getUpdate_date(), s.getOwner(), s.getSchedule_name());
        //                returnSchedules.put(s.getSchedule_id(), convertToScheduleWithShiftsDto(sched, schedulesWithShifts));
        //            }
        //        });
        
        return schedulesWithShifts;
    }
    
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody List<NewScheduleWithShifts> newSchedule) {
        //newSchedule.forEach((item) -> {System.out.println(item.toString()); } );
        UUID id = scheduleService.saveNewFullSchedule(newSchedule);
        return id.toString();
    }
    
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ScheduleWithShifts> updateProject(@PathVariable("id") UUID id, @RequestBody List<ScheduleWithShifts> updatedSchedule) {
        return scheduleService.updateFullSchedule(id , updatedSchedule);
    }
    
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteSchedule(@PathVariable("id") UUID id) {
        scheduleService.delete(id);
    }

}


/*
    

*/
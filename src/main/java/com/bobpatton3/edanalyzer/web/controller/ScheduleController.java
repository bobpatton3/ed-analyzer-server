package com.bobpatton3.edanalyzer.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.EDAnalyzerApp;
import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.model.SchedulesWithShifts;
import com.bobpatton3.edanalyzer.persistence.model.Shift;
import com.bobpatton3.edanalyzer.service.IScheduleService;
import com.bobpatton3.edanalyzer.web.dto.ScheduleWithShiftsDto;

@RestController
@RequestMapping(value="/schedules")
public class ScheduleController {

    private static final Logger LOG = LoggerFactory.getLogger(EDAnalyzerApp.class);
    
    @Autowired
    private IScheduleService scheduleService;
    
    // URL:  http://localhost:8080/schedules/A1%20Emergency%20Physicians/Memorial%20Hospital/Main%20ED
    
    @GetMapping("/{client}/{fac}/{dept}")
    public Map<UUID, ScheduleWithShiftsDto> findAllMap(
        @PathVariable String client,
        @PathVariable String fac,
        @PathVariable String dept
    ) {
        Iterable<SchedulesWithShifts> schedulesWithShifts = scheduleService.findAllForLocation(client, fac, dept);
        
        Map<UUID, ScheduleWithShiftsDto> returnSchedules = new HashMap<UUID, ScheduleWithShiftsDto>();

        schedulesWithShifts.forEach(s -> {
            if (! returnSchedules.containsKey(s.getSchedule_id())) {
                Schedule sched = new Schedule(s.getSchedule_id(), s.getCreation_date(), s.getUpdate_date(), s.getOwner(), s.getSchedule_name());
                returnSchedules.put(s.getSchedule_id(), convertToScheduleWithShiftsDto(sched, schedulesWithShifts));
            }
        });
        
        return returnSchedules;
    }
    
    private ScheduleWithShiftsDto convertToScheduleWithShiftsDto(Schedule sched, Iterable<SchedulesWithShifts> schedulesWithShifts) {
       
        Map<UUID, Shift> shifts = new HashMap<UUID, Shift>();
        
        schedulesWithShifts.forEach(sws -> {
            if (sws.getSchedule_id().equals(sched.getId())) {
                shifts.put(sws.getShift_id(), new Shift(sws.getShift_id(), sched.getId(), sws.getStart_hour(), sws.getDuration(), sws.getProvider_type(), sws.getDays_of_week()));
            }
        } );
        
        ScheduleWithShiftsDto scheduleWithShifts = new ScheduleWithShiftsDto(sched, shifts);
        
        return scheduleWithShifts;
    }

}

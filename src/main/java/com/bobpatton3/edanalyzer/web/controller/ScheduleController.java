package com.bobpatton3.edanalyzer.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.EDAnalyzerApp;
import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.model.Shift;
import com.bobpatton3.edanalyzer.service.IScheduleService;
import com.bobpatton3.edanalyzer.service.IShiftService;
import com.bobpatton3.edanalyzer.web.dto.ScheduleWithShiftsDto;

@RestController
@RequestMapping(value="/schedules")
public class ScheduleController {

    private static final Logger LOG = LoggerFactory.getLogger(EDAnalyzerApp.class);
    
    @Autowired
    private IScheduleService scheduleService;
    
    @Autowired
    private IShiftService shiftService;
    
    @GetMapping
    public Collection<Schedule> findAll() {
        Iterable<Schedule> schedules = scheduleService.findAll();
        List<Schedule> returnSchedules = new ArrayList<Schedule>();
        schedules.forEach(s -> returnSchedules.add(s));
        
        return returnSchedules;
    }

    @GetMapping("/map_with_shifts")
    public Map<UUID, ScheduleWithShiftsDto> findAllMap() {
        Iterable<Schedule> schedules = scheduleService.findAll();
        Iterable<Shift> allShifts = shiftService.findAll();
        
        Map<UUID, ScheduleWithShiftsDto> returnSchedules = new HashMap<UUID, ScheduleWithShiftsDto>();
        schedules.forEach(s -> returnSchedules.put(s.getId(), convertToScheduleWithShiftsDto(s, allShifts)));
        
        return returnSchedules;
    }
    
    private ScheduleWithShiftsDto convertToScheduleWithShiftsDto(Schedule schedule, Iterable<Shift> allShifts) {
       
        Map<UUID, Shift> shifts = new HashMap<UUID, Shift>();
        
        allShifts.forEach(shift -> {
            if (shift.getSchedule_id().equals(schedule.getId())) {
                shifts.put(shift.getId(), shift);
            }
        } );
        
        ScheduleWithShiftsDto scheduleWithShifts = new ScheduleWithShiftsDto(
            schedule.getId(),
            schedule.getCreation_date(), 
            schedule.getUpdate_date(), 
            schedule.getOwner(), 
            schedule.getSchedule_name(), 
            shifts);
        
        return scheduleWithShifts;
    }

}

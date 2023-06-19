package com.bobpatton3.edanalyzer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.NewScheduleWithShifts;
import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.model.ScheduleWithShifts;
import com.bobpatton3.edanalyzer.persistence.model.Shift;
import com.bobpatton3.edanalyzer.persistence.repository.IScheduleRepository;
import com.bobpatton3.edanalyzer.persistence.repository.IScheduleWithShiftsRepository;
import com.bobpatton3.edanalyzer.service.IScheduleService;
import com.bobpatton3.edanalyzer.service.IShiftService;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    
    @Autowired
    private IScheduleRepository scheduleRepository;
    
    @Autowired
    private IScheduleWithShiftsRepository scheduleWithShiftsRepository;
    
    @Autowired
    private IShiftService shiftService;

    @Override
    public Iterable<ScheduleWithShifts> findAllForLocation(UUID department_id) {
        return scheduleWithShiftsRepository.findAllForLocation(department_id);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void delete(UUID id) {
        scheduleRepository.deleteById(id);
        shiftService.deleteAllForScheduleID(id);
    }

    @Override
    public UUID saveNewFullSchedule(List<NewScheduleWithShifts> newSchedule) {
        /* TODO
         * 1. if schedule_id can convert to a UUID and is in the schedule table then delete all its related shifts
         * 2. else save the new schedule and retrieve its UUID schedule_id
         * 3. save all of the shifts:
         *    a. iterate on the input
         *    b. create a Shift object for each and add it to an ArrayList
         *    c. pass the Iterable from that List to shiftService.saveAll
         */
        if (newSchedule.isEmpty()) {
            throw new IllegalArgumentException("Attempt to save an empty schedule");
        }
        
        NewScheduleWithShifts firstItem = newSchedule.get(0);
        String schedule_id_str = firstItem.getSchedule_id();
        UUID initial_schedule_id = null;
        boolean schedule_is_new = true;
        
        try {
            initial_schedule_id = UUID.fromString(schedule_id_str);
            schedule_is_new = false;
        } catch (IllegalArgumentException ex ) {
            // schedule_id not a valid UUID but this just means it is a brand-new schedule for insertion 
            schedule_is_new = true;
        }
        
        if (!schedule_is_new) {
            shiftService.deleteAllForScheduleID(initial_schedule_id);
        }
        
        Schedule schedule = new Schedule(
            firstItem.getCreation_date(), 
            firstItem.getUpdate_date(), 
            firstItem.getOwner(), 
            firstItem.getSchedule_name(), 
            firstItem.getClient_group(), 
            firstItem.getFacility(), 
            firstItem.getDepartment()
        );
        
        if (!schedule_is_new) schedule.setId(initial_schedule_id);
        
        // JPA does UPDATE or INSERT as needed here
        Schedule returnedSchedule = scheduleRepository.save(schedule);
        UUID schedule_id = returnedSchedule.getId();
        
        List<Shift> shifts = new ArrayList<Shift>();
        newSchedule.forEach((r) -> {
            shifts.add(new Shift(schedule_id, r.getStart_hour(), r.getDuration(), r.getProvider_type(), r.getDays_of_week()));
        });
        
        shiftService.saveAll(shifts);
        
        return schedule_id;
        
    }

    @Override
    public List<ScheduleWithShifts> updateFullSchedule(UUID id, List<ScheduleWithShifts> newSchedule) {
        // TODO Auto-generated method stub
        return new ArrayList<ScheduleWithShifts>();
    }

}

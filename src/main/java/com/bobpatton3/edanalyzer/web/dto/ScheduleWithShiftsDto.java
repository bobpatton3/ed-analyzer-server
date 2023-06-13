package com.bobpatton3.edanalyzer.web.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.Map;

import com.bobpatton3.edanalyzer.persistence.model.Schedule;
import com.bobpatton3.edanalyzer.persistence.model.Shift;

public class ScheduleWithShiftsDto {

    private UUID id;
    
    private Date creation_date;
    
    private Date update_date;
    
    private String owner;
    
    private String schedule_name;
    
    private Map<UUID, Shift> shifts;

    public ScheduleWithShiftsDto(String owner, String schedule_name) {
        super();
        this.owner = owner;
        this.schedule_name = schedule_name;
        this.shifts = new HashMap<>();
    }

    public ScheduleWithShiftsDto(Schedule sched, Map<UUID, Shift> shifts) {
        super();
        this.id = sched.getId();
        this.creation_date = sched.getCreation_date();
        this.update_date = sched.getUpdate_date();
        this.owner = sched.getOwner();
        this.schedule_name = sched.getSchedule_name();
        this.shifts = shifts;
    }

    public ScheduleWithShiftsDto(UUID id, Date creation_date, Date update_date, String owner, String schedule_name, Map<UUID, Shift> shifts) {
        super();
        this.id = id;
        this.creation_date = creation_date;
        this.update_date = update_date;
        this.owner = owner;
        this.schedule_name = schedule_name;
        this.shifts = shifts;
    }

    public ScheduleWithShiftsDto() {
        this.shifts = new HashMap<>();
    }
    @Override
    public String toString() {
        return "Schedule [id=" + id + ", creation_date=" + creation_date + ", update_date=" + update_date + ", owner=" + owner + ", schedule_name=" + schedule_name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, schedule_name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScheduleWithShiftsDto other = (ScheduleWithShiftsDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(owner, other.owner) && Objects.equals(schedule_name, other.schedule_name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSchedule_name() {
        return schedule_name;
    }

    public void setSchedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }

    public Map<UUID, Shift> getShifts() {
        return shifts;
    }

    public void setShifts(Map<UUID, Shift> shifts) {
        this.shifts = shifts;
    }


}

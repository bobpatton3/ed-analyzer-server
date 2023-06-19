package com.bobpatton3.edanalyzer.persistence.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ScheduleWithShifts {
    
    @Id
    private UUID shift_id;
    
    
    private Date creation_date;
    private Date update_date;
    private String owner;
    private String schedule_name;
    private UUID schedule_id;
    private int start_hour;
    private int duration;
    private String provider_type;
    private boolean[] days_of_week;
    private String client_group;
    private String facility;
    private String department;
    private UUID department_id;
    
    public ScheduleWithShifts() {
    } 
    
    public ScheduleWithShifts(UUID shift_id, Date creation_date, Date update_date, String owner, 
                                String schedule_name, String client_group, String facility, String department, 
                                UUID schedule_id, int start_hour, int duration, String provider_type, boolean[] days_of_week, UUID department_id) {
        super();
        this.shift_id = shift_id;
        this.creation_date = creation_date;
        this.update_date = update_date;
        this.owner = owner;
        this.schedule_name = schedule_name;
        this.schedule_id = schedule_id;
        this.start_hour = start_hour;
        this.duration = duration;
        this.provider_type = provider_type;
        this.days_of_week = days_of_week;
        this.client_group = client_group;
        this.facility = facility;
        this.department = department;
        this.department_id = department_id;
    }
    
    public UUID getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(UUID department_id) {
        this.department_id = department_id;
    }

    public String getClient_group() {
        return client_group;
    }

    public void setClient_group(String client_group) {
        this.client_group = client_group;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public UUID getShift_id() {
        return shift_id;
    }
    public void setShift_id(UUID shift_id) {
        this.shift_id = shift_id;
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
    public UUID getSchedule_id() {
        return schedule_id;
    }
    public void setSchedule_id(UUID schedule_id) {
        this.schedule_id = schedule_id;
    }
    public int getStart_hour() {
        return start_hour;
    }
    public void setStart_hour(int start_hour) {
        this.start_hour = start_hour;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getProvider_type() {
        return provider_type;
    }
    public void setProvider_type(String provider_type) {
        this.provider_type = provider_type;
    }
    public boolean[] getDays_of_week() {
        return days_of_week;
    }
    public void setDays_of_week(boolean[] days_of_week) {
        this.days_of_week = days_of_week;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(days_of_week);
        result = prime * result + Objects.hash(client_group, creation_date, department, department_id, duration, facility, owner, provider_type, schedule_id, schedule_name, shift_id, start_hour, update_date);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScheduleWithShifts other = (ScheduleWithShifts) obj;
        return Objects.equals(client_group, other.client_group) && Objects.equals(creation_date, other.creation_date) && Arrays.equals(days_of_week, other.days_of_week) && Objects.equals(department, other.department)
            && Objects.equals(department_id, other.department_id) && duration == other.duration && Objects.equals(facility, other.facility) && Objects.equals(owner, other.owner) && Objects.equals(provider_type, other.provider_type)
            && Objects.equals(schedule_id, other.schedule_id) && Objects.equals(schedule_name, other.schedule_name) && Objects.equals(shift_id, other.shift_id) && start_hour == other.start_hour && Objects.equals(update_date, other.update_date);
    }

    @Override
    public String toString() {
        return "ScheduleWithShifts [shift_id=" + shift_id + ", creation_date=" + creation_date + ", update_date=" + update_date + ", owner=" + owner + ", schedule_name=" + schedule_name + ", schedule_id=" + schedule_id + ", start_hour=" + start_hour
            + ", duration=" + duration + ", provider_type=" + provider_type + ", days_of_week=" + Arrays.toString(days_of_week) + ", client_group=" + client_group + ", facility=" + facility + ", department=" + department + ", department_id=" + department_id
            + "]";
    }


}

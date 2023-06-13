package com.bobpatton3.edanalyzer.persistence.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shifts")
public class Shift {
    @Id
    private UUID id;
    
    private UUID schedule_id;
    
    private int start_hour;
    
    private int duration;
    
    private String provider_type;
    
    private boolean[] days_of_week;
    
    public Shift() {
    }
    
    public Shift(UUID shift_id, UUID schedule_id, int start_hour, int duration, String provider_type, boolean[] days_of_week) {
        super();
        this.id = shift_id;
        this.schedule_id = schedule_id;
        this.start_hour = start_hour;
        this.duration = duration;
        this.provider_type = provider_type;
        this.days_of_week = days_of_week;
    }
    
    public Shift(UUID schedule_id, int start_hour, int duration, String provider_type, boolean[] days_of_week) {
        super();
        this.schedule_id = schedule_id;
        this.start_hour = start_hour;
        this.duration = duration;
        this.provider_type = provider_type;
        this.days_of_week = days_of_week;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public String toString() {
        return "Shift [id=" + id + ", schedule_id=" + schedule_id + ", start_hour=" + start_hour + ", duration=" + duration + ", provider_type=" + provider_type + ", days_of_week=" + Arrays.toString(days_of_week) + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(duration, id, provider_type, schedule_id, start_hour);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shift other = (Shift) obj;
        return duration == other.duration && Objects.equals(id, other.id) && Objects.equals(provider_type, other.provider_type) && Objects.equals(schedule_id, other.schedule_id) && start_hour == other.start_hour;
    }

}

package com.bobpatton3.edanalyzer.persistence.model;

import java.util.UUID;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {
    
    @Id
    private UUID id;
    
    private Date creation_date;
    
    private Date update_date;
    
    private String owner;
    
    private String schedule_name;

    public Schedule(String owner, String schedule_name) {
        super();
        this.owner = owner;
        this.schedule_name = schedule_name;
    }

    public Schedule() {
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
        Schedule other = (Schedule) obj;
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

}

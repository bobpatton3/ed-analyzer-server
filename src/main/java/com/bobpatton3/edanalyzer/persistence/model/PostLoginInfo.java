package com.bobpatton3.edanalyzer.persistence.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_metadata")
public class PostLoginInfo {

    @Id
    private UUID department_id;

    private String client_group_name;
    private String facility_name;
    private String department_name;
    private BigDecimal phys_hourly_cost;
    private BigDecimal phys_peak_capacity;
    private ZonedDateTime data_start_date;
    private ZonedDateTime data_end_date;
    private BigDecimal app_hourly_cost;
    private BigDecimal app_peak_capacity;
    
    public PostLoginInfo() {
    }
    
    public PostLoginInfo(UUID department_id, String client_group_name, String facility_name, String department_name, String provider_type, BigDecimal phys_hourly_cost, BigDecimal phys_peak_capacity, ZonedDateTime data_start_date, ZonedDateTime data_end_date,
        BigDecimal app_hourly_cost, BigDecimal app_peak_capacity) {
        super();
        this.department_id = department_id;
        this.client_group_name = client_group_name;
        this.facility_name = facility_name;
        this.department_name = department_name;
        this.phys_hourly_cost = phys_hourly_cost;
        this.phys_peak_capacity = phys_peak_capacity;
        this.data_start_date = data_start_date;
        this.data_end_date = data_end_date;
        this.app_hourly_cost = app_hourly_cost;
        this.app_peak_capacity = app_peak_capacity;
    }


    public UUID getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(UUID department_id) {
        this.department_id = department_id;
    }
    public String getClient_group_name() {
        return client_group_name;
    }
    public void setClient_group_name(String client_group_name) {
        this.client_group_name = client_group_name;
    }
    public String getFacility_name() {
        return facility_name;
    }
    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    public ZonedDateTime getData_start_date() {
        return data_start_date;
    }
    public void setData_start_date(ZonedDateTime data_start_date) {
        this.data_start_date = data_start_date;
    }
    public ZonedDateTime getData_end_date() {
        return data_end_date;
    }
    public void setData_end_date(ZonedDateTime data_end_date) {
        this.data_end_date = data_end_date;
    }
    public BigDecimal getPhys_hourly_cost() {
        return phys_hourly_cost;
    }
    public void setPhys_hourly_cost(BigDecimal phys_hourly_cost) {
        this.phys_hourly_cost = phys_hourly_cost;
    }
    public BigDecimal getPhys_peak_capacity() {
        return phys_peak_capacity;
    }
    public void setPhys_peak_capacity(BigDecimal phys_peak_capacity) {
        this.phys_peak_capacity = phys_peak_capacity;
    }
    public BigDecimal getApp_hourly_cost() {
        return app_hourly_cost;
    }
    public void setApp_hourly_cost(BigDecimal app_hourly_cost) {
        this.app_hourly_cost = app_hourly_cost;
    }
    public BigDecimal getApp_peak_capacity() {
        return app_peak_capacity;
    }
    public void setApp_peak_capacity(BigDecimal app_peak_capacity) {
        this.app_peak_capacity = app_peak_capacity;
    }


    @Override
    public int hashCode() {
        return Objects.hash(app_hourly_cost, app_peak_capacity, client_group_name, data_end_date, data_start_date, department_id, department_name, facility_name, phys_hourly_cost, phys_peak_capacity);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostLoginInfo other = (PostLoginInfo) obj;
        return Objects.equals(app_hourly_cost, other.app_hourly_cost) && Objects.equals(app_peak_capacity, other.app_peak_capacity) && Objects.equals(client_group_name, other.client_group_name) && Objects.equals(data_end_date, other.data_end_date)
            && Objects.equals(data_start_date, other.data_start_date) && Objects.equals(department_id, other.department_id) && Objects.equals(department_name, other.department_name) && Objects.equals(facility_name, other.facility_name)
            && Objects.equals(phys_hourly_cost, other.phys_hourly_cost) && Objects.equals(phys_peak_capacity, other.phys_peak_capacity);
    }


    @Override
    public String toString() {
        return "PostLoginInfo [department_id=" + department_id + ", client_group_name=" + client_group_name + ", facility_name=" + facility_name + ", department_name=" + department_name + ", phys_hourly_cost="
            + phys_hourly_cost + ", phys_peak_capacity=" + phys_peak_capacity + ", data_start_date=" + data_start_date + ", data_end_date=" + data_end_date + ", app_hourly_cost=" + app_hourly_cost + ", app_peak_capacity=" + app_peak_capacity + "]";
    }
    
    

}

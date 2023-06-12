package com.bobpatton3.edanalyzer.persistence.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="combined_aggregated_arrivals")
public class AggregatedArrivalHour {
    
    @Id
    private Integer id;
    
    private int dow;
    private int hod;
    private BigDecimal all_avg_rvus;
    private BigDecimal lvl5cc_avg_rvus;
    
    public AggregatedArrivalHour() {
        
    }
        
    public AggregatedArrivalHour(int dow, int hod, BigDecimal all_avg_rvus, BigDecimal lvl5cc_avg_rvus) {
        super();
        this.dow = dow;
        this.hod = hod;
        this.all_avg_rvus = all_avg_rvus;
        this.lvl5cc_avg_rvus = lvl5cc_avg_rvus;
    }
    
    @Override
    public String toString() {
        return "AggregatedArrivalHour [dow=" + dow + ", hod=" + hod + ", all_avg_rvus=" + all_avg_rvus + ", lvl5cc_avg_rvus=" + lvl5cc_avg_rvus + "]";
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(all_avg_rvus, dow, hod, lvl5cc_avg_rvus);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AggregatedArrivalHour other = (AggregatedArrivalHour) obj;
        return Objects.equals(all_avg_rvus, other.all_avg_rvus) && dow == other.dow && hod == other.hod && Objects.equals(lvl5cc_avg_rvus, other.lvl5cc_avg_rvus);
    }
    
    public int getDow() {
        return dow;
    }
    
    public void setDow(int dow) {
        this.dow = dow;
    }
    public int getHod() {
        return hod;
    }
    public void setHod(int hod) {
        this.hod = hod;
    }
    public BigDecimal getAll_avg_rvus() {
        return all_avg_rvus;
    }
    public void setAll_avg_rvus(BigDecimal all_avg_rvus) {
        this.all_avg_rvus = all_avg_rvus;
    }
    public BigDecimal getLvl5cc_avg_rvus() {
        return lvl5cc_avg_rvus;
    }
    public void setLvl5cc_avg_rvus(BigDecimal lvl5cc_avg_rvus) {
        this.lvl5cc_avg_rvus = lvl5cc_avg_rvus;
    }
    

}

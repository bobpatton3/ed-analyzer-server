package com.bobpatton3.edanalyzer.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;
import com.bobpatton3.edanalyzer.persistence.model.Arrival;
import com.bobpatton3.edanalyzer.service.IArrivalService;

@RestController
@RequestMapping(value="/arrivals")
public class ArrivalController {

    
    @Autowired
    private IArrivalService arrivalService;
    
    @GetMapping
    public Map<String, Map<String, double[]>> getAggregatedArrivalsData() {
        Iterable<AggregatedArrivalHour> arrivals = arrivalService.getAggregatedArrivals();
        String[] dayLabels = {"SUN","MON","TUE","WED","THU","FRI","SAT","AVG" };
        
        Map<String, Map<String, double[]>> retArrivals = new HashMap<String, Map<String, double[]>>();
        retArrivals.put("Full", new HashMap<String, double[]>());
        retArrivals.put("lvl5CC", new HashMap<String, double[]>());

        for (int i = 0; i < 8; i++ ) {
            retArrivals.get("Full").put(dayLabels[i], new double[25] );
            retArrivals.get("lvl5CC").put(dayLabels[i], new double[25] );
        }
        double[] avg_all = new double[25];
        double[] avg_lvl5cc = new double[25];
        
        
        arrivals.forEach(a -> {
            int hod = a.getHod();
            String day = dayLabels[a.getDow()];
            double all_rvus = a.getAll_avg_rvus().doubleValue();
            double lvl5cc_rvus = a.getLvl5cc_avg_rvus().doubleValue();
            avg_all[hod] += all_rvus;
            avg_lvl5cc[hod] += lvl5cc_rvus;
            
            retArrivals.get("Full").get(day)[hod] = all_rvus;
            retArrivals.get("lvl5CC").get(day)[hod] = lvl5cc_rvus;
        });
        
        for (int i = 0; i < 6; i++ ) {
            String priorDay = dayLabels[i];
            String nextDay = dayLabels[i+1];
            retArrivals.get("Full").get(priorDay)[24] = retArrivals.get("Full").get(nextDay)[0];
            retArrivals.get("lvl5CC").get(priorDay)[24] = retArrivals.get("lvl5CC").get(nextDay)[0];
        }

        retArrivals.get("Full").get("SAT")[24] = retArrivals.get("Full").get("SUN")[0];
        retArrivals.get("lvl5CC").get("SAT")[24] = retArrivals.get("lvl5CC").get("SUN")[0];
        
        for (int i = 0; i < 24; i++ ) {
            retArrivals.get("Full").get("AVG")[i] = retArrivals.get("Full").get("AVG")[i] / 7.0;
            retArrivals.get("lvl5CC").get("AVG")[i] = retArrivals.get("lvl5CC").get("AVG")[i] / 7.0;
        }

        retArrivals.get("Full").get("AVG")[24] = retArrivals.get("Full").get("AVG")[0];
        retArrivals.get("lvl5CC").get("AVG")[24] = retArrivals.get("lvl5CC").get("AVG")[0];
        
        return retArrivals;
    }
    
    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProjectDto dto) {
        Arrival arrival = convertProjectDtoToEntity(dto);
        arrival.setDateCreated(LocalDate.now());
        arrivalService.save(arrival);
    }
    
    {
            Full: {
                SUN: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                MON: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                TUE: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                WED: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                THU: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                FRI: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                SAT: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                AVG: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            },
            lvl5CC:
            {
                SUN: [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                MON: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                TUE: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                WED: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                THU: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                FRI: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                SAT: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                AVG: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            }
        };
    */
    
}

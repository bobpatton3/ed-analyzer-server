package com.bobpatton3.edanalyzer.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.persistence.model.AggregatedArrivalHour;
import com.bobpatton3.edanalyzer.service.IArrivalService;

@RestController
@RequestMapping(value = "/arrivals")
public class ArrivalController {

    private static final Logger LOG = LoggerFactory.getLogger(ArrivalController.class);

    @Autowired
    private IArrivalService arrivalService;

    // URL: http://localhost:8080/arrivals/2022-01-02%2000:00/2022-07-01%2000:00/30%20minutes/A1%20Emergency%20Physicians/Memorial%20Hospital/Main%20ED

    @GetMapping("/{start_date}/{end_date}/{door_to_prov}/{department_id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Map<String, Map<String, double[]>> getAggregatedArrivalsData(@PathVariable String start_date, @PathVariable String end_date, @PathVariable String door_to_prov, @PathVariable UUID department_id) {
        // Do some checks on the three strings - Assure the first two can resolve to a date and that the third resolves to a SQL interval?
        // On the other hand, those conversions are checked in the PostGreSQL function that is called.
        // Maybe just catch all exceptions and return an empty Map to hide details from the caller
        
        LOG.info("getAggregatedArrivalsData: {} : {} : {}", start_date, end_date, door_to_prov);

        Map<String, Map<String, double[]>> retArrivals = new HashMap<>();

        try {
            Iterable<AggregatedArrivalHour> arrivals = arrivalService.getAggregatedArrivals(start_date, end_date, door_to_prov, department_id);

            String[] dayLabels = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "AVG" };
            retArrivals.put("Full", new HashMap<>());
            retArrivals.put("l5CC", new HashMap<>());

            for (int i = 0; i < 8; i++) {
                retArrivals.get("Full").put(dayLabels[i], new double[25]);
                retArrivals.get("l5CC").put(dayLabels[i], new double[25]);
            }

            arrivals.forEach(a -> {
                int hod = a.getHod();
                String day = dayLabels[a.getDow()];
                double all_rvus = Math.round(a.getAll_avg_rvus().doubleValue() * 100) / 100.0;
                double l5cc_rvus = Math.round(a.getL5cc_avg_rvus().doubleValue() * 100) / 100.0;
                retArrivals.get("Full").get("AVG")[hod] += all_rvus;
                retArrivals.get("l5CC").get("AVG")[hod] += l5cc_rvus;

                retArrivals.get("Full").get(day)[hod] = all_rvus;
                retArrivals.get("l5CC").get(day)[hod] = l5cc_rvus;
            });

            for (int i = 0; i < 6; i++) {
                String priorDay = dayLabels[i];
                String nextDay = dayLabels[i + 1];
                retArrivals.get("Full").get(priorDay)[24] = retArrivals.get("Full").get(nextDay)[0];
                retArrivals.get("l5CC").get(priorDay)[24] = retArrivals.get("l5CC").get(nextDay)[0];
            }

            retArrivals.get("Full").get("SAT")[24] = retArrivals.get("Full").get("SUN")[0];
            retArrivals.get("l5CC").get("SAT")[24] = retArrivals.get("l5CC").get("SUN")[0];

            for (int i = 0; i < 24; i++) {
                retArrivals.get("Full").get("AVG")[i] = retArrivals.get("Full").get("AVG")[i] / 7.0;
                retArrivals.get("l5CC").get("AVG")[i] = retArrivals.get("l5CC").get("AVG")[i] / 7.0;
            }

            retArrivals.get("Full").get("AVG")[24] = retArrivals.get("Full").get("AVG")[0];
            retArrivals.get("l5CC").get("AVG")[24] = retArrivals.get("l5CC").get("AVG")[0];
            
        } catch (Exception e) {
            LOG.error(e.toString());
        }

        return retArrivals;
    }

}

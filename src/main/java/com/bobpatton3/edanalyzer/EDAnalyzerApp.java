package com.bobpatton3.edanalyzer;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bobpatton3.edanalyzer.persistence.model.Arrival;
import com.bobpatton3.edanalyzer.persistence.repository.IScheduleRepository;
import com.bobpatton3.edanalyzer.service.IArrivalService;
import com.bobpatton3.edanalyzer.service.IScheduleService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EDAnalyzerApp {

    private static final Logger LOG = LoggerFactory.getLogger(EDAnalyzerApp.class);
    
    @Autowired
    private IArrivalService arrivalService;
    
    @Autowired
    IScheduleService scheduleService;
    
    @Autowired
    IScheduleRepository scheduleRepository;

    public static void main(String[] args) {
        SpringApplication.run(EDAnalyzerApp.class, args);
    }

    // @PostConstruct
    public void postConstruct() {
        LOG.info("Fetching all schedules: ");
        scheduleRepository.findAll().forEach(p -> LOG.info(p.toString()));
        
        // generateAllBasicData();
    }
    
    /*
     * 
     * This was used just to create the data. I might need it again but will have to work around some breaking changes I made on the ArrivalService and such
    private void generateAllBasicData() {

        for (int i = 0; i < 1440; i++) {
            
            int arrivals_to_generate = interpolateArrivalsCurve(i);
            
            for (int j = 0; j < arrivals_to_generate; j++ ) {
                String cpt = randomCPT();
                BigDecimal rvus = BigDecimal.valueOf(randomRVUs(cpt));
                Instant inst = Instant.ofEpochMilli( 1640476800000l + 604800000l*(long)(54.0*Math.random()) + 86400000l*randomDOW() + i*60000l );
                ZonedDateTime zonedArrival = ZonedDateTime.ofInstant(inst, ZoneId.of("UTC"));

                arrivalService.save(new Arrival(
                    UUID.randomUUID(),
                    "A1 Emergency Physicians",
                    "Memorial Hospital",
                    "Main ED",
                    zonedArrival,
                    rvus,
                    cpt,
                    0));
            }
        }

    }
    
    private int interpolateArrivalsCurve(int minute_of_day) {
        double[] values = {6, 3.5, 3.5, 2.5, 3, 4, 6, 8, 9, 12, 17, 21, 23, 24, 23, 21, 22, 21.5, 23, 22, 19, 13, 11, 7, 6};
        
        int hod = (int)( Math.floor(minute_of_day / 60.0) );
        double portion_of_hour = (minute_of_day%60)/60.0;
        
        int retVal = (int) (5.0 * (values[hod] * (1 - portion_of_hour)  + values[hod+1] * portion_of_hour) );
        
        return retVal;
    }
    
    private String randomCPT() {
        double rand = Math.random();
        if (rand < 0.05) return "99282";
        else if (rand < 0.3) return "99283";
        else if (rand < 0.75) return "99284";
        else if (rand < 0.92) return "99285";
        else return "99291";
    }
    
    private int randomDOW() {
        double rand = Math.random();
        if (rand < 0.16) return 1;
        else if (rand < 0.315) return 2;
        else if (rand < 0.46) return 3;
        else if (rand < 0.605) return 4;
        else if (rand < 0.750) return 5;
        else if (rand < 0.875) return 6;
        else return 0;
    }
    
    private double randomRVUs(String cpt) {
        double rand = Math.random();
        if(cpt.equals("99282")) return 1.0 + 2 * rand;
        else if(cpt.equals("99283")) return 1.4 + 3 * rand;
        else if(cpt.equals("99284")) return 2.6 + 5 * rand;
        else if(cpt.equals("99285")) return 3.8 + 7 * rand;
        else return 4.5 + 8 * rand;
    }
*/
    
}

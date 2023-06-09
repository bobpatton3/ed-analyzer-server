package com.bobpatton3.edanalyzer.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.persistence.model.Arrival;
import com.bobpatton3.edanalyzer.service.IArrivalService;
@RestController
@RequestMapping(value="/arrivals")
public class ArrivalController {

    
    @Autowired
    private IArrivalService arrivalService;
    
    @GetMapping
    public Collection<Arrival> findAll() {
        Iterable<Arrival> arrivals = arrivalService.findAll();
        List<Arrival> retArrivals = new ArrayList<Arrival>();
        arrivals.forEach(a -> retArrivals.add(a));
        
        return retArrivals;
    }
    
}

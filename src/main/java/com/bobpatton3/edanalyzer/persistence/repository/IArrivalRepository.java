package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.Arrival;

public interface IArrivalRepository extends CrudRepository<Arrival, UUID>{

}

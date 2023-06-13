package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.Schedule;

public interface IScheduleRepository extends CrudRepository<Schedule, UUID> {

    
}

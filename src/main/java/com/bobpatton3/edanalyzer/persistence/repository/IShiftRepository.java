package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bobpatton3.edanalyzer.persistence.model.Shift;

public interface IShiftRepository extends CrudRepository<Shift, UUID> {
    

}

package com.bobpatton3.edanalyzer.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bobpatton3.edanalyzer.persistence.model.PostLoginInfo;

public interface IPostLoginInfoRepository extends CrudRepository<PostLoginInfo, UUID> {
    
    @Query(value = "SELECT dm.* "
                + " FROM department_metadata as dm "
                + " INNER JOIN user_department_auth as uda ON uda.department_id = dm.department_id "
                + " WHERE uda.user_id = :user_id AND uda.status = 'ACTIVE' ", 
           nativeQuery = true)
    public Iterable<PostLoginInfo> findAllForUser(@Param("user_id") UUID user_id);

}

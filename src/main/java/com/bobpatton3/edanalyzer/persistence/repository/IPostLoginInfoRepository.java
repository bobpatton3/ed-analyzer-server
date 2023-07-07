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
                + " INNER JOIN users as u on u.id = uda.user_id "
                + " WHERE u.username = :username AND uda.status = 'ACTIVE' ", 
           nativeQuery = true)
    public Iterable<PostLoginInfo> findAllForUser(@Param("username") String username);

}

package com.bobpatton3.edanalyzer.service;

import java.util.UUID;

import com.bobpatton3.edanalyzer.persistence.model.PostLoginInfo;

public interface IPostLoginInfoService {
    
    Iterable<PostLoginInfo> findAll(UUID user_id);

}

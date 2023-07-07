package com.bobpatton3.edanalyzer.service;

import com.bobpatton3.edanalyzer.persistence.model.PostLoginInfo;

public interface IPostLoginInfoService {
    
    Iterable<PostLoginInfo> findAll(String username);

}

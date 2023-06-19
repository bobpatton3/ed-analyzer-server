package com.bobpatton3.edanalyzer.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobpatton3.edanalyzer.persistence.model.PostLoginInfo;
import com.bobpatton3.edanalyzer.persistence.repository.IPostLoginInfoRepository;
import com.bobpatton3.edanalyzer.service.IPostLoginInfoService;

@Service
public class PostLoginInfoServiceImpl implements IPostLoginInfoService
{
    
    @Autowired
    private IPostLoginInfoRepository postLoginInfoRepository;

    @Override
    public Iterable<PostLoginInfo> findAll(UUID user_id) {
        return postLoginInfoRepository.findAllForUser(user_id);
    }

}

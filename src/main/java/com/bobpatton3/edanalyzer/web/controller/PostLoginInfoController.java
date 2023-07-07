package com.bobpatton3.edanalyzer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobpatton3.edanalyzer.persistence.model.PostLoginInfo;
import com.bobpatton3.edanalyzer.service.IPostLoginInfoService;

@RestController
@RequestMapping(value="/post_login_info")
public class PostLoginInfoController {
    
    @Autowired
    private IPostLoginInfoService postLoginInfoService;
    
    @GetMapping("/{username}")
    @CrossOrigin(origins = "http://localhost:3000")
    Iterable<PostLoginInfo> findAll(@PathVariable String username) {
        return postLoginInfoService.findAll(username);
    }

}

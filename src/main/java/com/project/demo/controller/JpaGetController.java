package com.project.demo.controller;

import com.project.demo.entity.JpaEntity;
import com.project.demo.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JpaGetController {

    @Autowired
    JpaService jpaService;

    @RequestMapping(value = "/get/{id}", method= RequestMethod.GET)
    public JpaEntity getMethod(@PathVariable("id") int id){
        return jpaService.getById(id);
    }

}

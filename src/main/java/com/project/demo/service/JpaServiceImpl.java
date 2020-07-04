package com.project.demo.service;

import com.project.demo.entity.JpaEntity;
import com.project.demo.repo.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaServiceImpl implements JpaService {

    @Autowired
    JpaRepo jpaRepo;

    @Override
    public JpaEntity getById(int id){
        return jpaRepo.getOne(id);
    }
}

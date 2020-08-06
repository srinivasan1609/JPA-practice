package com.project.demo.service;

import com.project.demo.entity.JpaEntity;
import com.project.demo.model.JpaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JpaService {

     JpaEntity getById(int id);

     JpaEntity getByName(String name);

     List<JpaEntity> getOrderByNameAsc();

     List<JpaEntity> getByNameContains(String name);

     List<JpaEntity> getLimit();

     Page<JpaEntity> getAllPagable(int from,int limit);

     JpaEntity insertTable(JpaModel jpaModel);
}

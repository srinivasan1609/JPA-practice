package com.project.demo.service;

import com.project.demo.entity.JpaEntity;
import com.project.demo.entity.JpaJoinEntity;
import com.project.demo.model.JpaModel;
import com.project.demo.repo.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaServiceImpl implements JpaService {

    @Autowired
    JpaRepo jpaRepo;

    @Override
    public JpaEntity getById(int id){
        return jpaRepo.findById(id).get();
    }

    @Override
    public JpaEntity getByName(String name){
        return jpaRepo.findByName(name);
    }

    @Override
    public List<JpaEntity> getOrderByNameAsc(){
        return jpaRepo.findAllByOrderByNameAsc();
    }

    @Override
    public List<JpaEntity> getByNameContains(String name){
        return jpaRepo.findAllByNameContains(name);
    }

    @Override
    public List<JpaEntity> getLimit(){
        return jpaRepo.findFirst3ByOrderByNameAsc();
    }

    @Override
    public Page<JpaEntity> getAllPagable(int from,int limit){
        Pageable pageable = PageRequest.of(from, limit,Sort.by("name").ascending());
        return jpaRepo.findAll(pageable);
    }

    @Override
    public JpaEntity insertTable(JpaModel jpaModel){
        JpaJoinEntity address = JpaJoinEntity.builder()
                .doorNo(jpaModel.getDoorNo())
                .street(jpaModel.getStreet())
                .area(jpaModel.getArea())
                .city(jpaModel.getCity())
                .pinCode(jpaModel.getPinCode())
                .build();
        JpaEntity customer = JpaEntity.builder().age(jpaModel.getAge()).name(jpaModel.getName()).email(jpaModel.getEmail()).gender(jpaModel.getGender()).address(address).build();
        return jpaRepo.save(customer);

    }
}

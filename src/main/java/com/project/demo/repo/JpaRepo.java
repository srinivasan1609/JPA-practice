package com.project.demo.repo;

import com.project.demo.entity.JpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRepo extends JpaRepository<JpaEntity,Integer> {

    JpaEntity findByName(String name);

    List<JpaEntity> findAllByOrderByNameAsc();

    List<JpaEntity> findAllByNameContains(String name);

    List<JpaEntity> findFirst3ByOrderByNameAsc();

    Page<JpaEntity> findAll(Pageable pageable);
}

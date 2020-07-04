package com.project.demo.repo;

import com.project.demo.entity.JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<JpaEntity,Integer> {
}

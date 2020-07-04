package com.project.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="demo_table")
@Data
public class JpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
}

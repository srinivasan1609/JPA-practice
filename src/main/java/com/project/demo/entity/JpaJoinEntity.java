package com.project.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name="address_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JpaJoinEntity {

    @Id
    @Column(name ="id")
    private int id;

    private String doorNo;

    private String street;

    private String area;

    private String city;

    private long pinCode;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private JpaEntity customer;
}

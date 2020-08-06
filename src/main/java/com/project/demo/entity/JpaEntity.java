package com.project.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="demo_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length = 5)
    @NonNull
    @Size(min=3,max=5)
    private String name;

    private int age;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToOne(mappedBy = "customer",cascade =CascadeType.ALL,optional = true)
    private JpaJoinEntity address;

    @CreationTimestamp
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}

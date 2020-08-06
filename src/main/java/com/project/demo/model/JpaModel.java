package com.project.demo.model;

import com.project.demo.entity.Gender;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class JpaModel {

    @Size(min=3,max=5,message="Name should be between 3 to 5 Characters")
    @NotEmpty(message="Name should be empty")
    private String name;

    @Min(value=15,message="Age should be greater than 15")
    @Max(value=50,message="Age should be less than 50")
    private int age;

    private String email;

    private Gender gender;

    private String doorNo;

    private String street;

    private String area;

    private String city;

    private long pinCode;
}

package com.alex.model.models;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;




@Table(name = "price")
@Data
public class Price extends GeneralModel  {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "agency_salary")
    private Float agencySalary;

}


package com.alex.model.models;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;

import lombok.Data;


@Table(name = "animator")
@Data
public class Animator extends GeneralModel {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameAnimator;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;
}

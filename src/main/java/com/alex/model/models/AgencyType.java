package com.alex.model.models;


import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;

@Table(name = "agency_type")
@Data
public class AgencyType extends GeneralModel{

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameAgencyType;
}

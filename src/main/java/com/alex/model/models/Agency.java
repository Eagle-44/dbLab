package com.alex.model.models;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;

@Table(name = "agency")
@Data
public class Agency extends GeneralModel {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "agency_type_id")
    private Integer agencyTypeId;

    @Column(name = "name_agency")
    private String nameAgency;

}

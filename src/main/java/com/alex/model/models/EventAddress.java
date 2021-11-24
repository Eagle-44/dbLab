package com.alex.model.models;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;

@Table(name = "event_address")
@Data
public class EventAddress extends GeneralModel  {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "street")
    private String streetName;

    @Column(name = "postal_code")
    private String postalCode;
}


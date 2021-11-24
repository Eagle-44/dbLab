package com.alex.model.models;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;

@Table(name = "event")
@Data
public class Event extends GeneralModel  {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameEvent;

    @Column(name = "event_duration")
    private String eventDuration;

    @Column(name = "date_of_the_event")
    private String dateOfEvent;

    @Column(name = "event_address_id")
    private Integer eventAddressId;

}

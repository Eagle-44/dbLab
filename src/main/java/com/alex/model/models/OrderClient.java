package com.alex.model.models;


import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;

@Table(name = "order_client")
@Data
public class OrderClient extends GeneralModel {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "animator_id")
    private Integer animatorId;

    @Column(name = "agency_id")
    private Integer agencyId;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "price_id")
    private Integer priceId;

}

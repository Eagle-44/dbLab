package com.alex.DTO;

import com.alex.models.*;

public class OrderClientDTO {
    private OrderClient orderClient;

    public OrderClientDTO(OrderClient orderClient){
        this.orderClient = orderClient;
    }

    public Integer getId() {
        return orderClient.getId();

    }
    public Agency getAgencyId() {
        return orderClient.getAgencyId();
    }

    public Animator getAnimatorId() {
        return orderClient.getAnimatorId();
    }

    public Client getClientId() {
        return orderClient.getClientId();
    }

    public Event getEventId() {
        return orderClient.getEventId();
    }

    public Price getPriceId() {
        return orderClient.getPriceId();
    }
}

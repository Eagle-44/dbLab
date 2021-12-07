package com.alex.DTO;

import com.alex.models.EventAddress;

public class EventAddressDTO {
    private EventAddress eventAddress;

    public EventAddressDTO(EventAddress eventAddress){
        this.eventAddress = eventAddress;
    }

    public Integer getId() {
        return eventAddress.getId();
    }

    public String getStreet() {
        return eventAddress.getStreet();
    }

    public String getPostalCode() {
        return eventAddress.getPostalCode();
    }
}

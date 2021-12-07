package com.alex.DTO;

import com.alex.models.Client;

public class ClientDTO {
    private Client client;

    public ClientDTO(Client client){
        this.client = client;
    }

    public Integer getId() {
        return client.getId();
    }

    public String getLastName() {
        return client.getLastName();
    }

    public String getName() {
        return client.getName();
    }

    public String getPhoneNumber() {
        return client.getPhoneNumber();
    }
}

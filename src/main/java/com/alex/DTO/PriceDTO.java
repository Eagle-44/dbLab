package com.alex.DTO;

import com.alex.models.Price;

public class PriceDTO {
    private Price price;

    public PriceDTO(Price price){
        this.price = price;
    }

    public Integer getId() {
        return price.getId();
    }

    public Float getSalary() {
        return price.getSalary();
    }

    public Float getAgencySalary() {
        return price.getAgencySalary();
    }

}

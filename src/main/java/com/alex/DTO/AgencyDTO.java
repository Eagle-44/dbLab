package com.alex.DTO;

import com.alex.models.Agency;
import com.alex.models.AgencyType;

public class AgencyDTO {
    private Agency agency;

    public AgencyDTO (Agency agency) {
        this.agency = agency;
    }

    public Integer getId() {
        return agency.getId();
    }

    public AgencyType getAgencyTypeId() {
        return agency.getAgencyTypeId();
    }

    public String getAgencyName() {
        return agency.getAgencyName();
    }

}

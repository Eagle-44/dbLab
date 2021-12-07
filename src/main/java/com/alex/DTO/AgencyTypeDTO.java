package com.alex.DTO;

import com.alex.models.AgencyType;

public class AgencyTypeDTO {
    private AgencyType agencyType;

    public AgencyTypeDTO(AgencyType agencyType) {
        this.agencyType = agencyType;
    }

    public String getNameType() {
        return agencyType.getNameType();
    }

    public Integer getId() {
        return agencyType.getId();
    }
}

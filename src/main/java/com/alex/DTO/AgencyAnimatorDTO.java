package com.alex.DTO;

import com.alex.models.Agency;
import com.alex.models.AgencyAnimator;

public class AgencyAnimatorDTO {
    private AgencyAnimator agencyAnimator;

    public AgencyAnimatorDTO(AgencyAnimator agencyAnimator) {
        this.agencyAnimator = agencyAnimator;
    }

    public Integer getId() {
        return agencyAnimator.getId();
    }

    public Agency getAnimatorId() {
        return agencyAnimator.getAnimatorId();
    }

    public Agency getAgencyId() {
        return agencyAnimator.getAgencyId();
    }
}

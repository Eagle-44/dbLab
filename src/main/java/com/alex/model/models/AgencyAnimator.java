package com.alex.model.models;

import com.alex.model.models.annotation.Column;
import com.alex.model.models.annotation.PrimaryKey;
import com.alex.model.models.annotation.Table;
import lombok.Data;

@Table(name = "agency_animator")
@Data
public class AgencyAnimator extends GeneralModel  {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "agency_id")
    private Integer agencyId;

    @Column(name = "animator_id")
    private Integer animatorId;
}


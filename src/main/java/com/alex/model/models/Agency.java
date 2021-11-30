package com.alex.model.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "agency", schema = "event_agency")
public class Agency extends GeneralModel {

    private Integer id;
    private AgencyType agencyTypeId;
    private String nameAgency;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "agency_type_id", referencedColumnName = "id", nullable = false)
    private AgencyType getAgencyTypeId() {
        return agencyTypeId;
    }

    public void setAgencyTypeId(AgencyType agencyTypeId) {
        this.agencyTypeId = agencyTypeId;
    }

    @Basic
    @Column(name = "name_agency")
    private String getNameAgency() {
        return nameAgency;
    };

    public void setNameAgency(String nameAgency) {
        this.nameAgency = nameAgency;
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return Objects.equals(id, agency.id) && Objects.equals(nameAgency ,agency.nameAgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nameAgency);
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", agencyTypeId=" + agencyTypeId +
                ", nameAgency='" + nameAgency + '\'' +
                '}';
    }
}

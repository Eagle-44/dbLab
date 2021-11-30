package com.alex.model.models;


import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agency_type", schema = "event_agency")
public class AgencyType extends GeneralModel{

    private Integer id;
    private String typeAgency;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getNameAgency() {
        return typeAgency;
    }

    public void setNameAgency(String nameAgency) {
        this.typeAgency = nameAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgencyType agencyType = (AgencyType) o;
        return Objects.equals(id, agencyType.id) && Objects.equals(typeAgency ,agencyType.typeAgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,typeAgency);
    }

    @Override
    public String toString() {
        return "AgencyType{" +
                "id=" + id +
                ", typeAgency='" + typeAgency + '\'' +
                '}';
    }
}

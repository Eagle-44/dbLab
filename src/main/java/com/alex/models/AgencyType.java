package com.alex.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "agency_type", schema = "event_agency")
public class AgencyType extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    @Column(name = "name")
    @NotNull(message = "Miss name")
    public String nameType;

    public AgencyType (final String name){
        this.nameType = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgencyType agencyType = (AgencyType) o;
        return Objects.equals(id, agencyType.id) && Objects.equals(nameType,agencyType.nameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameType);
    }

    @Override
    public String toString() {
        return "AgencyType{" +
                "id=" + id +
                ", typeAgency='" + nameType + '\'' +
                '}';
    }
}

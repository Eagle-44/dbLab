package com.alex.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "agency", schema = "event_agency")
public class Agency extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "agency_type_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing AgencyTypeByAgencyTypeId")
    private AgencyType agencyTypeId;


    @Basic
    @Column(name = "name_agency")
    @NotNull(message = "Missing nameAgency")
    private String agencyName;

    public Agency (final AgencyType agencyTypeId, final String agencyName){
        this.agencyTypeId = agencyTypeId;
        this.agencyName = agencyName;
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return Objects.equals(id, agency.id) && Objects.equals(agencyName,agency.agencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,agencyName);
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", agencyTypeId=" + agencyTypeId +
                ", nameAgency='" + agencyName + '\'' +
                '}';
    }
}

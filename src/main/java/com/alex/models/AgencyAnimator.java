package com.alex.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "agency_animator", schema = "event_agency")
public class AgencyAnimator extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing agencyById")
    public Agency agencyId;

    @ManyToOne
    @JoinColumn(name = "animator_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing animatorById")
    public Agency animatorId;

    public AgencyAnimator(final Agency agencyId, final Agency animatorId){
        this.agencyId = agencyId;
        this.animatorId = animatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgencyAnimator agencyAnimator = (AgencyAnimator) o;
        return id.equals(agencyAnimator.id) && agencyId.equals(agencyAnimator.agencyId)
                && animatorId.equals(agencyAnimator.animatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agencyId, animatorId);
    }

    @Override
    public String toString() {
        return "AgencyAnimator{" +
                "id=" + id +
                ", agencyId=" + agencyId +
                ", animatorId=" + animatorId +
                '}';
    }
}

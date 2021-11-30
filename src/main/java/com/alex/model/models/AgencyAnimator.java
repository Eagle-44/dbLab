package com.alex.model.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agency_animator", schema = "event_agency")
public class AgencyAnimator extends GeneralModel{
    private Integer id;
    private Agency agencyId;
    private Animator animatorId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    public Agency getAgencyId() {
        return agencyId;
    }

    @ManyToOne
    @JoinColumn(name = "animator_id", referencedColumnName = "id", nullable = false)
    public Animator getAnimatorId() {
        return animatorId;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setAgencyId(Agency agencyId) {
        this.agencyId = agencyId;
    }

    public void setAnimatorId(Animator animatorId) {
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

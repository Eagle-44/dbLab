package com.alex.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_client",schema = "event_agency")
public class OrderClient extends GeneralModel{
    private Integer id;
    private Animator animatorId;
    private Agency agencyId;
    private Event eventId;
    private Client clientId;
    private Price priceId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "animator_id", referencedColumnName = "id", nullable = false)
    public Animator getAnimatorId() {
        return animatorId;
    }

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    public Agency getAgencyId() {
        return agencyId;
    }

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    public Event getEventId() {
        return eventId;
    }

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClientId() {
        return clientId;
    }

    @OneToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id", nullable = false)
    public Price getPriceId() {
        return priceId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnimatorId(Animator animatorId) {
        this.animatorId = animatorId;
    }

    public void setAgencyId(Agency agencyId) {
        this.agencyId = agencyId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public void setPriceId(Price priceId) {
        this.priceId = priceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderClient orderClient = (OrderClient) o;
        return id.equals(orderClient.id) && animatorId.equals(orderClient.animatorId)
                && agencyId.equals(orderClient.agencyId) && eventId.equals(orderClient.eventId)
                && clientId.equals(orderClient.clientId) && priceId.equals(orderClient.priceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animatorId, agencyId, eventId, clientId, priceId);
    }

    @Override
    public String toString() {
        return "OrderClient{" +
                "id=" + id +
                ", animatorId=" + animatorId +
                ", agencyId=" + agencyId +
                ", eventId=" + eventId +
                ", clientId=" + clientId +
                ", priceId=" + priceId +
                '}';
    }
}

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
@Table(name = "order_client",schema = "event_agency")
public class OrderClient extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "animator_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Miss animatorId")
    public Animator animatorId;


    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Miss agencyId")
    public Agency agencyId;


    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Miss eventId")
    public Event eventId;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Miss clientId")
    public Client clientId;


    @OneToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Miss priceId")
    public Price priceId;

    public OrderClient (final Animator animatorId, final Agency agencyId, final Event eventId, final Client clientId,
                        final Price priceId) {

        this.animatorId = animatorId;
        this.agencyId = agencyId;
        this.eventId = eventId;
        this.clientId = clientId;
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

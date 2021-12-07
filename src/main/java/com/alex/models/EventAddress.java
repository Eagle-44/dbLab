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
@Table(name = "event_address", schema = "event_agency")
public class EventAddress extends GeneralModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer  id;

    @Basic
    @Column(name = "street")
    @NotNull(message = "Miss street")
    public String street;

    @Basic
    @Column(name = "postal_code")
    @NotNull(message = "Miss postalCode")
    public String postalCode;

    public EventAddress(final String street, final String postalCode){
        this.street = street;
        this.postalCode = postalCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventAddress eventAddress = (EventAddress) o;
        return id.equals(eventAddress.id) && street.equals(eventAddress.street)
                && postalCode.equals(eventAddress.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postalCode);
    }

    @Override
    public String toString() {
        return "EventAddress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}

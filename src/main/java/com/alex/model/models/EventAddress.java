package com.alex.model.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event_address", schema = "event_agency")
public class EventAddress extends GeneralModel {
    private Integer id;
    private String street;
    private String postalCode;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
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

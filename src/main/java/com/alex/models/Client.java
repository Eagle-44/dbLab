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
@Table(name = "client", schema = "event_agency")
public class Client extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    @NotNull(message = "Miss name")
    private String name;


    @Basic
    @Column(name = "last_name")
    @NotNull(message = "Miss lastName")
    private String lastName;


    @Basic
    @Column(name = "phone_number")
    @NotNull(message = "Miss phoneNumber")
    private String phoneNumber;

    public Client(final String name, final String lastName, final String phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && name.equals(client.name) && lastName.equals(client.lastName)
                && phoneNumber.equals(client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "ClientService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

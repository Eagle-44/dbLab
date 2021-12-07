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
@Table(name = "animator", schema = "event_agency")
public class Animator extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    @Column(name = "name")
    @NotNull(message = "Miss name")
    public String name;

    @Basic
    @Column(name = "last_name")
    @NotNull(message = "Miss last name")
    private String lastName;

    @Basic
    @Column(name = "age")
    @NotNull(message = "Miss age")
    private Integer age;

    public Animator (final String name, final String lastName, final Integer age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animator animator = (Animator) o;
        return Objects.equals(id,animator.id) && Objects.equals(name,animator.name)
                && Objects.equals(lastName,animator.lastName) && Objects.equals(age,animator.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,lastName,age);
    }

    @Override
    public String toString() {
        return "Animator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

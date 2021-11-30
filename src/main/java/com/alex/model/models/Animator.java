package com.alex.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "animator", schema = "event_agency")
public class Animator extends GeneralModel{

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
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

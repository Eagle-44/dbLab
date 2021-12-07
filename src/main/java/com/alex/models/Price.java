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
@Table(name = "price", schema = "event_agency")
public class Price extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    @Basic
    @Column(name = "salary")
    @NotNull(message = "Miss salary")
    public Float salary;


    @Basic
    @Column(name = "agency_salary")
    @NotNull(message = "Miss agencySalary")
    public Float agencySalary;

    public Price (final Float salary, final Float agencySalary){
        this.salary = salary;
        this.agencySalary = agencySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id.equals(price.id) && salary.equals(price.salary) && agencySalary.equals(price.agencySalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, agencySalary);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", salary=" + salary +
                ", agencySalary=" + agencySalary +
                '}';
    }
}

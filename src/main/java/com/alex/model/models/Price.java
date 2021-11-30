package com.alex.model.models;


import net.sf.saxon.trans.SymbolicName;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "price", schema = "event_agency")
public class Price extends GeneralModel{
    private Integer id;
    private Float salary;
    private Float agencySalary;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Basic
    @Column(name = "salary")
    public Float getSalary() {
        return salary;
    }

    @Basic
    @Column(name = "agency_salary")
    public Float getAgencySalary() {
        return agencySalary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public void setAgencySalary(Float agencySalary) {
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

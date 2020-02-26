package com.example.demo;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<Employee> employees;

    public Company() {

    }

    public Company(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

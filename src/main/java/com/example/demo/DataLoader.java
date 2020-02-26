package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... strings) throws Exception {
        Set<Employee> employees = new HashSet<>();
        Company company = new Company();
        company.setName("Facebook");
        Employee employee;
        employee = new Employee("FE1", company);
        employees.add(employee);
        employee = new Employee("FE2", company);
        employees.add(employee);
        company.setEmployees(employees);
        companyRepository.save(company);

        Set<Employee> employees2 = new HashSet<>();
        Company company2 = new Company();
        company2.setName("Google");
        Employee employee2;
        employee2 = new Employee("GE1", company2);
        employees2.add(employee2);
        employee2 = new Employee("GE2", company2);
        employees2.add(employee2);
        company2.setEmployees(employees2);
        companyRepository.save(company2);

    }

}

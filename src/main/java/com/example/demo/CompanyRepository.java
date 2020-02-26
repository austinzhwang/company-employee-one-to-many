package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    public ArrayList<Company> findByNameIgnoreCase(String name);
}

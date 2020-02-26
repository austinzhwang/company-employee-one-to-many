package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "index";
    }

    @GetMapping("/addcompany")
    public String addTeam(Model model) {
        model.addAttribute("company", new Company());
        return "companyform";
    }

    @PostMapping("/processcompany")
    public String processTeam(@ModelAttribute Company company) {
        companyRepository.save(company);
        return "redirect:/";
    }

    @GetMapping("/addemployee")
    public String addEmployee(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

    @PostMapping("/processemployee")
    public String processEmployee(@ModelAttribute Employee employee) {
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        Company company = new Company();
        company.setEmployees(employees);
        companyRepository.save(company);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("companySearch", companyRepository.findByNameIgnoreCase(search));
        return "searchlist";
    }

}
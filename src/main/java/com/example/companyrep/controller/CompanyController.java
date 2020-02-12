package com.example.companyrep.controller;

import com.example.companyrep.service.Company;
import com.example.companyrep.service.CompanyDto;
import com.example.companyrep.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public List<CompanyDto> getAllCompanies(){
        return companyService.getAllCompanies().stream().map(Company::toDto).collect(Collectors.toList());

    }

    @PostMapping("/")
    public CompanyDto addCompany(@RequestBody Company company){
        return companyService.addCompany(company).toDto();
    }

    @PutMapping("/{existingName}")
    public CompanyDto updateCompany(@PathVariable("existingName") String existingName, @RequestBody Company company){
        return companyService.updateCompany(existingName, company).toDto();
    }

    @DeleteMapping("/{existingName}")
    @Transactional
    public void deleteCompany(@PathVariable String existingName)
    {
        companyService.deleteCompany(existingName);
    }
}

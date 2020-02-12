package com.example.companyrep.service;

import lombok.Data;

@Data
public class Company {

    private String name;
    private String activitySector;

    public CompanyDto toDto(){
        CompanyDto dto = new CompanyDto();
        dto.setName(name);
        return dto;
    }

    public Company update(CompanyDto dto) {
        this.name = dto.getName();
        return this;
    }
}

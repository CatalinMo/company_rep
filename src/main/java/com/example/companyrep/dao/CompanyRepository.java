package com.example.companyrep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer> {
    Optional<CompanyEntity> findCompanyByName(String name);
    void deleteByName(String name);

}

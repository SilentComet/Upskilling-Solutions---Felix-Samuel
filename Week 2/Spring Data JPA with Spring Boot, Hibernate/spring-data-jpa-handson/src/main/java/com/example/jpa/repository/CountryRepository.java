package com.example.jpa.repository;

import com.example.jpa.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // Derived query method
    Country findByCode(String code);

    // HQL Query
    @Query("SELECT c FROM Country c")
    List<Country> findAllCountriesUsingHQL();

    // Native Query
    @Query(value = "SELECT * FROM COUNTRY", nativeQuery = true)
    List<Country> findAllCountriesUsingNativeQuery();
}\n
package com.example.jpa.service;

import com.example.jpa.entity.Country;
import com.example.jpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country findByCountryCode(String code) {
        return countryRepository.findByCode(code);
    }

    public List<Country> findAllCountriesHQL() {
        return countryRepository.findAllCountriesUsingHQL();
    }

    public List<Country> findAllCountriesNative() {
        return countryRepository.findAllCountriesUsingNativeQuery();
    }
}\n
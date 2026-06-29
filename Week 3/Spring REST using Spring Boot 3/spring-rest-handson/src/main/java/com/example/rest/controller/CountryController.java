package com.example.rest.controller;

import com.example.rest.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add((Country) context.getBean("usCountry"));
        countries.add((Country) context.getBean("inCountry"));
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        if ("US".equalsIgnoreCase(code)) {
            return (Country) context.getBean("usCountry");
        } else if ("IN".equalsIgnoreCase(code)) {
            return (Country) context.getBean("inCountry");
        }
        return new Country(code, "Unknown");
    }
}\n
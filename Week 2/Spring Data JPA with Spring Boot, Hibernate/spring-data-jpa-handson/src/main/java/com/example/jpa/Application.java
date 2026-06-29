package com.example.jpa;

import com.example.jpa.entity.Country;
import com.example.jpa.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(CountryService countryService) {
        return args -> {
            System.out.println("--- Starting Database Operations ---");
            countryService.addCountry(new Country("US", "United States"));
            countryService.addCountry(new Country("IN", "India"));
            countryService.addCountry(new Country("UK", "United Kingdom"));

            System.out.println("\n--- Find by Country Code (IN) ---");
            Country c = countryService.findByCountryCode("IN");
            System.out.println(c.getName());

            System.out.println("\n--- HQL Query to get all countries ---");
            List<Country> allHQL = countryService.findAllCountriesHQL();
            allHQL.forEach(country -> System.out.println(country.getCode() + " - " + country.getName()));

            System.out.println("\n--- Native Query to get all countries ---");
            List<Country> allNative = countryService.findAllCountriesNative();
            allNative.forEach(country -> System.out.println(country.getCode() + " - " + country.getName()));
        };
    }
}\n
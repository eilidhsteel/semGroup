package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printPopulationCityTestNull()
    {
        app.printPopulationCity(null);
    }

    @Test
    void printPopulationCityTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printPopulationCity(cities);
    }

    @Test
    void printPopulationCityTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printPopulationCity(cities);
    }

    @Test
    void printPopulationCity()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.city_name = "London";
        city.country = "United Kingdom";
        city.district = "England";
        city.population = 100;
        cities.add(city);
        app.printPopulationCity(cities);
    }

    @Test
    void printPopulationCapitalTestNull()
    {
        app.printPopulationCapital(null);
    }

    @Test
    void printPopulationCapitalTestEmpty()
    {
        ArrayList<City> capitals = new ArrayList<City>();
        app.printPopulationCapital(capitals);
    }

    @Test
    void printPopulationCapitalTestContainsNull()
    {
        ArrayList<City> capitals = new ArrayList<City>();
        capitals.add(null);
        app.printPopulationCapital(capitals);
    }

    @Test
    void printPopulationCapital()
    {
        ArrayList<City> capitals = new ArrayList<City>();
        City city = new City();
        city.city_name = "London";
        city.country = "United Kingdom";
        city.district = "England";
        city.population = 100;
        capitals.add(city);
        app.printPopulationCity(capitals);
    }

    @Test
    void printPopulationCountryTestNull()
    {
        app.printPopulationCountry(null);
    }

    @Test
    void printPopulationCountryTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printPopulationCountry(countries);
    }

    @Test
    void printPopulationCountryTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printPopulationCountry(countries);
    }

    @Test
    void printPopulationCountry()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.country_name = "UK";
        country.country_Code = "UKA";
        country.continent = "Europe";
        country.region = "Europe";
        country.surface_area = 1234;
        country.indep_Year = 1234;
        country.population = 1234;
        country.life_Expectancy= 12;
        country.GNP = 1234;
        country.GNP_old = 1234;
        country.local_Name = "UK";
        country.government_form = "abc";
        country.head_of_state = "John Smith";
        //country.capital = NULL;
        country.country_code2 = "ABC";
        countries.add(country);
        app.printPopulationCountry(countries);
    }
}

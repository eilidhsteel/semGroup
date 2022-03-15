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
    void printPopulationTestNull()
    {
        app.printPopulation(null);
    }

    @Test
    void printPopulationTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printPopulation(cities);
    }

    @Test
    void printPopulationTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printPopulation(cities);
    }

    @Test
    void printSalaries()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.city_name = "Santa Rita";
        city.country = "United Kingdom";
        city.district = "Paraíba";
        city.population = 10;
        cities.add(city);
        app.printPopulation(cities);
    }
}

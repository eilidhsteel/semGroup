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

    //passing a null value into to displycity method
    @Test
    void displayCityTestNull()
    {
        app.displayCity(null);
    }

    //testing the displaycity method to see if ti passes with no values added
    @Test
    void displayCityTestNoDetails()
    {
        City city = new City();
        app.displayCity(city);
    }

    //method to allow new details to be added to the displaycity methods
    @Test
    void displayCity()
    {
        City city = new City();
        city.city_name = "London";
        city.country = "United Kingdom";
        city.district = "England";
        city.population = 100;
        app.displayCity(city);
    }

    ////passing a null value into to printpopualtioncity method
    @Test
    void printPopulationCityTestNull()
    {
        app.printPopulationCity(null);
    }

    //test created to check if the print method below can be run without passing in values
    @Test
    void printPopulationCityTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printPopulationCity(cities);
    }

    //test to check that the print method below will run with add null values
    @Test
    void printPopulationCityTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printPopulationCity(cities);
    }

    //test to check the print method work with values that are stored in database
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

    //passing a null value into to printpopulationcaptital method
    @Test
    void printPopulationCapitalTestNull()
    {
        app.printPopulationCapital(null);
    }

    //test created to check if the print method below can be run without passing in values
    @Test
    void printPopulationCapitalTestEmpty()
    {
        ArrayList<City> capitals = new ArrayList<City>();
        app.printPopulationCapital(capitals);
    }

    //test to check that the print method below will run with add null values
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

    //passing a null value into to printpopulationcountry method
    @Test
    void printPopulationCountryTestNull()
    {
        app.printPopulationCountry(null);
    }

    //test created to check if the print method below can be run without passing in values
    @Test
    void printPopulationCountryTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printPopulationCountry(countries);
    }

    //test to check that the print method below will run with add null values
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

    //passing a null value into to printlanuagespeaker method
    @Test
    void printSpeakersTestNull()
    {
        app.printLanguageSpeakers(null);
    }

    //test created to check if the print method below can be run without passing in values
    @Test
    void printSpeakersTestEmpty()
    {
        ArrayList<Language> languages = new ArrayList<Language>();
        app.printLanguageSpeakers(languages);
    }

    //test to check that the print method below will run with add null values
    @Test
    void printSpeakersTestContainsNull()
    {
        ArrayList<Language> languages = new ArrayList<Language>();
        languages.add(null);
        app.printLanguageSpeakers(languages);
    }

    @Test
    void printSpeakers()
    {
        ArrayList<Language> languages = new ArrayList<Language>();
        Language language = new Language();
        language.language = "English";
        language.speakers = 347077867;
        language.percentage = 6;
        languages.add(language);
        app.printLanguageSpeakers(languages);
    }

    //passing a null value into to populations method
    @Test
    void printPopulationsTestNull()
    {
        app.printPopulations(null);
    }

    //test created to check if the print method below can be run without passing in values
    @Test
    void printPopulationsTestEmpty()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        app.printPopulations(populations);
    }

    //test to check that the print method below will run with add null values
    @Test
    void printPopulationsTestContainsNull()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        populations.add(null);
        app.printPopulations(populations);
    }

    @Test
    void printPopulations() {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population population = new Population();
        population.name = "AFRICA";
        population.inCity = 1234;
        population.outCity = 64;
        population.totalPop = 1245;
        populations.add(population);
        app.printPopulations(populations);
    }

    //passing a null value into to printpopulations1 method
    @Test
    void printPopulations1TestNull()
    {
        app.printPopulations1(null);
    }

    //test created to check if the print method below can be run without passing in values
    @Test
    void printPopulations1TestEmpty()
    {
        ArrayList<Population> populations1 = new ArrayList<Population>();
        app.printPopulations1(populations1);
    }

    //test to check that the print method below will run with add null values
    @Test
    void printPopulations1TestContainsNull()
    {
        ArrayList<Population> populations1 = new ArrayList<Population>();
        populations1.add(null);
        app.printPopulations1(populations1);
    }

    @Test
    void printPopulations1() {
        ArrayList<Population> populations1 = new ArrayList<Population>();
        Population population1 = new Population();
        population1.name = "AFRICA";
        population1.inCity = 1234;
        population1.outCity = 64;
        population1.totalPop = 1245;
        populations1.add(population1);
        app.printPopulations1(populations1);
    }
}

package com.napier.sem;

        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;

        import java.util.ArrayList;

        import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static ReportSQL sql;

    /**
     *
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        sql = new ReportSQL();
    }

    /**
     * Finds city Townsville checks actual output matches
     */
    @Test
    void testGetCity()
    {
        City city = app.getCity("Townsville");
        assertEquals(city.country, "AUS");
        assertEquals(city.district, "Queensland");
        assertEquals(city.population, 109914);
    }

    /**
     *Returns null if there is an error.
     */
    @Test
    void GetAllPopulationsCityTestNull()
    {
        ArrayList cities = app.getAllPopulationsCity(null);
        assertNull(cities);
    }

    /**
     * Returns list of all cities which match actual output
     */
    @Test
    void GetAllPopulationsCityTestCity1()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city1);
        assertEquals(cities.size(), 4079);
    }

    /**
     * Returns cities which match actual output in Europe.
     */
    @Test
    void GetAllPopulationsCityTestCity2()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city2("Europe"));
        assertEquals(cities.size(), 841);
    }
    /**
     * Returns null if there is an error.
     */
    @Test
    void GetAllPopulationsCityTestCity2Null()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city2(null));
        assertEquals(cities, null);
    }
    /**
     * Checks for population of non-existent city narnia. Returns null when fails.
     */
    @Test
    void GetAllPopulationsCityTestCity2Nonsense()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city2("Narnia"));
        assertEquals(cities, null);
    }
    /**
     * Checks all cities in region Western Europe matches actual output
     */
    @Test
    void GetAllPopulationsCityTestCity3()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city3("Western Europe"));
        assertEquals(cities.size(), 186);
    }
    /**
     * Checks all cities in country United Kingdom matches actual output
     */
    @Test
    void GetAllPopulationsCityTestCity4()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city4("United Kingdom"));
        assertEquals(cities.size(), 81);
    }
    /**
     * Checks all cities in district Scotland matches actual output
     */
    @Test
    void GetAllPopulationsCityTestCity5()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city5("Scotland"));
        assertEquals(cities.size(), 4);
    }
    /**
     * Checks for top N populated cities in descending order where N is provided by the user
     */
    @Test
    void GetAllPopulationsCityTestCity6()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city6(10));
        assertEquals(cities.size(), 10);
    }
    /**
     * Checks all cities in continent Europe matches actual output where N is provided by the user
     */
    @Test
    void GetAllPopulationsCityTestCity7()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city7("Europe", 10));
        assertEquals(cities.size(), 10);
    }
    /**
     * Returns top N populated cities in region Western Europe where N is provided by user
     */
    @Test
    void GetAllPopulationsCityTestCity8()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city8("Western Europe", 10));
        assertEquals(cities.size(), 10);
    }
    /**
     * Returns top N populated cities in country United Kingdom where N is provided by user
     */
    @Test
    void GetAllPopulationsCityTestCity9()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city9("United Kingdom", 10));
        assertEquals(cities.size(), 10);
    }
    /**
     * Returns top N populated cities in district Scotland where N is provided by user
     */
    @Test
    void GetAllPopulationsCityTestCity10()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city10("Scotland", 10));
        assertEquals(cities.size(), 4);
    }
    /**
     * Checks all capital cities in world in descending order of population matches actual output
     */
    @Test
    void GetAllPopulationsCityTestCapital1()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.capital1);
        assertEquals(cities.size(), 232);
    }
    /**
     * Checks all capital cities in Europe in descending order of population matches actual output
     */
    @Test
    void GetAllPopulationsCityTestCapital2()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.capital2("Europe"));
        assertEquals(cities.size(), 46);
    }
    /**
     * Checks all capital cities in Western Europe in descending order of population matches actual output
     */
    @Test
    void GetAllPopulationsCityTestCapital3()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.capital3("Western Europe"));
        assertEquals(cities.size(), 9);
    }
    /**
     * Checks top N capital cities in world in descending order of population where N is provided by user
     */
    @Test
    void GetAllPopulationsCityTestCapital4()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.capital4(10));
        assertEquals(cities.size(), 10);
    }
    /**
     * Checks top N capital cities in Europe in descending order of population where N is provided by user
     */
    @Test
    void GetAllPopulationsCityTestCapital5()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.capital5("Europe", 10));
        assertEquals(cities.size(), 10);
    }
    /**
     * Checks top N capital cities in Western Europe in descending order of population
     */
    @Test
    void GetAllPopulationsCityTestCapital6()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.capital6("Western Europe", 10));
        assertEquals(cities.size(), 9);
    }
    /**
     * Finds country Aruba checks actual output matches
     */
    @Test
    void testGetCountry()
    {
        Country country = app.getCountry("Aruba");
        assertEquals(country.country_Code, "ABW");
        assertEquals(country.region, "Caribbean");
        assertEquals(country.population, 103000);
    }
    /**
     *Returns null if there is an error.
     */
    @Test
    void GetAllPopulationsCountryTestNull()
    {
        ArrayList countries = app.getAllPopulationsCountry(null);
        assertEquals(countries, null);
    }
    /**
     *
     */
    @Test
    void GetAllPopulationsCountryTestCountry1()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.country1);
        assertEquals(countries.size(), 239);
    }
    /**
     *
     */
    @Test
    void GetAllPopulationsCountryTestCountry2()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.country2("Africa"));
        assertEquals(countries.size(), 58);
    }
    /**
     *
     */
    @Test
    void GetAllPopulationsCountryTestCountry3()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.country3("Caribbean"));
        assertEquals(countries.size(), 24);
    }
    /**
     *
     */
    @Test
    void GetAllPopulationsCountryTestCountry4()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.country4(9));
        assertEquals(countries.size(), 9);
    }
    /**
     *
     */
    @Test
    void GetAllPopulationsCountryTestCountry5()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.country5("Africa", 12));
        assertEquals(countries.size(), 12);
    }

    @Test
    void GetAllPopulationsCountryTestCountry6()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.country6("Caribbean", 10));
        assertEquals(countries.size(), 10);
    }

    @Test
    void GetAllPopulationsTest1()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population1("Africa"));
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest2()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population2("Caribbean"));
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest3()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population3("Aruba"));
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest4()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population4);
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest5()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population5("Europe"));
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest6()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population6("Caribbean"));
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest7()
    {
        ArrayList countries = app.getAllPopulationsCountry(sql.population7("UK"));
        assertEquals(countries.size(), 103000);
    }

    @Test
    void GetAllPopulationsTest8()
    {
        ArrayList cities = app.getAllPopulationsCountry(sql.population8("Scotland"));
        assertEquals(cities.size(), 146690);
    }

    @Test
    void GetAllPopulationsTest9()
    {
        ArrayList cities = app.getAllPopulationsCountry(sql.population9("Dundee"));
        assertEquals(cities.size(), 146690);
    }

    @Test
    void GetAllSpeakersTest()
    {
        ArrayList languages = app.getAllSpeakers();
        assertEquals(languages.size(), 5);
    }
}

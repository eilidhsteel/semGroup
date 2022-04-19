package com.napier.sem;

        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestInstance;

        import java.util.ArrayList;

        import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static ReportSQL sql;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        sql = new ReportSQL();
    }

    @Test
    void testGetCity()
    {
        City city = app.getCity("Townsville");
        assertEquals(city.country, "AUS");
        assertEquals(city.district, "Queensland");
        assertEquals(city.population, 109914);
    }

    @Test
    void GetAllPopulationsCityTestNull()
    {
        ArrayList cities = app.getAllPopulationsCity(null);
        assertEquals(cities, null);
    }

    @Test
    void GetAllPopulationsCityTest()
    {
        ArrayList cities = app.getAllPopulationsCity(sql.city1);
        assertEquals(cities.size(), 4079);
    }

    @Test
    void testGetCountry()
    {
        Country country = app.getCountry("Aruba");
        assertEquals(country.country_Code, "ABW");
        assertEquals(country.region, "Caribbean");
        assertEquals(country.population, 103000);
    }
}

package com.napier.sem;

        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestInstance;

        import java.util.ArrayList;

        import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetCity() {
        City city = app.getCity("Townsville");
        assertEquals(city.country, "AUS");
        assertEquals(city.district, "Queensland");
        assertEquals(city.population, 109914);
    }

    @Test
    void testGetCountry() {
        Country country = app.getCountry("Madagascar");
        assertEquals(country.continent, "Africa");
        assertEquals(country.region, "Eastern Africa");
        assertEquals(country.population, 15942000);
    }

}


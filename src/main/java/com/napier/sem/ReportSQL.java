package com.napier.sem;

/**
 * Contains SQL SELECT strings used for each report
 */
public class ReportSQL {
    /**
     * City 1: All the cities in the world organised by largest population to smallest.
     */
    public String city1 = "SELECT c.Name, c.District, c.Population, ct.Name AS country "
                                        + "FROM city AS c "
                                        + "LEFT JOIN country AS ct ON c.CountryCode = ct.Code "
                                        + "ORDER BY c.Population DESC";

    /**
     * City 2: All the cities in a continent organised by largest population to smallest.
     */
    public String city2(String continent){
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Continent = '" + continent + "' "
                + "ORDER BY c.Population DESC";
    }
}

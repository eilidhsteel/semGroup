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
    /**
     * City 3: All the cities in a region organised by largest population to smallest.
     */
    public String city3(String region){
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Region = '" + region + "' "
                + "ORDER BY c.Population DESC";
    }
    /**
     * City 4: All the cities in a country organised by largest population to smallest.
     */
    public String city4(String country){
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Name = '" + country + "' "
                + "ORDER BY c.Population DESC";
    }
    /**
     * City 5: All the cities in a district organised by largest population to smallest.
     */
    public String city5(String district){
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE c.District = '" + district + "' "
                + "ORDER BY c.Population DESC";
    }
    /**
     * City 6: The top N populated cities in the world where N is provided by the user.
     */
    public String city6(Integer n){
        return "SELECT c.Name, c.District, c.Population, ct.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country AS ct ON c.CountryCode = ct.Code "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }
}

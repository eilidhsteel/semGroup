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
    public String city2(String continent) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Continent = '" + continent + "' "
                + "ORDER BY c.Population DESC";
    }

    /**
     * City 3: All the cities in a region organised by largest population to smallest.
     */
    public String city3(String region) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Region = '" + region + "' "
                + "ORDER BY c.Population DESC";
    }

    /**
     * City 4: All the cities in a country organised by largest population to smallest.
     */
    public String city4(String country) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Name = '" + country + "' "
                + "ORDER BY c.Population DESC";
    }

    /**
     * City 5: All the cities in a district organised by largest population to smallest.
     */
    public String city5(String district) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE c.District = '" + district + "' "
                + "ORDER BY c.Population DESC";
    }

    /**
     * City 6: The top N populated cities in the world where N is provided by the user.
     */
    public String city6(Integer n) {
        return "SELECT c.Name, c.District, c.Population, ct.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country AS ct ON c.CountryCode = ct.Code "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * City 7: The top N populated cities in a continent where N is provided by the user.
     */
    public String city7(String continent, Integer n) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Continent = '" + continent + "' "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * City 8: The top N populated cities in a region where N is provided by the user.
     */
    public String city8(String region, Integer n) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Region = '" + region + "' "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * City 9: The top N populated cities in a country where N is provided by the user.
     */
    public String city9(String country, Integer n) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Name = '" + country + "' "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * City 10: The top N populated cities in a district where N is provided by the user.
     */
    public String city10(String district, Integer n) {
        return "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE c.District = '" + district + "' "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * Capital 1: All the capital cities in the world organised by largest population to smallest.
     */
    public String capital1 = "SELECT city.Name, city.District, city.Population, country.Name AS country "
            + "FROM country "
            + "INNER JOIN city ON country.Capital = city.ID "
            + "ORDER BY city.Population DESC";

    /**
     * Capital 2: All the capital cities in a continent organised by largest population to smallest.
     */
    public String capital2(String continent) {
        return "SELECT city.Name, city.District, city.Population, country.Name AS country "
                + "FROM country "
                + "INNER JOIN city ON country.Capital = city.ID "
                + "WHERE country.Continent = '" + continent + "' "
                + "ORDER BY city.Population DESC";
    }

    /**
     * Capital 3: All the capital cities in a region organised by largest to smallest.
     */
    public String capital3(String region) {
        return "SELECT city.Name, city.District, city.Population, country.Name AS country "
                + "FROM country "
                + "INNER JOIN city ON country.Capital = city.ID "
                + "WHERE country.Region = '" + region + "' "
                + "ORDER BY city.Population DESC";
    }

    /**
     * Capital 4: The top N populated capital cities in the world where N is provided by the user.
     */
    public String capital4(Integer n) {
        return "SELECT city.Name, city.District, city.Population, country.Name AS country "
                + "FROM country "
                + "INNER JOIN city ON country.Capital = city.ID "
                + "ORDER BY city.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * Capital 5: The top N populated capital cities in a continent where N is provided by the user.
     */
    public String capital5(String continent, Integer n) {
        return "SELECT city.Name, city.District, city.Population, country.Name AS country "
                + "FROM country "
                + "INNER JOIN city ON country.Capital = city.ID "
                + "WHERE country.Continent = '" + continent + "' "
                + "ORDER BY city.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * Capital 6: The top N populated capital cities in a region where N is provided by the user.
     */
    public String capital6(String region, Integer n) {
        return "SELECT city.Name, city.District, city.Population, country.Name AS country "
                + "FROM country "
                + "INNER JOIN city ON country.Capital = city.ID "
                + "WHERE country.Region = '" + region + "' "
                + "ORDER BY city.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * Country 17: All the countries in the world organised by largest population to smallest.
     */
    public String country17(Integer n) {
        return "SELECT country.code country.Name, country.District, country.Population"
                + "FROM country "
                + "ORDER BY country.Population DESC ";

    }

    /**
     * Country 19: All the countries in a region organised by largest population to smallest.
     */
    public String country19(String region) {
        return "SELECT country.code country.Name, country.District, country.Population"
                + "FROM country "
                + "WHERE country.region = '" + region + "' "
                + "ORDER BY country.Population DESC ";
    }
    /**
     * Country 21: The top N populated countries in a continent where N is provided by the user.
     */
    public String country21(String continent, Integer n){
        return "SELECT c.Code, c.Continent, c.Region, c.Capital, c.Population, country.Name AS country "
                + "FROM country "
                + "WHERE country.continent = '" + continent+ "' "
                + "ORDER BY country.Population DESC "
                + "LIMIT " + n;
    }
    /**
     * Population 24: The population of people, people living in cities, and people not living in cities in each region.
     */

    public String population24(String region, Integer n){
        return "SELECT co.Region AS Region, SUM(co.Population) AS Total_Pop, "
                + "SUM(ci.Population) AS InCity, "
                + "SUM(co.Population)  - SUM(ci.Population) AS OutCity "
                + "FROM country co "
                + "WHERE country.Region = '" + region + "' "
                + "JOIN (SELECT "
                + "ci.CountryCode "
                + ",SUM(ci.population) AS Population "
                + "FROM Region ci GROUP BY 1) ci ON ci.CountryCode = co.code "
                + "GROUP BY Region";
    }

    /**
     * Population 28: The population of a region.
     */
    public String population28(String region){
        return "SELECT region, SUM(population) AS Population "
                + "FROM country c "
                + "WHERE country.region = '" + region + "' "
                + "GROUP BY 1 "
                + "ORDER BY Population DESC";
    }

    /**
     * Population 29: The population of a country in order.
     */
    public String population29(String country){
        return "SELECT name, SUM(population) AS Population "
                + "FROM country c "
                + "WHERE country.Country = '" + country + "' "
                + "GROUP BY 1 "
                + "ORDER BY Population DESC";
    }
    /**
     * Population 30: The population of a district.
     */
    public String population30(String district){
        return "SELECT district, SUM(population) AS Population "
                + "FROM country c "
                + "WHERE city.district = '" + district + "' "
                + "GROUP BY 1 "
                + "ORDER BY Population DESC";
    }
}

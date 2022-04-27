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
            + "ORDER BY c.Population DESC ";

    /**
     * City 2: All the cities in a continent organised by largest population to smallest.
     */
    public String city2(String continent) {
        return  "SELECT c.Name, c.District, c.Population, country.Name AS country "
                + "FROM city AS c "
                + "LEFT JOIN country ON c.CountryCode = country.Code "
                + "WHERE country.Continent = '" + continent + "' "
                + "ORDER BY c.Population DESC ";
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
     * Country 1: All the countries in the world organised by largest population to smallest.
     */
    public String country1 = "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, c.Capital "
                + "FROM country AS c "
                + "ORDER BY c.Population DESC ";


    /**
    * Country 2: All the countries in a continent organised by largest population to smallest.
            */
    public String country2(String continent){
        return "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, c.Capital "
                + "FROM country AS c "
                + "WHERE c.Continent = '" + continent + "' "
                + "ORDER BY c.Population DESC ";
    }

    /**
     * Country 3: All the countries in a region organised by largest population to smallest.
     */
    public String country3(String region) {
        return "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, c.Capital "
                + "FROM country AS c "
                + "WHERE c.region = '" + region + "' "
                + "ORDER BY c.Population DESC ";
    }
    /**
     * Country 4: The top N populated countries in the world where N is provided by the user.
     */
    public String country4(Integer n){
        return "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, c.Capital "
                + "FROM country AS c "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * Country 5: The top N populated countries in a continent where N is provided by the user.
     */
    public String country5(String continent, Integer n){
        return "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, c.Capital "
                + "FROM country AS c "
                + "WHERE c.continent = '" + continent+ "' "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }
    /**
     * Country 6: The top N populated countries in a region where N is provided by the user.
     */
    public String country6(String region, Integer n){
        return "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, c.Capital "
                + "FROM country AS c "
                + "WHERE c.Region = '" + region + "' "
                + "ORDER BY c.Population DESC "
                + "LIMIT " + n;
    }

    /**
     * Population 1: The population of people, people living in cities, and people not living in cities in each continent.
     */
    public String population1(String continent){
        return "SELECT ct.Continent AS Name, SUM(ct.Population) AS Total_Pop, SUM(c.Population) AS InCity, SUM(ct.Population)  - SUM(c.Population) AS OutCity, ROUND((SUM(c.population)/(SELECT SUM(population) FROM country)*100), 2) AS percentageIn, ROUND(((SUM(ct.Population)  - SUM(c.Population))/(SELECT SUM(ct.population) FROM country AS ct)*100), 2) AS percentageOut  "
                + "FROM country ct "
                + "JOIN(SELECT c.CountryCode,SUM(c.population) AS Population "
                + "FROM city AS c GROUP BY 1) c ON ct.Code = c.CountryCode "
                + "WHERE ct.Continent = '" + continent + "' "
                + "GROUP BY ct.Continent";
    }

    /**
     * Population 2: The population of people, people living in cities, and people not living in cities in each region.
     */

    public String population2(String region){
        return "SELECT ct.Region AS Name, SUM(ct.Population) AS Total_Pop, SUM(c.Population) AS InCity, SUM(ct.Population)  - SUM(c.Population) AS OutCity, ROUND((SUM(c.population)/(SELECT SUM(population) FROM country)*100), 2) AS percentageIn, ROUND(((SUM(ct.Population)  - SUM(c.Population))/(SELECT SUM(ct.population) FROM country AS ct)*100), 2) AS percentageOut "
                + "FROM country ct "
                + "JOIN(SELECT c.CountryCode,SUM(c.population) AS Population "
                + "FROM city AS c GROUP BY 1) c ON ct.Code = c.CountryCode "
                + "WHERE ct.Region = '" + region + "' "
                + "GROUP BY ct.Region";
    }
    /**
     * Population 3: The population of people, people living in cities, and people not living in cities in each country.
     */
    public String population3(String country){
        return "SELECT ct.Name AS Name, SUM(ct.Population) AS Total_Pop, SUM(c.Population) AS InCity, SUM(ct.Population)  - SUM(c.Population) AS OutCity, ROUND((SUM(c.population)/(SELECT SUM(population) FROM country)*100), 2) AS percentageIn, ROUND(((SUM(ct.Population)  - SUM(c.Population))/(SELECT SUM(ct.population) FROM country AS ct)*100), 2) AS percentageOut "
                + "FROM country ct "
                + "JOIN(SELECT c.CountryCode,SUM(c.population) AS Population "
                + "FROM city AS c GROUP BY 1) c ON ct.Code = c.CountryCode "
                + "WHERE ct.Name = '" + country + "' "
                + "GROUP BY ct.Name";
    }

    /**
     * Population 4: The population of the world.
     */
    public String population4 =  "SELECT 'World' AS Name, SUM(population) AS Total_Pop "
            + "FROM country ";

    /**
     * Population 5: The population of a continent.
     */
    public String population5(String continent){
        return "SELECT continent AS Name, SUM(population) AS Total_Pop "
                + "FROM country "
                + "WHERE continent = '" + continent + "' ";
    }

    /**
     * Population 6: The population of a region.
     */
    public String population6(String region){
        return "SELECT region AS Name, SUM(population) AS Total_Pop "
                + "FROM country c "
                + "WHERE c.region = '" + region + "' ";
    }

    /**
     * Population 7: The population of a country.
     */
    public String population7(String country){
        return "SELECT Name, SUM(population) AS Total_Pop "
                + "FROM country c "
                + "WHERE c.Name = '" + country + "' ";
    }
    /**
     * Population 8: The population of a district.
     */
    public String population8(String district){
        return "SELECT district AS Name, SUM(ci.population) AS Total_Pop "
                + "FROM country c "
                + "LEFT JOIN city AS ci ON ci.CountryCode = c.Code "
                + "WHERE ci.district = '" + district + "' ";
    }
    /**
      * Population 9: The population of a city.
     */
    public String population9(String city){
        return "SELECT ci.Name, SUM(ci.population) AS Total_Pop "
                + "FROM country c "
                + "LEFT JOIN city AS ci ON ci.CountryCode = c.Code "
                + "WHERE ci.Name = '" + city + "' ";
    }

}

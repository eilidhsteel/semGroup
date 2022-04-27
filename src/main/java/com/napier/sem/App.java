package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        // Create queries used for reporting
        ReportSQL sql = new ReportSQL();

        // Connect to world database
        if (args.length < 1) {
            a.connect("localhost:33060", 30000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Print all city reports to the console
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city1)); // City Report 1 - requirement 7
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city2("Europe"))); // City Report 2 - requirement 8
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city3("Western Europe"))); // City Report 3 - requirement 9
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city4("United Kingdom"))); // City Report 4 - requirement 10
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city5("Scotland"))); // City Report 5 - requirement 11
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city6(10))); // City Report 6 - requirement 12
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city7("Europe", 10))); // City Report 7 - requirement 13
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city8("Western Europe", 10))); // City Report 8 - requirement 14
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city9("United Kingdom", 10))); // City Report 9 - requirement 15
        //a.printPopulationCity(a.getAllPopulationsCity(sql.city10("Scotland", 10))); // City Report 10 - requirement 16

        // Print all capital city reports to the console
        //a.printPopulationCapital(a.getAllPopulationsCity(sql.capital1)); //Capital report 1 - requirement 17
        //a.printPopulationCapital(a.getAllPopulationsCity(sql.capital2("Europe"))); // Capital report 2 - requirement 18
        //a.printPopulationCapital(a.getAllPopulationsCity(sql.capital3("Western Europe"))); // Capital report 3 - requirement 19
        //a.printPopulationCapital(a.getAllPopulationsCity(sql.capital4(5))); // Capital report 4 - requirement 20
        //a.printPopulationCapital(a.getAllPopulationsCity(sql.capital5("Europe", 5))); // Capital report 5 - requirement 21
        //a.printPopulationCapital(a.getAllPopulationsCity(sql.capital6("Western Europe", 5))); // Capital report 6 - requirement 22

        //Print all country reports to the console
        //a.printPopulationCountry(a.getAllPopulationsCountry(sql.country1)); //Country report 1 - requirement 1
        //a.printPopulationCountry(a.getAllPopulationsCountry(sql.country2("Africa"))); //Country report 2 - requirement
        //a.printPopulationCountry(a.getAllPopulationsCountry(sql.country3("Caribbean"))); //Country report 3 - requirement 3
        // a.printPopulationCountry(a.getAllPopulationsCountry(sql.country4(10))); //Country report 4 - requirement 4
        //a.printPopulationCountry(a.getAllPopulationsCountry(sql.country5("Europe", 7))); //Country report 5 - requirement 5
        //a.printPopulationCountry(a.getAllPopulationsCountry(sql.country6("Southern Europe", 15))); //Country report 6 - requirement 6

        //Print Language report to console- requirement 32
        //a.printLanguageSpeakers(a.getAllSpeakers());


        //Print all population reports to the console
        //a.printPopulations(a.getAllPopulations(sql.population1("Europe"))); //Population report 1 - requirement 23
        //a.printPopulations(a.getAllPopulations(sql.population2("Western Europe"))); //Population report 4 - requirement 24
       //a.printPopulations(a.getAllPopulations(sql.population3("United Kingdom"))); //Population report 3 - requirement 25
        //a.printPopulations1(a.getAllPopulations1(sql.population4)); //Population report 4 - requirement 26
        //a.printPopulations1(a.getAllPopulations1(sql.population5("Europe"))); //Population report 5 - requirement 27
        //a.printPopulations1(a.getAllPopulations1(sql.population6("Western Europe"))); //Population report 5 - requirement 28
        //a.printPopulations1(a.getAllPopulations1(sql.population7("United Kingdom"))); // Population report 6 - requirement 29
        //a.printPopulations1(a.getAllPopulations1(sql.population8("Scotland"))); //Population report 7 - requirement 30
        // a.printPopulations1(a.getAllPopulations1(sql.population9("Dundee"))); //Population report 8 - requirement 31


        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL world database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Disconnect from the MySQL world database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public City getCity(String name) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT c.Name, c.CountryCode, c.District, c.Population "
                            + "FROM city AS c "
                            + "WHERE c.Name = '" + name + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                City city = new City();
                city.city_name = rset.getString("Name");
                city.country = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                return city;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Prints the details of a city object to the console.
     */
    public void displayCity(City city) {
        if (city != null) {
            System.out.println(
                    city.city_name + " "
                            + city.country + " "
                            + city.district + "\n"
                            + "Population: " + city.population + "\n");
        }
    }

    /**
     * Gets all the current cities and populations.
     *
     * @return A list of all cities and populations based on SQL query provided for chosen report, or null if there is an error.
     */
    public ArrayList<City> getAllPopulationsCity(String strSelect) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.city_name = rset.getString("Name");
                city.country = rset.getString("country");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            if (cities.isEmpty()) {
                return null;
            } else {
                return cities;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of cities.
     *
     * @param cities The list of cities to print.
     */
    public void printPopulationCity(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null) {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-20s %-25s %-10s", "City Name", "Country", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities) {
            if (city == null)
                continue;
            String city_string =
                    String.format("%-20s %-20s %-25s %-10s",
                            city.city_name, city.country, city.district, city.population);
            System.out.println(city_string);
        }
        System.out.println();
    }

    /**
     * Prints a list of capital cities.
     *
     * @param capitals The list of capital cities to print.
     */
    public void printPopulationCapital(ArrayList<City> capitals) {
        // Check cities is not null
        if (capitals == null) {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-20s %-10s", "City Name", "Country", "Population"));
        // Loop over all capitals in the list
        for (City city : capitals) {
            if (city == null)
                continue;
            String city_string =
                    String.format("%-20s %-20s %-10s",
                            city.city_name, city.country, city.population);
            System.out.println(city_string);
        }
        System.out.println();
    }

    public Country getCountry(String name) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT c.Code, c.Name, c.Continent, c.Region, c.SurfaceArea, c.IndepYear, c.Population,c.LifeExpectancy, c.GNP, c.GNPOld, c.LocalName, c.GovernmentForm, c.HeadOfState, c.Capital, c.Code2 "
                            + "FROM country AS c "
                            + "WHERE c.Name = '" + name + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                Country country = new Country();
                country.country_name = rset.getString("Name");
                country.country_Code = rset.getString("Code");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.surface_area = rset.getInt("SurfaceArea");
                country.indep_Year = rset.getInt("IndepYear");
                country.population = rset.getInt("Population");
                country.life_Expectancy = rset.getInt("LifeExpectancy");
                country.GNP = rset.getInt("GNP");
                country.GNP_old = rset.getInt("GNPOld");
                country.local_Name = rset.getString("LocalName");
                country.government_form = rset.getString("GovernmentForm");
                country.head_of_state = rset.getString("HeadOfState");
                country.capital = rset.getInt("Capital");
                country.country_code2 = rset.getString("Code2");
                return country;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(Country country) {
        if (country != null) {
            System.out.println(
                    country.country_name + " "
                            + country.continent + " "
                            + country.region + "\n"
                            + "Population: " + country.population + "\n");
        }
    }

    /**
     * Gets all the current countries and populations.
     *
     * @return A list of all countries and populations, or null if there is an error.

     */
    public ArrayList<Country> getAllPopulationsCountry(String strSelect) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.country_Code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getInt("Capital");
                countries.add(country);
            }
            if (countries.isEmpty()) {
                return null;
            } else {
                return countries;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of countries.
     *
     * @param countries The list of countries to print.
     */
    public void printPopulationCountry(ArrayList<Country> countries) {
        // Check cities is not null
        if (countries == null) {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-45s %-30s %-30s %-30s %-20s","Code", "Country Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all cities in the list
        for (Country country : countries) {
            if (country == null)
                continue;
            String country_string =
                    String.format("%-20s %-45s %-30s %-30s %-30s %-20s",
                            country.country_Code, country.country_name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_string);
        }
    }

    /**
     * Gets all langauges and the number of speakers that speak them.
     *
     * @return A list of all languages and the population that speak them, or null if there is an error.
     */
    public ArrayList<Language> getAllSpeakers() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Language, SUM(Speakers) as Speakers, ROUND((SUM(Speakers)/(SELECT SUM(population) FROM country)*100), 2) AS Percentage "
                            + "FROM "
                            + "(SELECT countrylanguage.language AS Language, (country.population * countrylanguage.percentage /100) as Speakers "
                            + "FROM countrylanguage "
                            + "LEFT JOIN country "
                            + "ON countrylanguage.countrycode = country.code "
                            + ") AS a "
                            + "GROUP BY Language "
                            + "ORDER BY Speakers DESC "
                            + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Language> languages = new ArrayList<Language>();
            while (rset.next()) {
                Language language = new Language();
                language.language = rset.getString("Language");
                language.speakers = rset.getInt("Speakers");
                language.percentage = rset.getFloat("Percentage");
                languages.add(language);
            }
            return languages;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of cities.
     *
     * @param languages The list of cities to print.
     */
    public void printLanguageSpeakers(ArrayList<Language> languages) {
        // Check languages is not null
        if (languages == null) {
            System.out.println("No languages");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-20s %-20s", "Language", "Speakers", "Percentage of World Population"));
        // Loop over all cities in the list
        for (Language language : languages) {
            if (language == null)
                continue;
            String language_string =
                    String.format("%-20s %-20s %-20s",
                            language.language, language.speakers, language.percentage);
            System.out.println(language_string);
        }
    }

    /**
     * Gets all the current countries and populations.
     *
     * @return A list of all countries and populations, or null if there is an error.

     */
    public ArrayList<Population> getAllPopulations(String strSelect) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Population> populations = new ArrayList<Population>();
            while (rset.next()) {
                Population population = new Population();
                population.name = rset.getString("Name");
                population.inCity = rset.getInt("InCity");
                population.outCity = rset.getInt("OutCity");
                population.totalPop = rset.getDouble("Total_Pop");
                populations.add(population);
            }
            if (populations.isEmpty()) {
                return null;
            } else {
                return populations;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of cities.
     *
     * @param populations The list of cities to print.
     */
    public void printPopulations(ArrayList<Population> populations) {
        // Check languages is not null
        if (populations == null) {
            System.out.println("No languages");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-45s %-45s %-20s ", "Name", "Total Population in cities", "Total Population not in cities", "Total Population"));
        // Loop over all cities in the list
        for (Population population : populations) {
            if (population == null)
                continue;
            String population_string =
                    String.format("%-20s %-45s %-45s %-20s ",
                            population.name, population.inCity, population.outCity, population.totalPop);
            System.out.println(population_string);
        }
    }

    /**
     * Prints a list of cities.
     *
     * @param populations The list of cities to print.
     */
    public void printPopulations1(ArrayList<Population> populations) {
        // Check languages is not null
        if (populations == null) {
            System.out.println("No languages");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-20s", "Name", "Total Population"));
        // Loop over all cities in the list
        for (Population population : populations) {
            if (population == null)
                continue;
            String population_string =
                    String.format("%-20s %-20s",
                            population.name, population.totalPop);
            System.out.println(population_string);
        }
    }

    public ArrayList<Population> getAllPopulations1(String strSelect) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Population> populations = new ArrayList<Population>();
            while (rset.next()) {
                Population population = new Population();
                population.name = rset.getString("Name");
                population.totalPop = rset.getDouble("Total_Pop");
                populations.add(population);
            }
            if (populations.isEmpty()) {
                return null;
            } else {
                return populations;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

}




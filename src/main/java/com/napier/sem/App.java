package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        ReportSQL sql = new ReportSQL();

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        ArrayList<City> test_cities = a.getAllPopulationsCity(sql.city10("England", 10));
        a.printPopulation(test_cities);

        //ArrayList<Country> test_countries = a.getAllPopulationsCountry();
        //a.printPopulationCountry(test_countries);

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
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
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

    public City getCity(String name)
    {
        try
        {
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
            if (rset.next())
            {
                City city = new City();
                city.city_name = rset.getString("Name");
                city.country = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.city_name + " "
                            + city.country + " "
                            + city.district + "\n"
                            + "Population: " + city.population + "\n");
        }
    }

    /**
     * Gets all the current cities and populations.
     * @return A list of all cities and populations based on SQL query provided for chosen report, or null if there is an error.
     */
    public ArrayList<City> getAllPopulationsCity(String strSelect)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.city_name = rset.getString("Name");
                city.country = rset.getString("country");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */
    public void printPopulation(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-20s %-25s %-10s", "City Name", "Country", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities)
        {
            if (city == null)
                continue;
            String city_string =
                    String.format("%-20s %-20s %-25s %-10s",
                            city.city_name, city.country, city.district, city.population);
            System.out.println(city_string);
        }
    }

    public Country getCountry(String name)
    {
        try
        {
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
            if (rset.next())
            {
                Country country = new Country();
                country.country_name = rset.getString("Name");
                country.country_Code = rset.getString("Code");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.surface_area = rset.getInt("SurfaceArea");
                country.indep_Year = rset.getInt("IndepYear");
                country.population = rset.getInt("Population");
                country.life_Expectancy= rset.getInt("LifeExpectancy");
                country.GNP = rset.getInt("GNP");
                country.GNP_old = rset.getInt("GNPOld");
                country.local_Name = rset.getString("LocalName");
                country.government_form = rset.getString("GovernmentForm");
                country.head_of_state = rset.getString("HeadOfState");
                country.capital = rset.getString("Capital");
                country.country_code2 = rset.getString("Code2");
                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(Country country)
    {
        if (country != null)
        {
            System.out.println(
                    country.country_name + " "
                            + country.continent + " "
                            + country.region + "\n"
                            + "Population: " + country.population + "\n");
        }
    }

    /**
     * Gets all the current countries and populations.
     * @return A list of all countries and populations, or null if there is an error.
     */
    public ArrayList<Country> getAllPopulationsCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT c.Name, c.continent, c.region, c.Population, c.Code "
                            + "FROM country AS c "
                            + "ORDER BY c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.country_name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of cities.
     * @param countries The list of cities to print.
     */
    public void printPopulationCountry(ArrayList<Country> countries)
    {
        // Check cities is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-20s %-25s %-10s", "City Name", "Country", "District", "Population"));
        // Loop over all cities in the list
        for (Country country : countries)
        {
            if (country == null)
                continue;
            String country_string =
                    String.format("%-20s %-20s %-25s %-10s",
                            country.country_name, country.continent, country.region, country.population);
            System.out.println(country_string);
        }
    }


}

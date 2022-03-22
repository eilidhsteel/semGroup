package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        ArrayList<City> test_cities = a.getAllPopulations();
        a.printPopulation(test_cities);

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
     * @return A list of all cities and populations, or null if there is an error.
     */
    public ArrayList<City> getAllPopulations()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT c.Name, c.District, c.Population, ct.Name AS country "
                            + "FROM city AS c "
                            + "LEFT JOIN country AS ct ON c.CountryCode = ct.Code "
                            + "ORDER BY c.Population DESC";
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
            public ArrayList<CountryLanguage> Language () ArrayList<CountryLanguage> language;
            {

                try {
                    {
                        //create sql statement
                        Statement stmt = con.createStatement();
                        //create string for SQL statement
                        String strSelect =
                                "SELECT countrylanguage.CountryLanguage, SUM(country.Population * countrylanguage.Percentage / 100) AS speakers, " +
                                        "SUM(country.Population * countrylanguage.Percentage / 100) / " +
                                        "(SELECT sum(Population)FROM country) * 100 AS percentage_speakers " +
                                        " FROM country " +
                                        " JOIN countrylanguage ON countrylanguage.CountryCode = country.Code " +
                                        " WHERE countrylanguage.CountryLanguage IN ('Arabic', 'Chinese', 'English', 'Hindi', 'Spanish')" +
                                        " GROUP BY countrylanguage.CountryLanguage" +
                                        " ORDER BY speakers DESC;";

                        // Execute SQL statement
                        ResultSet rset = stmt.executeQuery(strSelect);
                        // Extract employee information
                        language = new ArrayList<>(CountryLanguage);
                        while (rset.next()) {
                            CountryLanguage cnt = new CountryLanguage();
                            cnt.setCountryLanguage(rset.getString("countryLanguage.CountryLanguage"));
                            cnt.setPopulation(rset.getLong("speakers"));
                            cnt.setPercentage(rset.getFloat("percentage_speakers"));
                            language.add(cnt);
                        }
                        return language;

                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to find language");
                    return null;
                }
            }

            public void printLan(ArrayList < CountryLanguage > language);
            {
                // Check language is not null
                if (language == null) {
                    System.out.println("Languages null");
                    return;
                }

                // Print header
                System.out.println(String.format("%-20s %-20s %-20s", "language", "Population", "Percentage"));
                // Loop over all languages in the list
                for (CountryLanguage cnt : language) {
                    if (cnt == null)
                        continue;

                    String cnt_string =
                            String.format("%-20s %-20s %-25s %-10s",
                                    cnt.getLanguage(), cnt.getPopulation(), cnt.getPercentage());
                    System.out.println(cnt_string);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }}

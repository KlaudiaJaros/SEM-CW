package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * DatabaseConnector Singleton class - connects to a MySQL database and retrieves all data from it.
 */
public class DatabaseConnector {

    // to store the connection:
    private static Connection connection = null;

    // to store the only instance of this class:
    private static DatabaseConnector databaseConnector;

    // to store all data retrieved from the database:
    public static HashMap<String, Country> countries;
    public static HashMap<Integer, City> cities;
    public static HashMap<String, Language> languages;

    private DatabaseConnector(){ }

    public static DatabaseConnector getDatabaseConnector(){
        if (databaseConnector==null){
            databaseConnector=new DatabaseConnector();
        }
        return databaseConnector;
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver:
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the mySQL database
     */
    public void disconnect(){
        if (connection != null)
        {
            try
            {
                // Close connection
                connection.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     *  Loads all data from the database and stores it in the static ArrayLists.
     */
    public void loadData(){
        countries=new HashMap<>();
        countries=loadAllCountries();

        cities=new HashMap<>();
        cities=loadAllCities();

        languages=new HashMap<>();
        languages=loadAllLanguages();
    }

    /**
     * Returns an HashMap of all the cities from the World database.
     * @return HashMap of type City or null if unsuccessful
     */
    private HashMap<Integer, City> loadAllCities()
    {
        try{
            // create a statement and a SQL query string:
            Statement statement = connection.createStatement();
            String query = "SELECT ID, Name, CountryCode, District, Population FROM city";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // ArrayList to save results:
            HashMap<Integer, City> cities = new HashMap<>();

            // while the result has another line:
            while (result.next()){
                City city = new City();
                city.setId(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setPopulation(result.getInt("Population"));
                cities.put(city.getId(), city);
            }
            return cities;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to load cities.");
            return null;
        }
    }

    /**
     * Returns an HashMap of all the cities from the World database.
     * @return HashMap of type Country or null if unsuccessful
     */
    private HashMap<String, Country> loadAllCountries()
    {
        try{
            // create a statement and a SQL query string:
            Statement statement = connection.createStatement();
            String query = "SELECT Code, Name, Continent, Region, SurfaceArea, Population, Capital FROM country";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // ArrayList to save results:
            HashMap<String, Country> countries = new HashMap<>();

            // while the result has another line:
            while (result.next()){
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getInt("SurfaceArea"));
                country.setPopulation(result.getInt("Population"));
                country.setCapital(result.getString("Capital"));
                countries.put(country.getCode(), country);
            }
            return countries;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to load countries.");
            return null;
        }
    }

    /**
     * Returns an HashMap of all the languages from the World database.
     * @return HashMap of type Language or null if unsuccessful
     */
    private HashMap<String, Language> loadAllLanguages()
    {
        try{
            // create a statement and a SQL query string:
            Statement statement = connection.createStatement();
            String query = "SELECT CountryCode, Language, IsOfficial, Percentage FROM countrylanguage";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // ArrayList to save results:
            HashMap<String, Language> languages = new HashMap<>();

            // while the result has another line:
            while (result.next()){
                Language language = new Language();
                language.setCountryCode(result.getString("CountryCode"));
                language.setName(result.getString("Language"));
                language.setPercentage(result.getInt("Percentage"));

                // IsOfficial is a single character enum:
                char c = result.getString("IsOfficial").charAt(0);
                if (c=='T'){ // T for true
                    language.setOfficial(true);
                }
                else{ // F for false
                    language.setOfficial(false);
                }
                languages.put(language.getCountryCode()+language.getName(), language);
            }
            return languages;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to load languages.");
            return null;
        }
    }

    /**
     * Gets and prints a city by its ID
     * @param ID id of the city to print
     */
    public void getCity(int ID)
    {
        City city = cities.get(ID);
        System.out.println(city.toString());
    }

    /***
     * Gets all countries sorted by population descending. Runs an SQL query and returns ids.
     * The countries are then picked from the previously loaded HashMap by their id into an ArrayList and returned.
     * @return an ArrayList of sorted countries
     */
    public ArrayList<Country> getAllCountriesByPopulation() {
        try {
            // to store and return results:
            ArrayList<Country> results = new ArrayList<>();

            // create a statement and a SQL query string:
            Statement statement = connection.createStatement();
            String query = "SELECT Code, Name, Continent, Region, Population, Capital FROM country " +
                    "ORDER BY Population DESC";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // while the result has another line:
            while (result.next()) {
                String code = result.getString("Code");
                results.add(countries.get(code)); // get the country by its id and add to the list
            }
            return results; // added in order according to the query results
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load countries.");
            return null;
        }
    }
}

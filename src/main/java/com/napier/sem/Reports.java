package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * A class that stores all the methods for generating reports from the SQL database
 */
public class Reports {


    /***
     * Gets all countries sorted by population descending. Runs an SQL query and returns ids.
     * The countries are then picked from the previously loaded HashMap by their id into an ArrayList and returned.
     * @param continent continent filter
     * @param region region filter
     * @param n top N countries filter
     * @return an ArrayList of sorted countries
     */

    public ArrayList<Entry> getCountriesByPopulation(String continent, String region, int n) {
        try {
            // to store and return results:
            ArrayList<Entry> results = new ArrayList<>();

            // create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            // to store the where clause if continent or region string not null:
            String whereClause= "";

            //to store the limit clause if n is provided:
            String limitClause = "";

            // world population report if both parameters are null:
            if (continent==null && region==null){
                whereClause="";
            }
            // continent population report:
            else if (continent!=null && region==null){
                whereClause="WHERE continent='" + continent + "' ";
            }
            // region population report:
            else if(region!=null && continent==null){
                whereClause="WHERE region='" + region + "' ";
            }

            //if everything else is invalid
            else {
                return null;
            }

            if (n!=0){
                limitClause = "LIMIT " + n;
            }

            String query = "SELECT Code FROM country " +
                    whereClause +
                    "ORDER BY Population DESC "
                    + limitClause;

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // while the result has another line:
            while (result.next()) {
                String code = result.getString("Code");
                results.add(DatabaseConnector.countries.get(code)); // get the country by its id and add to the list
            }
            return results; // added in order according to the query results
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load countries.");
            return null;
        }
    }

    /**
     * Gets all cities sorted by population descending. Runs an SQL query and returns ids.
     * The countries are then picked from the previously loaded HashMap by their id into an ArrayList and returned.
     * @param continent continent filter
     * @param region region filter
     * @param district district filter
     * @param country country filter
     * @param n top N cities filter
     * @return an array list of sorted cities
     */
    public ArrayList<Entry> getCitiesByPopulation(String continent, String region, String district, String country, int n) {
        try {
            ArrayList<Entry> results = new ArrayList<>();

            //create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            // to store where clause to filter results if required
            String whereClause = "";

            // to store limit clause if N is provided by user
            String limitClause = "";

            // if getting ALL cities
            if (continent == null && region == null && district == null && country == null) {
                whereClause = "";
            }

            // if getting cities in CONTINENT only
            else if (continent != null && region == null && district == null && country == null) {
                whereClause = "JOIN country ON (country.Code = city.CountryCode) WHERE country.Continent = '" + continent + "' ";
            }

            //if getting cities in REGION only
            else if (continent == null && region != null && district == null && country == null) {
                whereClause = "JOIN country ON (country.Code=city.CountryCode) WHERE country.Region = '" + region + "' ";
            }

            //if getting cities in DISTRICT only
            else if (continent == null && region == null && district != null && country == null) {
                whereClause = "WHERE district = '" + district + "' ";
            }

            //if getting cities in COUNTRY only
            else if (continent == null && region == null && district == null && country != null) {
                whereClause = "JOIN country ON country.Code = city.CountryCode WHERE country.Name = '" + country + "' ";
            }

            //if everything else is invalid
            else {
                return null;
            }

            // show results for top N cities only
            if (n!=0){
                limitClause = "LIMIT " + n;
            }


            String query = "SELECT id FROM city " +
                    whereClause + "ORDER BY city.Population DESC " +
                    limitClause;

            // execute the SQL statement to get results
            ResultSet result = statement.executeQuery(query);

            // while result has another line
            while (result.next()) {
                int id = result.getInt("id");
                results.add(DatabaseConnector.cities.get(id));
            }

            return results;

        }
        catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to load cities.");
                return null;
        }
    }


    /**
     * Gets the population of a specific continent, country, region, district or city if the parameter is provided. If none is provided,
     * it gets the population of the world. Runs an SQL query and returns the requested population.
     * @param continent continent
     * @param country country
     * @param region region
     * @param district district
     * @param city city
     * @return Population of type double if parameters were used correctly. -1 if not or if the query was unsuccessful.
     */
    public long getPopulation(String continent, String country, String region, String district, String city) {
        try {
            long population = 0;

            // create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            // to store the select and where clause depending on the parameters:
            String selectClause=""; // to distinguish between adding country populations or city
            String whereClause= ""; // based on parameters

            // world population if all parameters are null:
            if (continent==null && country==null && region==null && district==null && city==null){
                selectClause="SELECT SUM(Population) AS population FROM country ";
                whereClause="";
            }
            // continent population:
            else if (continent!=null && country==null && region==null && district==null && city==null){
                selectClause="SELECT SUM(Population) AS population FROM country ";
                whereClause="WHERE continent='" + continent + "' ";
            }
            // country population:
            else if(continent==null && country!=null && region==null && district==null && city==null){
                selectClause="SELECT SUM(Population) AS population FROM country ";
                whereClause="WHERE name='" + country + "' ";
            }
            // region population:
            else if(continent==null && country==null && region!=null && district==null && city==null){
                selectClause="SELECT SUM(Population) AS population FROM country ";
                whereClause="WHERE region='" + region + "' ";
            }

            // district population:
            else if(continent==null && country==null && region==null && district!=null && city==null){
                selectClause="SELECT SUM(Population) AS population FROM city ";
                whereClause="WHERE district='" + district + "' ";
            }
            // city population:
            else if(continent==null && country==null && region==null && district==null && city!=null){
                selectClause="SELECT Population AS population FROM city ";
                whereClause="WHERE name='" + city + "' ";
            }

            //if everything else is invalid
            else {
                return -1;
            }

            String query = selectClause + whereClause ;

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // while the result has another line:
            while (result.next()) {
                population = result.getLong("population");
            }
            return population;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load populations.");
            return -1;
        }
    }

    /**
     * Generates a report of the population of people, people living in cities, and people not living in cities in each continent.
     */
    public void runContinentPopulationReport() {
        try {

            // create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            String query = "SELECT Continent, `Continent Population`, `City Population`, CONCAT(`City Population`/`Continent Population` * 100, '%') AS `City %`, " +
                    "`Outside of City Population`, " +
                    "CONCAT(`Outside of City Population`/`Continent Population` * 100, '%') AS `Outside of city %` FROM " +
                    "(SELECT Continent, SUM(DISTINCT country.Population) AS `Continent Population`, " +
                    "SUM(city.Population) AS `City Population`, SUM(DISTINCT country.Population)-SUM(city.Population) AS `Outside of City Population` FROM country " +
                    "LEFT JOIN city ON (country.Code=city.CountryCode) " +
                    "GROUP BY country.Continent) AS results";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // print a header:
            String header = String.format("%-20s %-20s %-20s %-15s %-20s %-20s",
                    "Continent", "Population", "City Population", "City %", "Outside of City", "Outside of city %");
            System.out.println("Report of the population of people, people living in cities, and people not living in cities in each continent:");
            System.out.println(header);
            // while the result has another line:
            while (result.next()) {
                String continent = result.getString("Continent");
                String population = String.valueOf(result.getLong("Continent Population"));
                String cityPopulation = String.valueOf(result.getLong("City Population"));
                String cityPercentage =result.getString("City %");
                String outsidePopulation = String.valueOf(result.getLong("Outside of City Population"));
                String outsidePercentage = result.getString("Outside of city %");

                String row = String.format("%-20s %-20s %-20s %-15s %-20s %-20s",
                        continent, population, cityPopulation, cityPercentage, outsidePopulation, outsidePercentage);
                System.out.println(row);
            }
            System.out.println(String.format("%-20s %-20s %-20s %-15s %-20s %-20s",
                    "Antarctica", "0", "0", "N/A", "0", "N/A"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load continent population report.");

        }
    }

    /**
     * Generates a report of the population of people, people living in cities, and people not living in cities in each country.
     */
    public void runCountryPopulationReport() {
        try {

            // create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            String query = "SELECT `Country`, `Country Population`, `City population`, CONCAT(`City Population`/`Country Population` * 100, '%') AS `City %`, " +
                    "`Outside of City Population`, " +
                    "CONCAT(`Outside of City Population`/`Country Population` * 100, '%') AS `Outside of city %` " +
                    "FROM (SELECT country.Name AS `Country`, country.Population AS `Country Population`, " +
                    "SUM(city.Population) AS `City Population`, country.Population-SUM(city.Population) AS `Outside of City Population` FROM country " +
                    "LEFT JOIN city ON (country.Code=city.CountryCode) " +
                    "GROUP BY country.Name, country.Population) AS results";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // print a header:
            String header = String.format("%-30s %-20s %-20s %-15s %-20s %-20s",
                    "Country", "Population", "City Population", "City %", "Outside of City", "Outside of city %");
            System.out.println("Report of the population of people, people living in cities, and people not living in cities in each country:");
            System.out.println(header);
            // while the result has another line:
            while (result.next()) {
                String country = result.getString("Country");
                String population = String.valueOf(result.getLong("Country Population"));
                String cityPopulation = String.valueOf(result.getLong("City Population"));
                String cityPercentage =result.getString("City %");
                String outsidePopulation = String.valueOf(result.getLong("Outside of City Population"));
                String outsidePercentage = result.getString("Outside of city %");

                String row = String.format("%-30s %-20s %-20s %-15s %-20s %-20s",
                        country, population, cityPopulation, cityPercentage, outsidePopulation, outsidePercentage);
                System.out.println(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load country population report.");

        }
    }

    /**
     * Generates a report of the population of people, people living in cities, and people not living in cities in each region.
     */
    public void runRegionPopulationReport() {
        try {

            // create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            String query = "SELECT `Region`, `Region Population`, `City population`, CONCAT(`City Population`/`Region Population` * 100, '%') AS `City %`, " +
                    "`Outside of City Population`, " +
                    "CONCAT(`Outside of City Population`/`Region Population` * 100, '%') AS `Outside of city %` " +
                    "FROM " +
                    "(SELECT Region AS `Region`, SUM(DISTINCT country.Population) AS `Region Population`, " +
                    "SUM(city.Population) AS `City Population`, SUM(DISTINCT country.Population)-SUM(city.Population) AS `Outside of City Population` FROM country " +
                    "LEFT JOIN city ON (city.CountryCode=country.Code) " +
                    "GROUP BY country.Region) AS results";

            // execute SQL statement:
            ResultSet result = statement.executeQuery(query);

            // print a header:
            String header = String.format("%-30s %-20s %-20s %-15s %-20s %-20s",
                    "Region", "Population", "City Population", "City %", "Outside of City", "Outside of city %");
            System.out.println("Report of the population of people, people living in cities, and people not living in cities in each region:");
            System.out.println(header);
            // while the result has another line:
            while (result.next()) {
                String region = result.getString("Region");
                String population = String.valueOf(result.getLong("Region Population"));
                String cityPopulation = String.valueOf(result.getLong("City Population"));
                String cityPercentage =result.getString("City %");
                String outsidePopulation = String.valueOf(result.getLong("Outside of City Population"));
                String outsidePercentage = result.getString("Outside of city %");

                String row = String.format("%-30s %-20s %-20s %-15s %-20s %-20s",
                        region, population, cityPopulation, cityPercentage, outsidePopulation, outsidePercentage);
                System.out.println(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load region population report.");

        }
    }

}

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
     * Gets all the capital cities sorted by population descending. Runs an SQL query and returns ids.
     * The cities information is picked from the previously loaded HashMap by their id into an ArrayList and returned.
     * @param continent continent filter
     * @param region region filter
     * @param n top N capital cities filter
     * @return an array list of sorted capital cities
     */
    public ArrayList<Entry> getCapitalCitiesByPopulation (String continent, String region, int n) {
        try {

            ArrayList<Entry> results = new ArrayList<>();

            //create a statement and a SQL query string:
            Statement statement = DatabaseConnector.getConnection().createStatement();

            // to store where clause to filter results if required
            String whereClause = "";

            // to store limit clause if N is provided by user
            String limitClause = "";

            // if getting ALL capital cities
            if (continent == null && region == null) {
                whereClause = " ";
            }

            // if getting capital cities in continent
            else if (continent!= null && region == null){
                whereClause = "AND country.Continent = '" + continent + "' ";
            }

            // if getting capital cities in region
            else if (continent== null && region != null){
                whereClause = "AND country.Region = '" + region + "' ";
            }

            else {
                return null;
            }


            if (n != 0) {
                limitClause = "LIMIT " + n;
            }

            String query = "SELECT id FROM city JOIN country on country.Code = city.CountryCode WHERE country.Capital = city.id " +
                    whereClause + "ORDER BY city.Population DESC " +
                    limitClause;

            // execute the SQL statement to get results
            ResultSet result = statement.executeQuery(query);

            // while result has another line
            while (result.next()) {

                int id = result.getInt("id");
                results.add(DatabaseConnector.capitalCities.get(id));
            }

            return results;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to load capital cities.");
            return null;
        }
    }
}

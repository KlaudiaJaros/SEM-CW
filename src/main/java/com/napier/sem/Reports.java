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
     * @return an ArrayList of sorted countries
     */
    public ArrayList<Country> getCountriesByPopulation(String continent, String region, int n) {
        try {
            // to store and return results:
            ArrayList<Country> results = new ArrayList<>();

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
}

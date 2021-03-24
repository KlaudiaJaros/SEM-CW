package com.napier.sem;

import java.util.ArrayList;

/**
 * A class with the main method for our population system app.
 */
public class App
{
    /**
     * Main method
     * @param args args
     */
    public static void main(String[] args)
    {
        // Get the database connector:
        DatabaseConnector db = DatabaseConnector.getDatabaseConnector();

        // connect and load data:

        if (args.length < 1)
        {
            db.connect("localhost:33060");
        }
        else
        {
            db.connect(args[0]);
        }

        // load data and print all reports:
        db.loadData();
        printAllReports();

        // disconnect:
        db.disconnect();
    }

    /**
     * Print all reports as per coursework specification
     * Implemented reports: City and Country reports
     */
    public static void printAllReports(){
        // initialise reports class:
        Reports reports = new Reports();

        // COUNTRY REPORTS:

        // List all the countries in the world largest population to smallest:
        System.out.println("All countries in the world largest population to smallest:");
        ArrayList<Entry> countryResult = reports.getCountriesByPopulation(null, null, 0);
        printEntries(countryResult);

        // List all the countries in a continent largest population to smallest:
        System.out.println("All countries in a continent largest population to smallest:");
        ArrayList<Entry> byContinent = reports.getCountriesByPopulation("Africa", null, 0);
        printEntries(byContinent);

        // List all the countries in a region largest population to smallest:
        System.out.println("All countries in a region largest population to smallest:");
        ArrayList<Entry> byRegion = reports.getCountriesByPopulation(null, "Eastern Europe", 0);
        printEntries(byRegion);

        // List the top N populated countries in the world:
        System.out.println("List the top N populated countries in the world:");
        ArrayList<Entry> byNumber = reports.getCountriesByPopulation(null, null, 5);
        printEntries(byNumber);

        // List the top N countries in a continent largest population to smallest:
        System.out.println(" List the top N countries in a continent largest population to smallest:");
        ArrayList<Entry> byContinentTopN = reports.getCountriesByPopulation("Africa", null, 10);
        printEntries(byContinentTopN);

        // List the top N countries in a region largest population to smallest:
        System.out.println("List the top N countries in a region largest population to smallest:");
        ArrayList<Entry> byRegionTopN = reports.getCountriesByPopulation(null, "Eastern Europe", 0);
        printEntries(byRegionTopN);

        // CITY REPORTS:

        // List of all the cities in the world organised by largest population to smallest:
        System.out.println("List of all the cities in the world organised by largest population to smallest:");
        ArrayList<Entry> cityResult = reports.getCitiesByPopulation(null, null, null, null,0);
        printEntries(cityResult);

        // List of all the cities in a continent organised by largest population to smallest:
        System.out.println("List of all the cities in a continent organised by largest population to smallest: ");
        ArrayList<Entry> cityByContinent = reports.getCitiesByPopulation("Asia", null, null, null,0);
        printEntries(cityByContinent);

        // List of all the cities in a region organised by largest population to smallest:
        System.out.println("List of all the cities in a region organised by largest population to smallest:");
        ArrayList<Entry> cityByRegion = reports.getCitiesByPopulation(null, "Eastern Europe", null, null,0);
        printEntries(cityByRegion);

        // List of all the cities in a country organised by largest population to smallest:
        System.out.println("List of all the cities in a country organised by largest population to smallest:");
        ArrayList<Entry> cityByCountry = reports.getCitiesByPopulation(null,null,null,"Austria",0);
        printEntries(cityByCountry);

        // List of all the cities in a district organised by largest population to smallest:
        System.out.println("List of all the cities in a district organised by largest population to smallest:");
        ArrayList<Entry> cityByDistrict = reports.getCitiesByPopulation(null,null,"Dubai",null,0);
        printEntries(cityByDistrict);

        // List the top N cities in the world organised by largest population to smallest:
        System.out.println("List the top N cities in the world organised by largest population to smallest:");
        ArrayList<Entry> cityResultTopN = reports.getCitiesByPopulation(null, null, null, null,10);
        printEntries(cityResultTopN);

        // List the top N cities in a continent organised by largest population to smallest:
        System.out.println("List the top N cities in a continent organised by largest population to smallest: ");
        ArrayList<Entry> cityByContinentTopN = reports.getCitiesByPopulation("Asia", null, null, null,5);
        printEntries(cityByContinentTopN);

        // List the top N cities in a region organised by largest population to smallest:
        System.out.println("List the top N cities in a region organised by largest population to smallest:");
        ArrayList<Entry> cityByRegionTopN = reports.getCitiesByPopulation(null, "Eastern Europe", null, null,5);
        printEntries(cityByRegionTopN);

        // List the top N cities in a country organised by largest population to smallest:
        System.out.println("List the top N cities in a country organised by largest population to smallest:");
        ArrayList<Entry> cityByCountryTopN = reports.getCitiesByPopulation(null,null,null,"Austria",5);
        printEntries(cityByCountryTopN);

        // List the top N cities in a district organised by largest population to smallest:
        System.out.println("List the top N cities in a district organised by largest population to smallest:");
        ArrayList<Entry> cityByDistrictTopN = reports.getCitiesByPopulation(null,null,"Dubai",null,5);
        printEntries(cityByDistrictTopN);
    }

    /**
     * Takes in an ArrayList of an abstract type Entry and prints the header and format the entry according to the object type - City, Country or Language.
     * @param listOfEntries list of entries
     */
    public static void printEntries(ArrayList<Entry>listOfEntries){
        // Check if not null:
        if (listOfEntries == null || listOfEntries.size()==0)
        {
            System.out.println("No results to print.");
            return;
        }
        // Print header:
        if(listOfEntries.get(0) instanceof City){

            System.out.println(String.format("%-40s %-5s %-25s %-15s", "Name", "Code", "District", "Population"));
        }
        else if(listOfEntries.get(0) instanceof Country){
            System.out.println(String.format("%-5s %-50s %-30s %-30s %-15s %-30s", "Code", "Name", "Continent", "Region", "Population", "Capital Name"));
        }
        // Print all entries using the right toReportFormat() depending on the object:
        for(Entry e : listOfEntries){
            if(e==null)
                continue;
            System.out.println(e.toReportFormat());
        }
    }
}


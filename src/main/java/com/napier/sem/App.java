package com.napier.sem;

import java.util.ArrayList;

/**
 * A class with the main method for our population system app.
 */
public class App
{
    public static int entryCount=0;
    /**
     * Main method
     * @param args args
     */
    public static void main(String[] args)
    {
        // Get the database connector:
        DatabaseConnector db = DatabaseConnector.getDatabaseConnector();

        // connect and load data:
        //localhost:33060
        db.connect("db:3306");
        db.loadData();

        // disconnect:
        db.disconnect();
    }

    public static void printAllReports(){
        // initialise reports class:
        Reports reports = new Reports();

        // COUNTRY REPORTS:

        // List all the countries in the world largest population to smallest:
        System.out.println("All countries in the world largest population to smallest:");
        ArrayList<Entry> countryResult = reports.getCountriesByPopulation(null, null, 0);
        printEntries(countryResult);
        entryCount+=countryResult.size();

        // List all the countries in a continent largest population to smallest:
        System.out.println("All countries in a continent largest population to smallest:");
        ArrayList<Entry> byContinent = reports.getCountriesByPopulation("Africa", null, 0);
        printEntries(byContinent);
        entryCount+=byContinent.size();

        // List all the countries in a region largest population to smallest:
        System.out.println("All countries in a region largest population to smallest:");
        ArrayList<Entry> byRegion = reports.getCountriesByPopulation(null, "Eastern Europe", 0);
        printEntries(byRegion);
        entryCount+=byRegion.size();

        // List the top N populated countries in the world:
        System.out.println("List the top N populated countries in the world:");
        ArrayList<Entry> byNumber = reports.getCountriesByPopulation(null, null, 5);
        printEntries(byNumber);
        entryCount+=byNumber.size();

        // List the top N countries in a continent largest population to smallest:
        System.out.println(" List the top N countries in a continent largest population to smallest:");
        ArrayList<Entry> byContinentTopN = reports.getCountriesByPopulation("Africa", null, 10);
        printEntries(byContinentTopN);
        entryCount+=byContinentTopN.size();

        // List the top N countries in a region largest population to smallest:
        System.out.println("List the top N countries in a region largest population to smallest:");
        ArrayList<Entry> byRegionTopN = reports.getCountriesByPopulation(null, "Eastern Europe", 10);
        printEntries(byRegionTopN);
        entryCount+=byRegionTopN.size();

        // CITY REPORTS:

        // List of all the cities in the world organised by largest population to smallest:
        System.out.println("List of all the cities in the world organised by largest population to smallest:");
        ArrayList<Entry> cityResult = reports.getCitiesByPopulation(null, null, null, null,0);
        printEntries(cityResult);
        entryCount+=cityResult.size();

        // List of all the cities in a continent organised by largest population to smallest:
        System.out.println("List of all the cities in a continent organised by largest population to smallest: ");
        ArrayList<Entry> cityByContinent = reports.getCitiesByPopulation("Asia", null, null, null,0);
        printEntries(cityByContinent);
        entryCount+=cityByContinent.size();

        // List of all the cities in a region organised by largest population to smallest:
        System.out.println("List of all the cities in a region organised by largest population to smallest:");
        ArrayList<Entry> cityByRegion = reports.getCitiesByPopulation(null, "Eastern Europe", null, null,0);
        printEntries(cityByRegion);
        entryCount+=cityByRegion.size();

        // List of all the cities in a country organised by largest population to smallest:
        System.out.println("List of all the cities in a country organised by largest population to smallest:");
        ArrayList<Entry> cityByCountry = reports.getCitiesByPopulation(null,null,null,"Austria",0);
        printEntries(cityByCountry);
        entryCount+=cityByCountry.size();

        // List of all the cities in a district organised by largest population to smallest:
        System.out.println("List of all the cities in a district organised by largest population to smallest:");
        ArrayList<Entry> cityByDistrict = reports.getCitiesByPopulation(null,null,"Dubai",null,0);
        printEntries(cityByDistrict);
        entryCount+=cityByDistrict.size();

        // List the top N cities in the world organised by largest population to smallest:
        System.out.println("List the top N cities in the world organised by largest population to smallest:");
        ArrayList<Entry> cityResultTopN = reports.getCitiesByPopulation(null, null, null, null,10);
        printEntries(cityResultTopN);
        entryCount+=cityResultTopN.size();

        // List the top N cities in a continent organised by largest population to smallest:
        System.out.println("List the top N cities in a continent organised by largest population to smallest: ");
        ArrayList<Entry> cityByContinentTopN = reports.getCitiesByPopulation("Asia", null, null, null,5);
        printEntries(cityByContinentTopN);
        entryCount+=cityByContinentTopN.size();

        // List the top N cities in a region organised by largest population to smallest:
        System.out.println("List the top N cities in a region organised by largest population to smallest:");
        ArrayList<Entry> cityByRegionTopN = reports.getCitiesByPopulation(null, "Eastern Europe", null, null,5);
        printEntries(cityByRegionTopN);
        entryCount+=cityByRegionTopN.size();

        // List the top N cities in a country organised by largest population to smallest:
        System.out.println("List the top N cities in a country organised by largest population to smallest:");
        ArrayList<Entry> cityByCountryTopN = reports.getCitiesByPopulation(null,null,null,"Austria",5);
        printEntries(cityByCountryTopN);
        entryCount+=cityByCountryTopN.size();

        // List the top N cities in a district organised by largest population to smallest:
        System.out.println("List the top N cities in a district organised by largest population to smallest:");
        ArrayList<Entry> cityByDistrictTopN = reports.getCitiesByPopulation(null,null,"Dubai",null,5);
        printEntries(cityByDistrictTopN);
        entryCount+=cityByDistrictTopN.size();
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


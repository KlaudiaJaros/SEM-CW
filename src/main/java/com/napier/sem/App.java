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

        // initialise reports class:
        Reports reports = new Reports();

        // connect and load data:
        //localhost:33060

        if (args.length < 1)
        {
            db.connect("localhost:3306");
        }
        else
        {
            db.connect(args[0]);
        }

        db.loadData();

        // Verify contents: check sizes - should be: 239, 4079, 984:
        System.out.println(DatabaseConnector.countries.size());
        System.out.println(DatabaseConnector.cities.size());
        System.out.println(DatabaseConnector.languages.size());

        // Test district (Scotland):
        for (City c : DatabaseConnector.cities.values()){
            if (c.getDistrict().equals("Scotland"))
            {
                System.out.println(c.toString());
            }
        }


        // Test countries by populations desc:
        System.out.println("All countries:");
        ArrayList<Entry> countryResult = reports.getCountriesByPopulation(null, null, 0);
        printEntries(countryResult);

        // test countries by population in a specified continent:
        System.out.println("By continent:");
        ArrayList<Entry> byContinent = reports.getCountriesByPopulation("Africa", null, 0);
        printEntries(byContinent);

        // test countries by population in a specified region:
        System.out.println("By region:");
        ArrayList<Entry> byRegion = reports.getCountriesByPopulation(null, "Eastern Europe", 0);
        printEntries(byRegion);

        // test top 5 countries
        System.out.println("By number:");
        ArrayList<Entry> byNumber = reports.getCountriesByPopulation(null, null, 5);
        printEntries(byNumber);


        // testing getting cities populations report
        System.out.println("All cities: ");
        ArrayList<Entry> cityResult = reports.getCitiesByPopulation(null, null, null, null,5);
        printEntries(cityResult);


        // testing getting cities in a continent
        System.out.println("By continent: ");
        ArrayList<Entry> cityByContinent = reports.getCitiesByPopulation("Asia", null, null, null,0);
        printEntries(cityByContinent);

        //testing getting cities in a region
        System.out.println("By region: ");
        ArrayList<Entry> cityByRegion = reports.getCitiesByPopulation(null, "Eastern Europe", null, null,0);
        printEntries(cityByRegion);


        // testing getting cities in a country
        System.out.println("By country: ");
        ArrayList<Entry> cityByCountry = reports.getCitiesByPopulation(null,null,null,"Austria",0);
        printEntries(cityByCountry);

        // testing getting cities in a district
        System.out.println("By district: ");
        ArrayList<Entry> cityByDistrict = reports.getCitiesByPopulation(null,null,"Dubai",null,0);
        printEntries(cityByDistrict);

        // disconnect:
        db.disconnect();
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


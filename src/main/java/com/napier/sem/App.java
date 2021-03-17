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
        db.connect();
        db.loadData();

        // Verify contents: check sizes - should be: 239, 4079, 984:
        System.out.println(DatabaseConnector.countries.size());
        System.out.println(DatabaseConnector.cities.size());
        System.out.println(DatabaseConnector.languages.size());

        // Test city (should be Amsterdam):
        db.getCity(5);

        // Test district (Scotland):
        for (City c : DatabaseConnector.cities.values()){
            if (c.getDistrict().equals("Scotland"))
            {
                System.out.println(c.toString());
            }
        }


        // Test countries by populations desc:
        System.out.println("All countries:");
        ArrayList<Country> countryResult = reports.getCountriesByPopulation(null, null, 0);
        for (Country c : countryResult){
            System.out.println(c.toCountryReportFormat());
        }

        // test countries by population in a specified continent:
        System.out.println("By continent:");
        ArrayList<Country> byContinent = reports.getCountriesByPopulation("Africa", null, 0);
        for (Country c : byContinent){
            System.out.println(c.toCountryReportFormat());
        }


        // test countries by population in a specified region:
        System.out.println("By region:");
        ArrayList<Country> byRegion = reports.getCountriesByPopulation(null, "Eastern Europe", 0);
        for (Country c : byRegion){
            System.out.println(c.toCountryReportFormat());
        }

        // test top 5 countries
        System.out.println("By number:");
        ArrayList<Country> byNumber = reports.getCountriesByPopulation(null, null, 5);
        for (Country c : byNumber){
            System.out.println(c.toCountryReportFormat());
        }


        // testing getting cities populations report
        System.out.println("All cities: ");
        ArrayList<City> cityResult = reports.getCitiesByPopulation(null, null, null, null,5);
        for (City c : cityResult) {
            System.out.println(c.toCityReportFormat());
        }


        // testing getting cities in a continent
        System.out.println("By continent: ");
        ArrayList<City> cityByContinent = reports.getCitiesByPopulation("Asia", null, null, null,0);
        for (City c : cityByContinent) {
            System.out.println(c.toCityReportFormat());
        }

        //testing getting cities in a region
        System.out.println("By region: ");
        ArrayList<City> cityByRegion = reports.getCitiesByPopulation(null, "Eastern Europe", null, null,0);
        for (City c : cityByRegion) {
            System.out.println(c.toCityReportFormat());
        }


        // testing getting cities in a country
        System.out.println("By country: ");
        ArrayList<City> cityByCountry = reports.getCitiesByPopulation(null,null,null,"Austria",0);
        for (City c : cityByCountry) {
            System.out.println(c.toCityReportFormat());
        }

        // testing getting cities in a district
        System.out.println("By district: ");
        ArrayList<City> cityByDistrict = reports.getCitiesByPopulation(null,null,"Dubai",null,0);
        for (City c : cityByDistrict) {
            System.out.println(c.toCityReportFormat());
        }

        // disconnect:
        db.disconnect();
    }
}


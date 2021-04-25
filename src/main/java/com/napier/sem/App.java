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

        // variables that will be provided by the user if needed:
        String continent;
        String region;
        String district;
        String country;
        String city;
        int n;

        // COUNTRY REPORTS:

        // List all the countries in the world largest population to smallest:
        System.out.println("All countries in the world largest population to smallest:");
        ArrayList<Entry> countryResult = reports.getCountriesByPopulation(null, null, 0);
        printEntries(countryResult);

        // List all the countries in a continent largest population to smallest:
        // E.g.: user provided "Africa" as the continent
        System.out.println("All countries in a continent largest population to smallest:");
        continent = "Africa";
        System.out.println("User provided "+ continent + " as the continent:");
        ArrayList<Entry> byContinent = reports.getCountriesByPopulation(continent, null, 0);
        printEntries(byContinent);

        // List all the countries in a region largest population to smallest:
        // E.g.: user provided "Eastern Europe" as the region
        System.out.println("All countries in a region largest population to smallest:");
        region = "Eastern Europe";
        System.out.println("User provided "+ region + " as the region:");
        ArrayList<Entry> byRegion = reports.getCountriesByPopulation(null, region, 0);
        printEntries(byRegion);

        // List the top N populated countries in the world:
        // E.g.: user provided 5 as the N
        System.out.println("List the top N populated countries in the world:");
        n = 5;
        System.out.println("User provided "+ n + " as the N:");
        ArrayList<Entry> byNumber = reports.getCountriesByPopulation(null, null, n);
        printEntries(byNumber);

        // List the top N countries in a continent largest population to smallest:
        // E.g.: user provided "Africa" as the continent and 10 as the N
        System.out.println("List the top N countries in a continent largest population to smallest:");
        continent = "Africa";
        n = 10;
        System.out.println("User provided "+ continent +" as the continent and " + n + " as the N:");
        ArrayList<Entry> byContinentTopN = reports.getCountriesByPopulation(continent, null, n);
        printEntries(byContinentTopN);

        // List the top N countries in a region largest population to smallest:
        // E.g.: user provided "Eastern Europe" as the region and 5 as the N
        System.out.println("List the top N countries in a region largest population to smallest:");
        region = "Eastern Europe";
        n = 5;
        System.out.println("User provided "+ region +" as the region and " + n + " as the N:");
        ArrayList<Entry> byRegionTopN = reports.getCountriesByPopulation(null, region, n);
        printEntries(byRegionTopN);

        // CITY REPORTS:

        // List of all the cities in the world organised by largest population to smallest:
        System.out.println("List of all the cities in the world organised by largest population to smallest:");
        ArrayList<Entry> cityResult = reports.getCitiesByPopulation(null, null, null, null,0);
        printEntries(cityResult);

        // List of all the cities in a continent organised by largest population to smallest:
        // E.g.: user provided "Asia" as the continent
        System.out.println("List of all the cities in a continent organised by largest population to smallest: ");
        continent = "Asia";
        System.out.println("User provided "+ continent +" as the continent:");
        ArrayList<Entry> cityByContinent = reports.getCitiesByPopulation(continent, null, null, null,0);
        printEntries(cityByContinent);

        // List of all the cities in a region organised by largest population to smallest:
        // E.g.: user provided "Eastern Europe" as the region
        System.out.println("List of all the cities in a region organised by largest population to smallest:");
        region = "Eastern Europe";
        System.out.println("User provided "+ region +" as the region:");
        ArrayList<Entry> cityByRegion = reports.getCitiesByPopulation(null, region, null, null,0);
        printEntries(cityByRegion);

        // List of all the cities in a country organised by largest population to smallest:
        // E.g.: user provided "Austria" as the country
        System.out.println("List of all the cities in a country organised by largest population to smallest:");
        country = "Austria";
        System.out.println("User provided "+ country +" as the country:");
        ArrayList<Entry> cityByCountry = reports.getCitiesByPopulation(null,null,null,country,0);
        printEntries(cityByCountry);

        // List of all the cities in a district organised by largest population to smallest:
        // E.g.: user provided "Dubai" as the district
        System.out.println("List of all the cities in a district organised by largest population to smallest:");
        district = "Dubai";
        System.out.println("User provided "+ district +" as the district:");
        ArrayList<Entry> cityByDistrict = reports.getCitiesByPopulation(null,null,district,null,0);
        printEntries(cityByDistrict);

        // List the top N cities in the world organised by largest population to smallest:
        // E.g.: user provided 10 as the N
        System.out.println("List the top N cities in the world organised by largest population to smallest:");
        n = 10;
        System.out.println("User provided "+ n +" as the N:");
        ArrayList<Entry> cityResultTopN = reports.getCitiesByPopulation(null, null, null, null,n);
        printEntries(cityResultTopN);

        // List the top N cities in a continent organised by largest population to smallest:
        // E.g.: user provided "Asia" as the continent and 5 as the N
        System.out.println("List the top N cities in a continent organised by largest population to smallest: ");
        continent = "Asia";
        n = 5;
        System.out.println("User provided "+ continent +" as the continent and " + n + " as the N:");
        ArrayList<Entry> cityByContinentTopN = reports.getCitiesByPopulation(continent, null, null, null,n);
        printEntries(cityByContinentTopN);

        // List the top N cities in a region organised by largest population to smallest:
        // E.g.: user provided "Eastern Europe" as the region and 5 as the N
        System.out.println("List the top N cities in a region organised by largest population to smallest:");
        region = "Eastern Europe";
        n = 5;
        System.out.println("User provided "+ region +" as the region and " + n + " as the N:");
        ArrayList<Entry> cityByRegionTopN = reports.getCitiesByPopulation(null, region, null, null,n);
        printEntries(cityByRegionTopN);

        // List the top N cities in a country organised by largest population to smallest:
        // E.g.: user provided "Austria" as the country and 5 as the N
        System.out.println("List the top N cities in a country organised by largest population to smallest:");
        country = "Austria";
        n = 5;
        System.out.println("User provided "+ country +" as the country and " + n + " as the N:");
        ArrayList<Entry> cityByCountryTopN = reports.getCitiesByPopulation(null,null,null,country,n);
        printEntries(cityByCountryTopN);

        // List the top N cities in a district organised by largest population to smallest:
        // E.g.: user provided "Kansas" as the district and 2 as the N
        System.out.println("List the top N cities in a district organised by largest population to smallest:");
        district = "Kansas";
        n = 2;
        System.out.println("User provided "+ district +" as the district and " + n + " as the N:");
        ArrayList<Entry> cityByDistrictTopN = reports.getCitiesByPopulation(null,null,district,null,n);
        printEntries(cityByDistrictTopN);

        // List of all the capital cities in the world organised by largest population to smallest:
        System.out.println("List of all the capital cities in the world organised by largest population to smallest:");
        ArrayList<Entry> capitalCityResult = reports.getCapitalCitiesByPopulation(null,null,0);
        printEntries(capitalCityResult);

        // List of all the capital cities in a continent organised by largest population to smallest:
        // E.g.: user provided "Europe" as the continent
        System.out.println("List of all the capital cities in a continent organised by largest population to smallest:");
        continent = "Europe";
        System.out.println("User provided "+ continent +" as the continent:");
        ArrayList<Entry> capitalCityByContinent = reports.getCapitalCitiesByPopulation(continent,null,0);
        printEntries(capitalCityByContinent);

        // List of all the capital cities in a region organised by largest population to smallest:
        // E.g.: user provided "Eastern Europe" as the region
        System.out.println("List of all the capital cities in a region organised by largest population to smallest:");
        region = "Eastern Europe";
        System.out.println("User provided "+ region +" as the region:");
        ArrayList<Entry> capitalCityByRegion = reports.getCapitalCitiesByPopulation(null,region,0);
        printEntries(capitalCityByRegion);

        // List of top N the capital cities in the world organised by largest population to smallest:
        // E.g.: user provided 5 as the N
        System.out.println("List of top N the capital cities in the world organised by largest population to smallest:");
        n = 5;
        System.out.println("User provided "+ n +" as the N:");
        ArrayList<Entry> capitalCityResultTopN = reports.getCapitalCitiesByPopulation(null,null,n);
        printEntries(capitalCityResultTopN);

        // List of top N the capital cities in a continent organised by largest population to smallest:
        // E.g.: user provided "Europe" as the continent and 5 as the N
        System.out.println("List of top N the capital cities in a continent organised by largest population to smallest:");
        continent = "Europe";
        n = 5;
        System.out.println("User provided "+ continent +" as the continent and " + n + " as the N:");
        ArrayList<Entry> capitalCityByContinentTopN = reports.getCapitalCitiesByPopulation(continent,null,n);
        printEntries(capitalCityByContinentTopN);

        // List of top N the capital cities in a region organised by largest population to smallest:
        // E.g.: user provided "Eastern Europe" as the region and 5 as the N
        System.out.println("List of top N the capital cities in a region organised by largest population to smallest:");
        region = "Eastern Europe";
        n = 5;
        System.out.println("User provided "+ region +" as the region and " + n + " as the N:");
        ArrayList<Entry> capitalCityByRegionTopN = reports.getCapitalCitiesByPopulation(null,region,n);
        printEntries(capitalCityByRegionTopN);


        // Population of the world:
        System.out.println("World population: " + reports.getPopulation(null, null, null, null, null));

        // Population of a continent:
        // E.g.: user provided "Asia" as the continent
        continent = "Asia";
        System.out.println("Continent("+ continent + ") population: " + reports.getPopulation(continent, null, null, null, null));

        // Population of a country:
        // E.g.: user provided "Egypt" as the country
        country = "Egypt";
        System.out.println("Country(" + country + ") population: " + reports.getPopulation(null, country, null, null, null));

        // Population of a region:
        // E.g.: user provided "Western Europe" as the region
        region = "Western Europe";
        System.out.println("Region(" + region + ") population: " + reports.getPopulation(null, null, region, null, null));

        // Population of a district:
        // E.g.: user provided "Buenos Aires" as the district
        district = "Buenos Aires";
        System.out.println("District(" + district + ") population: " + reports.getPopulation(null, null, null, district, null));

        // Population of a city:
        // E.g.: user provided "Oxford" as the city
        city = "Oxford";
        System.out.println("City(" + city + ") population: " + reports.getPopulation(null, null, null, null, city));

        // The population of people, people living in cities, and people not living in cities in each continent report:
        reports.runContinentPopulationReport();
        // The population of people, people living in cities, and people not living in cities in each country report:
        reports.runCountryPopulationReport();
        // The population of people, people living in cities, and people not living in cities in each region report:
        reports.runRegionPopulationReport();

        // Language report
        System.out.println("Number of people who speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest:");
        System.out.println(reports.getLanguageReport());

    }

    /**
     * Takes in an ArrayList of an abstract type Entry and prints the header and format the entry according to the object type - City, Country or Language.
     * @param listOfEntries list of entries
     */
    public static void printEntries(ArrayList<Entry>listOfEntries){
        // Check if not null:
        if (listOfEntries == null || listOfEntries.isEmpty())
        {
            System.out.println("No results to print.");
            return;
        }
        // Print header:
        // if entry is a city
        if(listOfEntries.get(0) instanceof City){
            // if entry is a capital city -> Capital City report header
            if (((City) listOfEntries.get(0)).getDistrict()==null){
                System.out.println(String.format("%-40s %-50s %-15s", "Name", "Country", "Population"));
            } else {
                // entry is not a capital city -> City report header
                System.out.println(String.format("%-40s %-50s %-25s %-15s", "Name", "Country", "District", "Population"));
            }
        }
        // if entry is a country
        else if(listOfEntries.get(0) instanceof Country){
            // Country report header
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


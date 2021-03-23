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
        //localhost:33060
        db.connect("db:3306");
        db.loadData();

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


package com.napier.sem;

import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Get the database connector:
        DatabaseConnector db = DatabaseConnector.getDatabaseConnector();

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
        ArrayList<Country> result = db.getAllCountriesByPopulation();
        for (Country c : result){
            System.out.println(c.toString());
        }

        // disconnect:
        db.disconnect();
    }
}


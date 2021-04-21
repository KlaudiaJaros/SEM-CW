package com.napier.sem;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Unit tests for App class
 */
public class AppTest {
    static App app;

    /**
     * Initialise app
     */
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * Null parameter test for printEntries method
     */
    @Test
    void printEntriesTestNull()
    {
        assertNotNull(app);
       app.printEntries(null);
    }

    /**
     * Empty array parameter test for printEntries method
     */
    @Test
    void printEntriesTestEmpty()
    {
        ArrayList<Entry> list = new ArrayList<>();
        assertNotNull(app);
        app.printEntries(list);
    }

    /**
     * Null elements in array test
     */
    @Test
    void printEntriesTestContainsNull()
    {
        ArrayList<Entry> list = new ArrayList<>();
        list.add(null);
        assertNotNull(app);
        app.printEntries(list);
    }

    /**
     * Test that printEntries method prints a formatted string with country data
     */
    @Test
    void printEntriesTestPrintsCountry()
    {
        ArrayList<Entry> list = new ArrayList<>();
        Country country = new Country();
        country.setCode("GBR");
        country.setName("United Kingdom");
        country.setContinent("Europe");
        country.setRegion("British Islands");
        country.setSurfaceArea(242900.00);
        country.setPopulation(59623400);
        country.setCapitalCityID(456);
        list.add(country);
        assertNotNull(app);
        app.printEntries(list);
    }

    /**
     * Test that printEntries method prints a formatted string with city data
     */
    @Test
    void printEntriesTestPrintsCity()
    {
        ArrayList<Entry> list = new ArrayList<>();
        City city = new City();
        city.setId(1);
        city.setName("Edinburgh");
        city.setDistrict("Scotland");
        city.setCountryCode("GB");
        city.setPopulation(300000);
        list.add(city);
        assertNotNull(app);
        app.printEntries(list);
    }
}
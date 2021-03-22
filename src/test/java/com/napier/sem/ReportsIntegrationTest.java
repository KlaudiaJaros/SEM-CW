package com.napier.sem;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for report class
 */
public class ReportsIntegrationTest {
    static DatabaseConnector databaseConnector;
    static Reports reports;

    /**
    * Initialise connection and load data
    */
    @BeforeAll
    static void init()
    {
        databaseConnector = DatabaseConnector.getDatabaseConnector();
        databaseConnector.connect("localhost:33060");
        databaseConnector.loadData();
        reports = new Reports();

    }

    /**
     * Test invalid parameters return null for getCountriesByPopulation method
     */
    @Test
    void getCountriesByPopulationNullTest(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation("invalid", "invalid", -10);
        assertNull(results);
    }

    /**
     * Test no parameters return all countries for getCountriesByPopulation method
     */
    @Test
    void getCountriesByPopulationTestNullParameters(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation(null, null, 0);
        assertEquals(DatabaseConnector.countries.size(), results.size());
    }

    /**
     * Test that too many parameters return null for getCountriesByPopulation method
     */
    @Test
    void getCountriesByPopulationOverloadTest() {
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation("Asia", "North America" ,3);
        assertNull(results);
    }

    /**
     * Test invalid parameters return null for getCitiesByPopulation method
     */
    @Test
    void getCitiesByPopulationNullTest(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation("invalid", "invalid", "invalid", "invalid", -10);
        assertNull(results);
    }

    /**
     * Test no parameters return all countries for getCitiesByPopulation method
     */
    @Test
    void getCitiesByPopulationTestNullParameters(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation(null, null, null, null, 0);
        assertEquals(DatabaseConnector.cities.size(), results.size());
    }

    /**
     * Test that too many parameters return null for getCitiesByPopulation method
     */
    @Test
    void getCitiesByPopulationOverloadTest() {
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation("Europe", "Eastern Europe", "California", "Belgium", 2);
        assertNull(results);

    }

    /**
     *  Disconnect from database
     */
    @AfterAll
    static void disconnectFromDatabase()
    {
        databaseConnector.disconnect();
    }

}

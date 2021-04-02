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
     * Test that getCountriesByPopulation method returns the correct number of countries
     * when a continent is specified
     */
    @Test
    void getCountriesByPopulationTestContinent(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation("Africa", null, 0);
        int expected = 58;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCountriesByPopulation method returns the correct number of countries
     * when a region is specified
     */
    @Test
    void getCountriesByPopulationTestRegion(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation(null, "Northern Africa", 0);
        int expected = 7;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCountriesByPopulation method returns the correct number of countries
     * when N is specified
     */
    @Test
    void getCountriesByPopulationTestTopN(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation(null, null, 5);
        int expected = 5;
        assertEquals(expected, results.size());
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
     * Test that reports.getCountriesByPopulation returns the correct number of countries
     * when a continent and N is specified.
     * If there are less results than N, the method returns all results
     */
    @Test
    void getCountriesByPopulationTestContinentTopN(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation("Antarctica", null, 10);
        int expected = 5; // number of countries in Antarctica is less than the specified N (10)
        assertEquals(expected, results.size());
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
     * Test that getCitiesByPopulation returns the correct number of cities
     * when a continent is specified
     */
    @Test
    void getCitiesByPopulationTestContinent(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation("Asia", null, null, null, 0);
        int expected = 1766;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCitiesByPopulation returns the correct number of cities
     * when a region is specified
     */
    @Test
    void getCitiesByPopulationTestRegion(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation(null, "Caribbean", null, null, 0);
        int expected = 58;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCitiesByPopulation returns the correct number of cities
     * when a district is specified
     */
    @Test
    void getCitiesByPopulationTestDistrict(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation(null, null, "Buenos Aires", null, 0);
        int expected = 31;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCitiesByPopulation returns the correct number of cities
     * when a country is specified
     */
    @Test
    void getCitiesByPopulationTestCountry(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation(null, null, null, "Germany", 0);
        int expected = 93;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCitiesByPopulation returns the correct number of cities
     * when N is specified
     */
    @Test
    void getCitiesByPopulationTestTopN(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation(null, null, null, null, 100);
        int expected = 100;
        assertEquals(expected, results.size());
    }

    /**
     * Test that getCitiesByPopulation return the correct number of cities
     * when a district and N is specified.
     * If there are less results than N, the method returns all results
     */
    @Test
    void getCitiesByPopulationTestDistrictTopN(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCitiesByPopulation(null, null, "Kyoto", null, 5);
        int expected = 4; // number of cities in Kyoto District is less than the specified N (5)
        assertEquals(expected, results.size());
    }

    /**
     * Test that getLanguageReport
     * does not return an empty string
     */
    @Test
    void getLanguageReportTest(){
        String results = reports.getLanguageReport();
        assertNotNull(results);
    }

    /**
     * Test runCountryPopulationReport method
     */
    @Test
    void runCountryPopulationReportTest(){
        reports.runCountryPopulationReport();
    }

    /**
     * Test runRegionPopulationReport method
     */
    @Test
    void runRegionPopulationReportTest(){
        reports.runRegionPopulationReport();
    }

    /**
     * Test runContinentPopulationReport method
     */
    @Test
    void runContinentPopulationReportTest(){
        reports.runContinentPopulationReport();
    }

    /**
     * Test that getPopulation does not return -1
     * with one parameter
     */
    @Test
    void getPopulationTestValid(){
        assertNotEquals(-1, reports.getPopulation("Europe", null, null, null, null));
    }

    /**
     * Test that getPopulation does return -1
     * with all parameters
     */
    @Test
    void getPopulationTestInvalid(){
        assertEquals(-1, reports.getPopulation("Europe","France", "Buenos Aires", "DC", "Paris"));
    }

    /**
     * Test that getPopulation does not return -1
     * with no parameters
     */
    @Test
    void getPopulationTestNull(){
        assertNotEquals(-1, reports.getPopulation(null, null, null, null, null));
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

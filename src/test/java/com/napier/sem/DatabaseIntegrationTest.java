package com.napier.sem;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for DatabaseConnector class
 */
public class DatabaseIntegrationTest {
    static DatabaseConnector databaseConnector;
    static Country country;
    static City city;

    /**
     * Initialise connection and load data
     */
    @BeforeAll
    static void init()
    {
        databaseConnector = DatabaseConnector.getDatabaseConnector();
        databaseConnector.connect("localhost:33060");
        databaseConnector.loadData();

        country = new Country();
        country.setCode("GBR");
        country.setName("United Kingdom");
        country.setContinent("Europe");
        country.setRegion("British Islands");
        country.setSurfaceArea(242900.00);
        country.setPopulation(59623400);
        country.setCapitalCityID(456);

        city = new City();
        city.setId(1);
        city.setName("Edinburgh");
        city.setDistrict("Scotland");
        city.setCountryCode("GBR");
        city.setPopulation(300000);
    }

    /**
     * Ensure the number of cities is correct
     */
    @Test
    void loadDataTestNumberOfCities()
    {
        int actualNumberOfCities = DatabaseConnector.cities.size();
        int expectedNumberOfCities = 4079;

        assertEquals(expectedNumberOfCities, actualNumberOfCities);
    }

    /**
     * Ensure number of countries is correct
     */
    @Test
    void loadDataTestNumberOfCountries()
    {
        int actualNumberOfCountries = DatabaseConnector.countries.size();
        int expectedNumberOfCountries = 239;

        assertEquals(expectedNumberOfCountries, actualNumberOfCountries);
    }

    /**
     * Ensure number of languages is correct
     */
    @Test
    void loadDataTestNumberOfLanguages()
    {
        int actualNumberOfLanguages = DatabaseConnector.languages.size();
        int expectedNumberOfLanguages = 984;

        assertEquals(expectedNumberOfLanguages, actualNumberOfLanguages);
    }

    /**
     * Ensure number of capital cities is correct
     */
    @Test
    void loadDataTestNumberOfCapitalCities()
    {
        int actualNumberOfCapitalCities = DatabaseConnector.capitalCities.size();
        int expectedNumberOfCapitalCities = 232;

        assertEquals(expectedNumberOfCapitalCities, actualNumberOfCapitalCities);
    }

    /**
     * Ensure connection is not null
     */
    @Test
    void getConnectionNotNull()
    {
        Connection connection = DatabaseConnector.getConnection();
        assertNotNull(connection);
    }

    /**
     * Test format method formats as expected
     */
    @Test
    void testCountryToReportFormat(){

        String expectedToString =  String.format("%-5s %-50s %-30s %-30s %-15s %-30s",
                "GBR", "United Kingdom", "Europe","British Islands" , 59623400, "London");

        String actualToString=country.toReportFormat();

        assertEquals(expectedToString, actualToString);
    }

    /**
     * Test format method formats as expected
     */
    @Test
    void testCityToReportFormat(){

        String expectedToString =  String.format("%-40s %-50s %-25s %-15s", "Edinburgh", "United Kingdom", "Scotland", "300000");

        String actualToString=city.toReportFormat();

        assertEquals(expectedToString, actualToString);
    }

    /**
     * Disconnect from database
     */
    @AfterAll
    static void disconnectFromDatabase()
    {
        databaseConnector.disconnect();
    }
}

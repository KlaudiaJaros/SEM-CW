package com.napier.sem;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for DatabaseConnector class
 */
public class DatabaseIntegrationTest {
    static DatabaseConnector databaseConnector;

    /**
     * Initialise connection and load data
     */
    @BeforeAll
    static void init()
    {
        databaseConnector = DatabaseConnector.getDatabaseConnector();
        databaseConnector.connect("localhost:33060");
        databaseConnector.loadData();
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
     * Disconnect from database
     */
    @AfterAll
    static void disconnectFromDatabase()
    {
        databaseConnector.disconnect();
    }
}

package com.napier.sem;
import com.napier.sem.City;
import com.napier.sem.DatabaseConnector;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class DatabaseIntegrationTest {
    static DatabaseConnector databaseConnector;

    @BeforeAll
    static void init()
    {
        databaseConnector = DatabaseConnector.getDatabaseConnector();
        databaseConnector.connect("localhost:3306");
    }

    @Test
    void loadDataTestNumberOfCities()
    {
        databaseConnector.loadData();
        int actualNumberOfCities = DatabaseConnector.cities.size();
        int expectedNumberOfCities = 4079;

        assertEquals(expectedNumberOfCities, actualNumberOfCities);
    }

    @Test
    void loadDataTestNumberOfCountries()
    {
        databaseConnector.loadData();
        int actualNumberOfCountries = DatabaseConnector.countries.size();
        int expectedNumberOfCountries = 239;

        assertEquals(expectedNumberOfCountries, actualNumberOfCountries);
    }

    @Test
    void loadDataTestNumberOfLanguages()
    {
        databaseConnector.loadData();
        int actualNumberOfLanguages = DatabaseConnector.languages.size();
        int expectedNumberOfLanguages = 984;

        assertEquals(expectedNumberOfLanguages, actualNumberOfLanguages);
    }

    @Test
    void getConnectionNotNull()
    {
        Connection connection = DatabaseConnector.getConnection();
        assertNotNull(connection);
    }
    @Test
    void connectTest()
    {
        databaseConnector.connect("db:3306");
        assertNotNull(DatabaseConnector.getConnection());
    }
}

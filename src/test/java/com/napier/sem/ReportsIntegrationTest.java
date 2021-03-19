package com.napier.sem;
import com.napier.sem.DatabaseConnector;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class ReportsIntegrationTest {
    static DatabaseConnector databaseConnector;
    static Reports reports;

    @BeforeAll
    static void init()
    {
        databaseConnector = DatabaseConnector.getDatabaseConnector();
        databaseConnector.connect("localhost:33060");
        databaseConnector.loadData();
        reports = new Reports();

    }

    @Test
    void getCountriesByPopulationTest(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation("invalid", "invalid", -10);
        assertNull(results);
    }

    @Test
    void getCountriesByPopulationTestNull(){
        ArrayList<Entry> results = new ArrayList<>();
        results = reports.getCountriesByPopulation(null, null, 0);
        assertEquals(DatabaseConnector.countries.size(), results.size());
    }

    @AfterAll
    static void disconnectFromDatabase()
    {
        databaseConnector.disconnect();
    }

}

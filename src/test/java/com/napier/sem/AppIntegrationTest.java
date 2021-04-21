package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration test for App.java
 */
public class AppIntegrationTest {
    static App app;
    static DatabaseConnector db;

    /**
     * Initialise app
     */
    @BeforeAll
    static void init(){

        app=new App();
        db = DatabaseConnector.getDatabaseConnector();
        db.connect("localhost:33060");
        db.loadData();
    }

    /**
     * Test printAllReports method
     */
    @Test
    void printAllReportsTest(){
        assertNotNull(app);
        app.printAllReports();
    }

    /**
     * Disconnect from database
     */
    @AfterAll
    static void disconnectFromDatabase()
    {
        db.disconnect();
    }
}

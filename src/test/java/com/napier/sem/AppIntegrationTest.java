package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppIntegrationTest {
    static App app;

    /**
     * Initialise app
     */
    @BeforeAll
    static void init(){

        app=new App();
        // Get the database connector:
        DatabaseConnector db = DatabaseConnector.getDatabaseConnector();

        // connect and load data:
        //localhost:33060
        db.connect("localhost:33060");
        db.loadData();
    }

    /**
     * Test printAllReports method
     */
    @Test
    void printAllReportsTest(){
        app.printAllReports();
    }
}

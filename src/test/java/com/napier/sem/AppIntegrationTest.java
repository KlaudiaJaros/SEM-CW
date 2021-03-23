package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/***
 * Integration test for App.java
 */
public class AppIntegrationTest {

    static App app;

    /**
     * Initialise App
     */
    @BeforeAll
    static void init()
    {
        app=new App();
    }

    /**
     * Test printAllReports method
     */
    @Test
    void printReportsTest(){
        app.printAllReports();

    }

}

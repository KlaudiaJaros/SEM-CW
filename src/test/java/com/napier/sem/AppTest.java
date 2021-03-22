package com.napier.sem;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

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
        app.printEntries(null);
    }

    /**
     * Empty array parameter test for printEntries method
     */
    @Test
    void printEntriesTestEmpty()
    {
        ArrayList<Entry> list = new ArrayList<>();
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
        app.printEntries(list);
    }


}
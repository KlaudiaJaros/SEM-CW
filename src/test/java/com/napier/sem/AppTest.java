package com.napier.sem;

import org.junit.jupiter.api.*;
import java.util.ArrayList;


public class AppTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printEntriesTestNull()
    {
        app.printEntries(null);
    }

    @Test
    void printEntriesTestEmpty()
    {
        ArrayList<Entry> list = new ArrayList<>();
        app.printEntries(list);
    }

    @Test
    void printEntriesTestContainsNull()
    {
        ArrayList<Entry> list = new ArrayList<>();
        list.add(null);
        app.printEntries(list);
    }


}
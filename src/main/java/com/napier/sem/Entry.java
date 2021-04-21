package com.napier.sem;

/**
 * interface to be inherited by any class that needs to use the toReportFormat method
 */
public interface Entry {
    /**
     * abstract method that returns string in the format needed for the report
     * @return string
     */
    String toReportFormat();
}

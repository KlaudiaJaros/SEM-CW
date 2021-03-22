package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Country class
 */
public class CountryTest {
    static Country country;

    /**
     * Initialise Country
     */
    @BeforeAll
    static void init()
    {
        country = new Country();
        country.setCode("GB");
        country.setName("United Kingdom");
        country.setContinent("Europe");
        country.setRegion("British Islands");
        country.setSurfaceArea(242900.00);
        country.setPopulation(59623400);
        country.setCapitalCityID(20);
    }

    /**
     * Test toString method prints expected values
     */
    @Test
    void testCityToString(){

        String expectedToString =  "Country{" +
                "code=" + country.getCode() +
                ", name='" + country.getName() + '\'' +
                ", continent='" + country.getContinent() + '\'' +
                ", region='" + country.getRegion() + '\'' +
                ", surfaceArea=" + country.getSurfaceArea() +
                ", population=" + country.getPopulation() +
                ", capitalCityID='" + country.getCapitalCityID() + '\'' +
                '}';

        String actualToString=country.toString();

        Assertions.assertEquals(expectedToString, actualToString);

    }

    /**
     * Test format method formats as expected
     */
    @Test
    void testCityToReportFormat(){

        String expectedToString =  String.format("%-5s %-50s %-30s %-30s %-15s %-30s",
                "GB", "United Kingdom", "Europe","British Islands" , 59623400, "N/A");

        String actualToString=country.toReportFormat();

        Assertions.assertEquals(expectedToString, actualToString);
    }
}

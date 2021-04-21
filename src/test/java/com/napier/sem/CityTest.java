package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for City class
 */
public class CityTest {
    static City city;

    /**
     * Initialise City
     */
    @BeforeAll
    static void init()
    {
        city = new City();
        city.setId(1);
        city.setName("Edinburgh");
        city.setDistrict("Scotland");
        city.setCountryCode("GB");
        city.setPopulation(300000);
    }

    /**
     * Test toString method prints expected values
     */
    @Test
    void testCityToString(){

        String expectedToString =  "City{" +
                "id=" + city.getId() +
                ", name='" + city.getName() + '\'' +
                ", countryCode='" + city.getCountryCode() + '\'' +
                ", district='" + city.getDistrict() + '\'' +
                ", population=" + city.getPopulation() +
                '}';

        String actualToString=city.toString();
        assertEquals(expectedToString, actualToString);

    }


}

package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CityTest {
    static City city;

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

        Assertions.assertEquals(expectedToString, actualToString);

    }

    @Test
    void testCityToReportFormat(){

        String expectedToString =  String.format("%-40s %-5s %-25s %-15s", "Edinburgh", "GB", "Scotland", "300000");

        String actualToString=city.toReportFormat();

        Assertions.assertEquals(expectedToString, actualToString);
    }
}

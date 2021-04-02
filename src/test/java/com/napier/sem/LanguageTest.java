package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Language class
 */
public class LanguageTest {
    static Language language;

    /**
     * Initialise Language
     */
    @BeforeAll
    static void init()
    {
        language = new Language();
        language.setName("English");
        language.setCountryCode("GB");
        language.setOfficial(true);
        language.setPercentage(99);

    }

    /**
     * Test toString method prints expected values
     */
    @Test
    void testLanguageToString(){

        String expectedToString =  "Language{" +
                "name='" + language.getName() + '\'' +
                ", countryCode='" + language.getCountryCode() + '\'' +
                ", isOfficial=" + language.isOfficial() +
                ", percentage=" + language.getPercentage() +
                '}';

        String actualToString=language.toString();

        Assertions.assertEquals(expectedToString, actualToString);

    }
}

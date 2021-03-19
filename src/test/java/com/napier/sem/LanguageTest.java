package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LanguageTest {
    static Language language;

    @BeforeAll
    static void init()
    {
        language = new Language();
        language.setName("English");
        language.setCountryCode("GB");
        language.setOfficial(true);
        language.setPercentage(99);

    }

    @Test
    void testCityToString(){

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
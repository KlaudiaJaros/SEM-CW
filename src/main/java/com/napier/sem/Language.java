package com.napier.sem;

/**
 * Language class to store all information about a language.
 */
public class Language {

    private String name;
    private String countryCode;
    private boolean isOfficial;
    private float percentage;

    /**
     * Returns language name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets language name
     * @param name the name of the language
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns country code
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets country code
     * @param countryCode country code of the country this language is spoken in
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Returns true if the language is official,
     * false if it is not
     * @return isOfficial
     */
    public boolean isOfficial() {
        return isOfficial;
    }

    /**
     * Sets language status (official or not official)
     * @param official boolean if a language is official or not
     */
    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    /**
     * Returns percentage of the population
     * that speaks that language
     * @return percentage
     */
    public float getPercentage() {
        return percentage;
    }

    /**
     * Sets percentage of the population
     * that speaks that language
     * @param percentage percentage of the population that speaks that language
     */
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    /**
     * Returns a String with all language data
     * @return String with all language data
     */
    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                '}';
    }
}

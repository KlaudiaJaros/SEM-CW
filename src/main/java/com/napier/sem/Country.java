package com.napier.sem;


/**
 * Country class to store all information about a country.
 */
public class Country implements Entry{

    private String code;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private int population;
    private int capitalCityID;

    /**
     * Gets a country code.
     * @return country code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the country code
     * @param code string to be set as the country code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the country name.
     * @return country name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the country
     * @param name string to be set as the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the continent of a country
     * @return continent of a country
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Set the continent of a country
     * @param continent string to be set as the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets the region of the country.
     * @return the region of the country
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region of the country
     * @param region string to be set as the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the surface of a country
     * @return surface
     */
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Sets the surface of a country
     * @param surfaceArea double value to be set as the surface
     */
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * Gets the population of a country
     * @return the population of the country
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the population of a country
     * @param population integer to be set as the population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Gets the capital of a country
     * @return country capital
     */
    public int getCapitalCityID() {
        return capitalCityID;
    }

    /**
     * Sets the capital of the country
     * @param capitalCityID string to be set as the capital of a country
     */
    public void setCapitalCityID(int capitalCityID) {
        this.capitalCityID = capitalCityID;
    }

    /**
     * Returns a description of the country object with all its variables
     * A country report requires the following columns:
     *
     * Code.
     * Name.
     * Continent.
     * Region.
     * Population.
     * Capital.
     * @return a String description of the Country object
     */
    @Override
    public String toString() {
        return "Country{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", capitalCityID='" + capitalCityID + '\'' +
                '}';
    }

    /**
     * Formats a String with country data to print as a row in a table
     * @return formatted country String
     */
    @Override
    public String toReportFormat() {
        String capitalName;
        try {
            capitalName = DatabaseConnector.cities.get(capitalCityID).getName();
        }
        catch (Exception capitalCityNullException)
        {
            capitalName = "N/A";
        }
        String formattedCountryString = String.format("%-5s %-50s %-30s %-30s %-15s %-30s",
                code, name, continent, region, population, capitalName);

        return formattedCountryString;
    }
}

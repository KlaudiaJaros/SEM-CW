package com.napier.sem;

/**
 * City class to store all information about a city.
 */
public class City implements Entry {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    /**
     * get the id of the city
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * sets id for the city
     * @param id integer id of the city
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the name of the city
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the city
     * @param name string to be set as the name of the city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the country code of the country the city is in
     * @return country code of the country code city is in
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * sets the country code of the country the city is in
     * @param countryCode string to be set as the country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * gets the district the city is in
     * @return district the city is in
     */
    public String getDistrict() {
        return district;
    }

    /**
     * sets the district name the city is in
     * @param district string to be set as the district the city is in
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * gets population of the city
     * @return population of the city
     */
    public int getPopulation() {
        return population;
    }

    /**
     * sets the population of the city
     * @param population integer to be set as the population of the city
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * returns string description of the city
     * @return string description of the city
     */
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }

    /**
     *
     * formats a string report to print a table row
     * @return formatted city string
     */
    @Override
    public String toReportFormat(){
        String formattedCityString;
        String countryName;
        try {
            countryName = DatabaseConnector.countries.get(countryCode).getName();
        }
        catch (Exception capitalCityNullException)
        {
            countryName = "N/A";
        }

        if (district == null){
            formattedCityString = String.format("%-40s %-50s %-15s", name, countryName, population);
        } else {
            formattedCityString = String.format("%-40s %-50s %-25s %-15s", name, countryName, district, population);
        }

        return formattedCityString;
    }
}

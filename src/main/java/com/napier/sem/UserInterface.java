package com.napier.sem;

import java.util.Scanner;

/**
 * A Text User Interface class to allow user to generate various reports
 */
public class UserInterface {

    private int userInputN = -1; // user input for 'N country reports'
    private String userInputString = ""; // user input for any String user needs to specify
    private int selection = -1; // user input for menu selection
    private Reports reports = new Reports();


    /**
     * A method to start the user interface
     */
    public void start() {
        displayReportTypes();
    }

    /**
     * Displays all possible report types
     * and gets user input to show the next menu
     */
    private void displayReportTypes() {

        // Display report types on the console
        System.out.println("REPORT TYPES\n" +
                            "1. Country reports\n" +
                            "2. City reports\n" +
                            "3. Capital city reports\n" +
                            "4. Population reports\n" +
                            "5. Language reports\n");

        // null user input
        int selection = -1;

        // Wait for correct input
        while (selection < 1 || selection > 5) {
            // get user input (int only)
            System.out.println("Select a menu item");
            selection = getUserInputNumber();

            System.out.println("Selection is :" + selection);
            switch (selection) {
                case 1:
                    displayCountryReportTypes();
                    break;
                case 2:
                    displayCityReportTypes();
                    break;
                case 3:
                    displayCapitalCityReportTypes();
                    break;
                case 4:
                    displayPopulationReportTypes();
                    break;
                case 5:
                    displayLanguageReportTypes();
                    break;
                default:
                    System.out.println("Invalid input, please enter a value 1-5" );
            }
        }
    }
    /**
     * Displays all possible country report types
     * and gets user input to show the next menu
     */
    private void displayCountryReportTypes() {
        // Display country report types on the console
        System.out.println("COUNTRY REPORT TYPES\n" +
                "1. List ALL the countries in the WORLD (largest population to smallest)\n" +
                "2. List ALL the countries in a specified CONTINENT (largest population to smallest)\n" +
                "3. List ALL the countries in a specified REGION (largest population to smallest)\n" +
                "4. List the TOP N populated countries in the WORLD\n" +
                "5. List the TOP N populated countries in a specified REGION\n" +
                "6. List the TOP N populated countries in a specified CONTINENT\n" +
                "0. Go back\n");

        // null user input
        selection = -1;

        // Wait for correct input
        while (selection < 0 || selection > 6) {
            // get user input (int only)
            selection = getUserInputNumber();
            switch (selection) {
                case 0: // go back to report types
                    displayReportTypes();
                    break;
                case 1:
                    // List ALL the countries in the WORLD (largest population to smallest)
                    reports.getCountriesByPopulation(null, null, 0);
                    break;
                case 2:
                    // List ALL the countries in a specified CONTINENT (largest population to smallest)
                    displaySpecifyContinent();
                    userInputString = getUserInputString(); // continent
                    reports.getCountriesByPopulation(userInputString, null, 0);
                    break;
                case 3:
                    // List ALL the countries in a specified REGION (largest population to smallest)
                    displaySpecifyRegion();
                   userInputString = getUserInputString(); // region
                    reports.getCountriesByPopulation(null, userInputString, 0);
                    break;
                case 4:
                    //  List the TOP N populated countries in the WORLD
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    reports.getCountriesByPopulation(null, null, userInputN);
                    break;
                case 5:
                    // List the TOP N populated countries in a specified REGION
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    displaySpecifyRegion();
                    userInputString = getUserInputString(); // region
                    reports.getCountriesByPopulation(null, userInputString, userInputN);
                    break;
                case 6:
                    // List the TOP N populated countries in a specified CONTINENT
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    displaySpecifyContinent();
                    userInputString = getUserInputString(); // continent
                    reports.getCountriesByPopulation(userInputString, null, userInputN);
                    break;
                default:
                    System.out.println("Invalid input, please enter a value 0-6" );
            }
        }
    }
    /**
     * Displays all possible city report types
     * and gets user input to show the next menu
     */
    private void displayCityReportTypes() {
        // Display city report types on the console
        System.out.println("CITY REPORT TYPES\n" +
                "1. List ALL the cities in the WORLD (largest population to smallest)\n" +
                "2. List ALL the cities in a specified CONTINENT (largest population to smallest)\n" +
                "3. List ALL the cities in a specified REGION (largest population to smallest)\n" +
                "4. List ALL the cities in a specified COUNTRY (largest population to smallest)\n" +
                "5. List ALL the cities in a specified DISTRICT (largest population to smallest)\n" +
                "6. List the TOP N populated cities in the WORLD\n" +
                "7. List the TOP N populated cities in a specified REGION\n" +
                "8. List the TOP N populated cities in a specified CONTINENT\n" +
                "9. List the TOP N populated cities in a specified COUNTRY\n" +
                "10. List the TOP N populated cities in a specified DISTRICT\n" +
                "0. Go back\n");

        // null user input
        selection = -1;

        // Wait for correct input
        while (selection < 0 || selection > 10) {
            // get user input (int only)
          //  selection = getUserInputNumber();
            switch (selection) {
                case 0: // go back to report types
                    displayReportTypes();
                    break;
                case 1:
                    // List ALL the cities in the WORLD (largest population to smallest)
                    break;
                case 2:
                    // List ALL the cities in a specified CONTINENT (largest population to smallest)
                    displaySpecifyContinent();
                    userInputString = getUserInputString(); // continent
                    //reports.getCitiesByPopulation(userInputString, null, null, null, 0);
                    break;
                case 3:
                    // List ALL the cities in a specified REGION (largest population to smallest)
                    displaySpecifyRegion();
                    userInputString = getUserInputString(); // region
                    //reports.getCitiesByPopulation(null, userInputString, null, null, 0);
                    break;
                case 4:
                    //  List ALL the cities in a specified COUNTRY (largest population to smallest)
                    displaySpecifyCountry();
                    userInputString = getUserInputString(); // country
                    //reports.getCitiesByPopulation(null, null, null, userInputString, 0);
                    break;
                case 5:
                    // List ALL the cities in a specified DISTRICT (largest population to smallest)
                    displaySpecifyDistrict();
                    userInputString = getUserInputString(); // district
                    //reports.getCitiesByPopulation(null, null, userInputString, null, 0);
                    break;
                case 6:
                    // List the TOP N populated cities in the WORLD
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    //reports.getCitiesByPopulation(null, null, null, null, userInputN);
                    break;
                case 7:
                    // List the TOP N populated cities in a specified REGION
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    displaySpecifyRegion();
                    userInputString = getUserInputString(); // region
                    //reports.getCitiesByPopulation(null, userInputString, null, null, userInputN);
                    break;
                case 8:
                    // List the TOP N populated cities in a specified CONTINENT
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    displaySpecifyContinent();
                    userInputString = getUserInputString(); // continent
                    //reports.getCitiesByPopulation(userInputString, null, null, null, userInputN);
                    break;
                case 9:
                    // List the TOP N populated cities in a specified COUNTRY
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    displaySpecifyCountry();
                    userInputString = getUserInputString(); // country
                    //reports.getCitiesByPopulation(null, null, null, userInputString, userInputN);
                    break;
                case 10:
                    // List the TOP N populated cities in a specified DISTRICT
                    displaySpecifyN();
                    userInputN = getUserInputNumber(); // N
                    displaySpecifyDistrict();
                    userInputString = getUserInputString(); // district
                    //reports.getCitiesByPopulation(null, null, userInputString, null, userInputN);
                    break;
                default:
                    System.out.println("Invalid input, please enter a value 0-10" );
            }
        }
    }

    /**
     * Displays all possible capital city report types
     * and gets user input to show the next menu
     */
        private void displayCapitalCityReportTypes() {
        // Display capital city report types on the console
        System.out.println("CAPITAL CITY REPORT TYPES\n" +
                "1. List ALL the capital cities in the WORLD (largest population to smallest)\n" +
                "2. List ALL the capital cities in a specified CONTINENT (largest population to smallest)\n" +
                "3. List ALL the capital cities in a specified REGION (largest population to smallest)\n" +
                "4. List the TOP N populated capital cities in the WORLD\n" +
                "5. List the TOP N populated capital cities in a specified REGION\n" +
                "6. List the TOP N populated capital cities in a specified CONTINENT\n" +
                "0. Go back\n");

        // null user input
        selection = -1;

        // Wait for correct input
        while (selection < 0 || selection > 6) {
            // get user input (int only)
            //selection = getUserInputNumber();
            switch (selection) {
                case 0: // go back to report types
                    displayReportTypes();
                    break;
                case 1:
                    // List ALL the capital cities in the WORLD (largest population to smallest)
                    break;
                case 2:
                    // List ALL the capital cities in a specified CONTINENT (largest population to smallest)
                    break;
                case 3:
                    // List ALL the capital cities in a specified REGION (largest population to smallest)
                    break;
                case 4:
                    // List the TOP N populated capital cities in the WORLD
                    break;
                case 5:
                    // List the TOP N populated capital cities in a specified REGION
                    break;
                case 6:
                    // List the TOP N populated capital cities in a specified CONTINENT
                    break;
                default:
                    System.out.println("Invalid input, please enter a value 0-6" );
            }
        }
    }
    /**
     * Displays all possible population report types
     * and gets user input to show the next menu
     */
    private void displayPopulationReportTypes() {
        // Display population report types on the console
        System.out.println("POPULATION REPORT TYPES\n" +
                "1. Generate a report on the population of people, people living in cities, and people not living in cities in each CONTINENT\n" +
                "2. Generate a report on the population of people, people living in cities, and people not living in cities in each REGION\n" +
                "3. Generate a report on the population of people, people living in cities, and people not living in cities in each COUNTRY\n" +
                "4. View the population of the WORLD\n" +
                "5. View the population of a CONTINENT\n" +
                "6. View the population of a REGION\n" +
                "7. View the population of a COUNTRY\n" +
                "8. View the population of a DISTRICT\n" +
                "9. View the population of a CITY\n" +
                "0. Go back\n");

        // null user input
        selection = -1;

        // Wait for correct input
        while (selection < 0 || selection > 9) {
            // get user input (int only)
           // selection = getUserInputNumber();
            switch (selection) {
                case 0: // go back to report types
                    displayReportTypes();
                    break;
                case 1:
                    // Generate a report on the population of people, people living in cities, and people not living in cities in each CONTINENT
                    break;
                case 2:
                    // Generate a report on the population of people, people living in cities, and people not living in cities in each REGION
                    break;
                case 3:
                    // Generate a report on the population of people, people living in cities, and people not living in cities in each COUNTRY
                    break;
                case 4:
                    // View the population of the WORLD
                    break;
                case 5:
                    // View the population of a CONTINENT
                    break;
                case 6:
                    // View the population of a REGION
                    break;
                case 7:
                    // View the population of a COUNTRY
                    break;
                case 8:
                    // View the population of a DISTRICT
                    break;
                case 9:
                    // View the population of a CITY
                    break;
                default:
                    System.out.println("Invalid input, please enter a value 0-6" );
            }
        }
    }
    /**
     * Displays all possible language report types
     * and gets user input to show the next menu
     */
    private void displayLanguageReportTypes() {
        // Display language report types on the console
        System.out.println("LANGUAGE REPORT TYPES\n" +
                "1. View the number of people and the percentage of the world population who speak Chinese, English, Hindi, Spanish and Arabic (largest to smallest)\n" +
                "0. Go back\n");

        // null user input
        selection = -1;

        // Wait for correct input
        while (selection < 0 || selection > 1) {
            // get user input (int only)
            //selection = getUserInputNumber();
            switch (selection) {
                case 0: // go back to report types
                    displayReportTypes();
                    break;
                case 1:
                    // View the number of people and the percentage of the world population who speak Chinese, English, Hindi, Spanish and Arabic (largest to smallest)
                    break;
                default:
                    System.out.println("Invalid input, please enter a value 0-1" );
            }
        }
    }
    /**
     * Displays a message to specify a continent
     */
    private void displaySpecifyContinent() {
        System.out.print("Please specify the continent: ");
    }
    /**
     * Displays a message to specify a region
     */
    private void displaySpecifyRegion() {
        System.out.print("Please specify the region: ");
    }
    /**
     * Displays a message to specify a country
     */
    private void displaySpecifyCountry() {
        System.out.print("Please specify the country: ");
    }
    /**
     * Displays a message to specify a district
     */
    private void displaySpecifyDistrict() {
        System.out.print("Please specify the district: ");
    }
    /**
     * Displays a message to specify a city
     */
    private void displaySpecifyCity() {
        System.out.print("Please specify the city: ");
    }
    /**
     * Displays a message to specify a N
     */
    private void displaySpecifyN() {
        System.out.print("Please specify N: ");
    }

    /**
     * Gets a number from the user
     * @return user's input number
     */
    private int getUserInputNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * Gets a string from the user
     * @return user's input String
     */
    private String getUserInputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

}

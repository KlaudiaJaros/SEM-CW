## USE CASE 2: Generate reports on city populations

| USE CASE 2 | CHARACTERISTIC INFORMATION |   
| --------------- | ------------ | 
| Goal in context | As a statistician working at United Nations, I want to generate reports on population of cities so that I can use it as evidence to support decision making for promoting the safe, secure and peaceful use of nuclear technologies.             |
| Scope           | United Nations            |
| Preconditions | Database contains current world population data. For the top N populated cities reports, we know the N. For the report that lists cities in a region/continent/country/district, we know the region/continent/country/district. |
| Success End Condition | The generated report is available for the statistician to create requested graphs and share all data with the International Atomic Energy Agency (IAEA) to support decision making.  |
| Failed End Condition | No report is produced. |
| Primary Actor | UN statistician  |
| Trigger         | A request for latest information and graphs on cities and their population is sent to the statistics team. |
| MAIN SUCCESS SCENARIO | Step / Action <br>1. Statistics team receives a request to collect and share data on city population. <br> 2. A statistician captures required information (if needed, example: region/continent/country/district/N) <br> 3. A statistician extracts relevant city information. <br> 4. A statistician uses the report to create requested graphs. <br> 5. A statistician forwards the reports and graphs for the IAEA to use. |
| EXTENSIONS  | None. |
| SUB-VARIATIONS | Step / Action <br> 2. A statistician may want to: <br> - List all the cities in the world (largest population to smallest) <br> - List all the cities in a specified continent (largest population to smallest) <br> - List all the cities in a specified region (largest population to smallest) <br> - List all the cities in a specified country (largest population to smallest) <br> - List all the cities in a specified district (largest population to smallest) <br> - List only the top N populated cities in the world where N is provided by the user <br> - List only the top N populated cities in a specified continent where N is provided by the user <br> - List only the top N populated cities in a specified region where N is provided by the user <br> - List only the top N populated cities in a specified country where N is provided by the user <br> - List only the top N populated cities in a specified district where N is provided by the user |
| SCHEDULE | Due date: Release 1.0 | 
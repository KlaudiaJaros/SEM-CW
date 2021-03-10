## USE CASE 1: Generate reports on country populations

| USE CASE 1 | CHARACTERISTIC INFORMATION |   
| --------------- | ------------ | 
| Goal in context | As a statistician working at United Nations, I want to generate reports on population of each country so that I can update the population publications on our website to share our data and findings.             |
| Scope           | United Nations            |
| Preconditions | Database contains current world population data. For the top N populated countries reports, we know the N. For the report that lists countries in a region/continent, we know the region/continent. |
| Success End Condition | The generated report is available to the statistician to write a publication on the UN website.   |
| Failed End Condition | No report is produced. |
| Primary Actor | UN statistician  |
| Trigger         | A request for a website update using the latest data is sent to the statistics team. |
| MAIN SUCCESS SCENARIO | Step / Action <br>1. Statistics team receives a request to update the website publication. <br> 2. A statistician captures required information (if needed, example: region/continent/N) <br> 3. A statistician extracts relevant country information. <br> 4. A statistician uses the report to update the publication. |
| EXTENSIONS  | None. |
| SUB-VARIATIONS | Step / Action <br>2. A statistician may want to: <br> - List all the countries in the world (largest population to smallest) <br> - List all the countries in a specified continent (largest population to smallest) <br> - List all the countries in a specified region (largest population to smallest) <br> - Generate a report of the top N populated countries in the world <br> - Generate a report on the top N populated countries in a specified region <br> - Generate a report of the top N populated countries in a specified continent |
| SCHEDULE | Due date: Release 1.0 |
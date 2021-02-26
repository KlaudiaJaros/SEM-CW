## USE CASE 3: Generate reports on country populations

| USE CASE 3 | CHARACTERISTIC INFORMATION |   
| --------------- | ------------ | 
| Goal in context | As a statistician working at United Nations, I want to generate reports on capital cities population so that I can provide updated and comprehensive estimates and projections of the urban and rural populations of all countries to track the rate of urbanization in capital cities.             |
| Scope           | United Nations            |
| Preconditions | Database contains current world population data. We know continent/region. For top N populated capital cities reports, we know N.   |
| Success End Condition | The generated report is available for the statistician to use to track urbanization rates in capital cities. |
| Failed End Condition | No report is produced. |
| Primary Actor | UN statistician  |
| Trigger         | A request for urbanisation rates on a country's capital city is sent to the statistics team to be used on a new project. |
| MAIN SUCCESS SCENARIO | Step / Action <br>1. Statistics team receives a request to provide information to the project planning team. <br> 2. A statistician captures required information (if needed, example: region/continent/N) <br> 3. A statistician extracts relevant capital cities information. <br> 4. A statistician uses report to track urbanisation in capital cities. <br> 5. The report is provided to the project planners to be used in planning the new project to cope with urbanisation in capital cities. |
| EXTENSIONS  | None. |
| SUB-VARIATIONS | Step / Action <br>2. A statistician may want to: <br> - List all the capital cities in the world (largest population to smallest) <br> - List all the capital cities in a specified continent (largest population to smallest) <br> - List all the capital cities in a specified region (largest population to smallest) <br> - Generate a report of the top N populated capital cities in the world <br> - Generate a report on the top N populated capital cities in a specified region <br> - Generate a report of the top N populated capital cities in a specified continent |
| SCHEDULE | Due date: Release 1.0 |
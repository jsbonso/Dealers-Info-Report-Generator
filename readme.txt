======================================
Car's Guide Dealers Report Generator
======================================
Author: Jon Bonso


Assume the following scenario:

Car listings on the website belong to dealerships. Listings are not shared between dealers.
Dealers can be set up in a multi­level hierarchy. A dealership can have child accounts and/or a
parent. But not all dealers have a parent.
Every time a listing is viewed, a pageview event is tracked and stored with a timestamp. These
individual events are later aggregated and stored by day.

Task:

For each dealer print out a list of of its inventory (listings). Summarise the data per listing and per
month and print out the last day of the month as date in the summary.

For each parent dealer print out a summary of all its child dealers containing the id of the child
dealer, the last day of the month and the total number of pageviews of all the child's inventory.
The absolute path and name of the input file is passed as parameter to the main method as only
argument.

The program is expected to produce two output files: one for the monthly dealer totals and one for
the monthly parent dealer totals.

Sample Input:

dealer_id,parent_dealer_id,listing_id,event_date,pageviews
00001,01000,100,2015­01­01,2
00001,01000,101,2015­01­01,4
00001,01000,102,2015­01­01,7
00001,01000,100,2015­01­02,5
00001,01000,101,2015­01­02,1
00001,01000,102,2015­01­02,0
00002,null,200,2015­01­01,10


Sample Output:

dealer_id,listing_id,date,sum_pageviews
00001,100,2015­01­31,7
00001,101,2015­01­31,5
00001,102,2015­01­31,7
00002,200,2015­01­31,10


dealer_id,child_dealer_id,date,sum_pageviews
01000,00001,2015­01­31,19


Steps to run:

1. Do a [mvn package] to generate the Executable Jar file.
2. Go to the /target folder.
3. Run this command in the console: 
	java -jar DealersInfoReportGenerator-jar-with-dependencies.jar
	
4. Enter the full path and filename of the Input CSV file.
5. The program will generate 2 output files:
	a. Monthly Dealer Totals Report.csv 
	b. Monthly Parent Dealer Totals Report.csv


 Notes: 

 - The Log File is: DealersInfoReportGenerator.log
 - This Application is using Log4j 1.2.17 for logging. 
 

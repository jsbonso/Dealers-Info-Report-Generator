======================================
Car's Guide Dealers Report Generator
======================================

Author: Jon Bonso

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
 
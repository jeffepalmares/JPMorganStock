# JPMorgan - Exercise
This project was created to attend the JPMorgan Excise application.

#Functional Requirements

1. The Global Beverage Corporation Exchange is a new stock market trading in drinks companies.

	a. Your company is building the object-oriented system to run that trading.

	b. You have been assigned to build part of the core object model for a limited phase 1

2. Provide the source code for an application that will:-

		a. For a given stock,

			i. Given any price as input, calculate the dividend yield

			ii. Given any price as input, calculate the P/E Ratio

			iii. Record a trade, with timestamp, quantity, buy or sell indicator and price

			iv. Calculate Volume Weighted Stock Price based on trades in past 5 minutes

		b. Calculate the GBCE All Share Index using the geometric mean of the Volume Weighted Stock Price for all stocks

#Requirements to run the prject

For this project you will need:

	- Maven
	- Java 1.8
		

#Running the Project
Download the project by git clone ($ git clone https://github.com/jeffepalmares/JPMorganStock.git ) or zip download
then go into the project folder and run the commands:

	$ mvn package
	$ cd target
	$ java -jar JPMorganStock-1.0.jar
	
After run the lines above youl will see on console the sample program execution so you can access the link http://localhost:8080/swagger-ui.html to check the web rest api documentation. The same link allow you to execute request to check the functionalities.

	
	
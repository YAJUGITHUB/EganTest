# EganTest
Application.java - SpringBoot Test Class is at the root of the package.


DataBase
   SensorEmul
Collection Name 
    person  - This will have entry only first time.
	metrices  - Every time we get a new request with new weight , 
				it checks if the records exists in Person, if not store in Person and then metrices. If it exits in Person , store in metrices.
				At the same time it fires two rules on weight if the weight is underwight or overweight , it stores in DB.
    alerts    - Stores the alert as per of the rule failure.


Classes

com.egan.test.rcontrollers

     AlertDetailController.java
     MetricesDetailController.java

com.egan.test.mongoDB.connection 
     MongoDBConnection.java  -- Gives the unique connection.
	 
com.egan.test.repository 
     AlertRepository.java
	 MetricesRepository.java
	 AlertRepositoryImpl.java
	 MetricesRepositoryImpl.java
	 
com.egan.test.rules
    OverWeightRule.java
	UnderWeightRule.java
	
com.egan.test.vo
    AlertDetail.java  -- Alert Data
	AllDetails.java   -- All the data sent by the use.
	MetricesDetails.java
	PersonDetails.java   -- Person name, id etc.
	
com.egan.test
    AbstractTest.java
	AlertContrallerTest.java
	MetricesControllerTest.java
   


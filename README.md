
todo 

postman koleksiyon - OK 
bean validation - OK
loglama - OK
swagger- OK
readme-OK
exception handling- OK
GitHub - OK
thread safe-OK
collection- OK
unit test- 
Design pattern



# Garage API To Park Vehicles Without Human Intervention

This project provides to park vehicles by size and gives ticket for customers and any given time they can leave with ticket.

### Summary

The assessment consists of an API to be used for parking vehicles by their size.
The garage have 10 slots. Each slot is 1 unit range.


The system gives a unique ticket issued to the driver.  
The ticket includes these informations ; the plate and the colour of the car and allocating an available slots to the car .
 
A vehicle holds number of slots with its own width, you have to leave 1 unit slot to next one. 
The customer should be allocated slot(s) which is nearest to the entry. 
At the exit the customer returns the ticket which then marks slot(s) they were using as being available.
 
 


### Tech Stack

	- Java 8
	- Spring Boot
	- Restful API
	- OpenAPI documentation
	- JUnit
	- Lombok
 
----

## Running the application locally

For building and running the application you need:

- Java 8
- Maven
 
```ssh
$ cd springboot-garage 	#To change directory to project 
$ mvn clean install		#To clean project & install dependency
$ mvn spring-boot:run  	#To run the app
$ mvn package 				#To compile (also runs unit tests)
```

----

## API

The application has 1 API and 3 REST services

```html
POST /api/v1/park - parks the vehicle and gives ticket to the customer
POST /api/v1/leave - takes out the vehicle by ticket
GET /api/v1/status' - retrieves garage status
```
You can check the API documentation by swagger

	`http://localhost:8085/swagger-ui.html`


If you want to call services you can import postman collection.

You can find app logs in {project_folder}/logs/garage.log

## Resources

	`https://funofprograming.wordpress.com/2016/09/29/java-enum-validator`
	
	`https://regex101.com`

 
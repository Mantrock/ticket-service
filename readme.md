# Ticket Service
This project is for Walmart's Ticket Service Coding Challenge. 

It implements a simple ticket service that facilitates the discovery, temporary hold, and final reservation of seats within a high-demand performance venue.

The Ticket Service had to provide the following functions: 
 - Find the number of  seats available within the venue.
 - Find and hold the best available seats on behalf of a customer.
 - Reserve and commit a specific group of held  seats for a  customer. 

## Implementation
I utilized spring boot to quickly stand up a self contained project. 
It provided most of the configuration, packaging help, rest endpoint support, scheduled tasks, test support, and an in memory database.
The endpoints are documented and exposed via a swagger page that allowed for manually testing and user verification.

### Assumptions

The data is structured in a single table that is created at startup by the schema.sql and is first populated by the data.sql. 

Each seat (or ticket) in the venue is assumed to have a: 
 - rank, where the lower the number the better the seat
 - status of Reserved, Held, or Free

They can have a:
 - hold ID, a confirmation number of the hold
 - customer email, the email of the customer that is holding or reserving the seat
 - last updated time, used to time when holds expire
 

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Have the following software installed on your local machine.

```
Java - https://www.java.com/en/download/help/download_options.xml
Maven - https://maven.apache.org/install.html
Git - https://git-scm.com/book/en/v2/Getting-Started-Installing-Git 
```

### Installing

First download from Git. Then build the package with Maven. 

```
mvn package
```

Once built run the jar. 

```
java  -jar target/ticket.service.coding.challenge-1.0-SNAPSHOT.jar
```

The methods are exposed as rest endpoints and a Swagger page will be created for interacting with the system. Try holding some tickets!

```
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html#/
```

There is a scheduled job that run every 5 seconds that clears any holds that have lasted longer than 30 seconds. The output of that job is displayed on the console. 

## Running the tests

The tests will run with each build and can be trigger via command line.

```
mvn test
```

### Automated tests

The automated tests utilize spring to mock the endpoints and verify the proper status code is returned. 
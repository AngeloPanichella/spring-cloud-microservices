# Example of microservices using Spring Cloud, Eureka and Zuul.

## Technologies

The services are written in Java and use the following technologies.

* Spring Boot
* Spring Cloud
* Spring Netflix

## Docker Container

There is a Maven goal to generate the Docker container.

## Building

To build the source you will need to install JDK 1.8.

----
$ mvn clean install
----

## Testing (gatling-tool)

There is a module to test the expected output.

----
$ cd gatling-test
$ mvn gatling:execute -Dgatling.simulationClass=companytest.CompanySimulation
----

## Swagger Documentation

----
http://localhost:8765/swagger-ui.html#/
----

## Example of running microservice

----
$ ./authentication-service$ java -jar target/authentication-service.jar
----

## First microservices to be launched

----
discovery-service
gateway-service
----

Once these microservices have been launched, all the others can be run
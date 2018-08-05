# Example of microservices using Spring Cloud, Eureka and Zuul.

## Technologies

The services are written in Java and use the following technologies.

* Spring Boot
* Spring Cloud
* Spring Netflix

### Docker Container

There is a Maven goal to generate the Docker container.

* `docker-compose up`

docker-compose version (1.11.1)

### Building

To build the source you will need to install JDK 1.8.

* `mvn clean install`

### Testing (gatling-tool)

There is a module to test the expected output.

* cd gatling-test
* `mvn gatling:execute -Dgatling.simulationClass=companytest.CompanySimulation`

### Spring Eureka Server

http://localhost:8761

### Swagger Documentation

http://localhost:8765/swagger-ui.html#/

### Authentication

The authentication is based on oauth2.

You can skip Docker goals bound to Maven phases with:

* `-DskipDockerBuild` to skip image build
* `-DskipDockerTag` to skip image tag
* `-DskipDockerPush` to skip image push
* `-DskipDocker` to skip any Docker goals
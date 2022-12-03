# Global Optima - Delivery microservice
### Goals
- CRUD operations on the DeliveryPerson entity
- Accept requests for order delivery
- Create reviews for customers (optional)

### Requirements
- Java openjdk-19.0.1
- Maven 3.8.6

Check the correct versions with `mvn --version`

### How to run
- build the project `mvn clean package`
- run locally `java -jar target/delivery-server-1.0-SNAPSHOT.jar`  
  Service can be accessed via [http://localhost:8080/v1/delivery/people](http://localhost:8080/v1/delivery/people)


# Global Optima - Delivery microservice
### Goals
- CRUD operations on the DeliveryPerson entity
- Accept requests for order delivery
- Create reviews for customers (optional)

---

### Requirements
- Java openjdk-19.0.1
- Maven 3.8.6
- Running postgres server on localhost  
  `docker run -d --name pg-delivery -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=delivery -p 5433:5432 postgres:15.1`


Check the correct versions with `mvn --version`

### How to run
- build the project `mvn clean package`
- run locally `java -jar target/delivery-server-1.0-SNAPSHOT.jar`  
  Service can be accessed via [http://localhost:8081/v1/delivery/people](http://localhost:8081/v1/delivery/people)


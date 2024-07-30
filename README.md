# The Examination is a project where I developed by the Uncle bob clean architecture.
## I use these libraries:

- Java 21
- Spring boot 3.3.2
   - Spring MVC
   - Spring Data (Querydsl, JpaSpecificationExecutor, QueryByExample, PagingAndSorting)
   - Spring Security for Audit
- JPA/Hibernate
- Lombok
- Vavr
- DataFaker
- Liquidbase
- MapStruct
- OpenAPI V.3
- JUnit 5
  - Mockito 
* The CI/CD is being done by Github Actions, a docker image is sent to my docker hub public repository, you can pull the image by this command: 
  * docker pull marcelin8032/examination

* The OpenAPI URL is: http://localhost:8090/swagger-ui/index.html#/

* The data model of the examination project: 

![alt text](https://github.com/marcelin-8032/Examination-Spring-project/blob/master/class-Diagram.png)

* Database is created both for Postgresql or H2
* How to run
  * mvn clean install
  * mvn spring-boot:run

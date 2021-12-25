
### How to Run this Service

------------------------
1. Clone this repository into you local workspace
2. `cd restful-web-services`
3. Execute `mvn spring-boot:run`
4. This application should be accessible using the local host on port 8080
   * API URL: http://localhost:8080/users
   * Actuator: http://localhost:8080/actuator
   * Swagger UI: http://localhost:8080/swagger-ui/index.htm
   
--------------------------
### H2 in-memory DB access

---------------------------
* http://localhost:8080/h2-console
* Make sure the JDBC URL is set to `jdbc:h2:mem:testdb`
    
-------
##### Note: If you get an error port 8080 is already in use or bound, try killing the process using port 8080 using one of the below commands
* `sudo lsof -i :8080` and then `kill -9 <process-id>`
* `npx kill-port 8080`
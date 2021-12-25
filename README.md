
### How to Run this Service

------------------------
1. Clone this repository into you local workspace
2. `cd restful-web-services`
3. Execute `mvn spring-boot:run`
4. This application should be accessible using the local host on port 8080
    * http://localhost:8080/users
    
-------
##### Note: If you get an error port 8080 is already in use or bound, try killing the process using port 8080 using one of the below commands
* `sudo lsof -i :8080`
* `npx kill-port 8080`
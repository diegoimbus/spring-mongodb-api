# Spring Boot MongoDB API RESTful
API RESTful to management of fixed assets 
### How to excecute
It is necessary to have installed Java 8 or newer version, also Maven rooted in the PATH
```
mvn spring-boot:run
Acesse http://localhost:8080/api/assets
Use user "user" and the password showed in terminal for auth.
```
### APIs endpoints
GET http://localhost:8080/api/assets  [show all the assets]

POST http://localhost:8080/api/assets [create a new asset]  

PATCH http://localhost:8080/api/assets/{id} [modify 2 parameters by ID]
### Running on Eclipse or STS
Run in terminal:
```
mvn eclipse:eclipse
```
Or just import the project in STS.

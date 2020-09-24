# EmployeeWebApp

## Introduction

This is a web app to manage Employee.<br>
You can create,read,delete and update employees.
The application is composed by two modules:

- PersonaleWebService (RestFul API)
- SpringBootAngularJs (Front-End Application)

---
## Technologies used:
- Spring MVC <img src="https://github.com/diegoDeveloper00/EmployeeWebApp/blob/master/spring-logo.png" width="20" height="20">
   - Spring Data 
    - Spring Security
     - JWT(Json Web Token)
- Angular Js <img src="https://github.com/diegoDeveloper00/EmployeeWebApp/blob/master/angular-logo.png" width="20" height="20">
  - Controller
   - Service
---

## Project Structure

- PersonaleWebService 
  - src/main/java classes for RestFul API and Jwt implementation
  - src/main/resources/application.properties properties to
connect to the database
- SpringBootAngularJs 
  - src/main/java classes to control html pages
  - src/main/resources
    - static composed by: Js folder, css folder
    - templates composed by html pages

---
## RoadMap

- [x] E/R model creation
- [x] Repository Creation
- [x] Projects Creation
- [x] Database Creation
- [x] RestFul API creation
- [x] Front-End creation
- [x] Base authentication with Spring security
- [x] Base implementation of JWT
- [x] Database authentication
- [ ] Implementing session
- [ ] Manages Roles and Authorization for db user
- [ ] Implementing UIRouting on AngularJs

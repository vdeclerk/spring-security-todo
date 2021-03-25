# spring-boot-todo
## A simple To Do List REST API

A very simple Spring Boot sample app.
A frontend is implemented in [angular-todo]https://github.com/vdeclerk/angular-todo

Uses JPA to connect to a Postgresql database configured with env variables.

- SPRING-BOOT-TODO-DB-URL  - The database URL
- SPRING-BOOT-TODO-DB-USER - The database username
- SPRING-BOOT-TODO-DB-PASS - The database password for this user

By default the database is created and **destroyed** every time the application runs, and a configuration class creates fake tasks to test/showcase the application.

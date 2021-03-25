# spring-boot-todo
## A simple To Do List REST Api

A very simple Spring Boot sample app.

Uses JPA to connect to a Postgresql database configured with env variables.

SPRING-BOOT-TODO-DB-URL  - The database URL
SPRING-BOOT-TODO-DB-USER - The database username
SPRING-BOOT-TODO-DB-PASS - The database password for this user

The database is created and destroyed every time the application runs, and a configuration class creates fake tasks to test/showcase the application.

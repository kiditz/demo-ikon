# Run
* Update database with what u have or just use docker-compose.yml to run postgres in your docker
* use ./gradlew bootRun to run the project
* use ./gradlew test to run unit test
* The test report is using jacoco, so, you know the coverage of AccountCommandService
* At this project i use cqrs for account and just ordinary service for placeholder.
* Also i use package by feature instead of layer package to have High Cohesion 
* See [Package By Layer VS Package By Feature](https://medium.com/@akintopbas96/spring-boot-code-structure-package-by-layer-vs-package-by-feature-5331a0c911fe).
* Caching use caffeine cache, cause it has ttl (Time-To-Live) features instead of just basic spring cache
* I also use mapstruct to simplify mapping cause i wont to expose entity on controller layer, it's not safe
* After the application running you can go to the [swagger](http://localhost:8080/swagger-ui.html) to test the API
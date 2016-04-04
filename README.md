# Spring Boot Sample

A simple RESTful Service using Spring Boot that autoconfigure JAX-RS Beans

- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Spring Actuator](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)

## How to run it?

Use the embedded maven wrapper to package it and run it!

  `./mvnw clean package`

  `./mvnw spring-boot:run` or `java -jar target/*.jar`

Check if everything is ok:
  - `curl http://localhost:8080/api`
  - `curl http://localhost:8080/health`
  - `curl http://localhost:8080/metrics`

### Running on Heroku

Check PORT and PROFILE on [Procfile](Procfile)

  `git remote add heroku -f <openshift-git-repo-url>`

  `git push heroku master`

### Running on Openshift

Check the deploy files
  [deploy](.openshift/action_hooks/deploy)
  [start](.openshift/action_hooks/start)
  [stop](.openshift/action_hooks/stop)

  `git remote add openshift -f <openshift-git-repo-url>`

  `git merge openshift/master -s recursive -X ours`

  `git push openshift master`

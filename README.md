# Spring Boot Sample

A simple RESTful Service using Spring Boot that autoconfigure JAX-RS Beans

- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Spring Actuator](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)

## How to run it?

Clone from git:
```
git clone https://github.com/adolfojunior/spring-boot-demo.git
cd spring-boot-demo
```

Use the embedded maven wrapper to package it and run it!

  `./mvnw clean package`

  `./mvnw spring-boot:run` or `java -jar target/*.jar`

Check if everything is ok: <http://localhost:8080/api>

  - `curl http://localhost:8080/api`
  - `curl http://localhost:8080/health`
  - `curl http://localhost:8080/metrics`
  
App Endpoints:

  - `curl -X GET http://localhost:8080/api/post`
  - `curl -X GET http://localhost:8080/api/post/1`

### Running on Heroku

Check PORT and PROFILE
  - [Procfile](Procfile)

  `git remote add heroku -f <heroku-git-repo-url>`

  `git push heroku master`

### Running on Openshift

Check the deploy files:

  - [.openshift/action_hooks/deploy](.openshift/action_hooks/deploy)
  - [.openshift/action_hooks/start](.openshift/action_hooks/start)
  - [.openshift/action_hooks/stop](.openshift/action_hooks/stop)

  Use the DIY Linux!

  `git remote add openshift -f <openshift-git-repo-url>`

  `git merge openshift/master -s recursive -X ours`

  `git push openshift master`

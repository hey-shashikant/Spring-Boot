# Spring-Boot-3-Spring-6-Hibernate-for-Beginners

## 1. Spring in a Nut Shell
- Very popular framework for building java applications
- Provides a large number of helper classes and annotations

### The Problem
- Build a traditional Spring Application is really HARD!!!
- for examples
    1. which JAR dependencies do i need?
    2. How do i set-up configuration(xml or java)?
    3. How do i install the server? (Tomcat, JBoss, etc)

### Spring Boot Solution
- Make it easier to get started with Spring development
- Minimize the amount of manual configuration, Perform auto-configurations based on props files and JAR classpath
- Help to resolve dependency conflicts(Maven or Gradle)
- Provide an embedded HTTP server so you can get started quickly (Tomcat, Jetty, Undertow,..)

### Spring Boot and Spring

- Spring Boot uses Spring behind the scenes
- Spring Boot simply makes it easier to use Spring

### [Spring Initializr](https://start.spring.io/)
- Quickly create a starter Spring Boot project
- Select your dependency
- Create a Maven/Gradle project
- Import the project into your IDE(Eclipse, Intellij, NetBeans, etc...)

### Spring Boot Embedded Server

- Provides an embedded HTTP server so you can get started quickly(Tomcat, Jetty, Undertow,...)
- No need to install a server seperately

### Running Spring Boot Apps
- Spring Boot apps can be run standalone (includes embedded server)
- Run the spring boot app from the IDE or command-line

### Deploying Spring Boot Apps

- Spring Boot apps can also be deployed in the traditional way.
- Deploy WAR file to an external server. Tomcat, JBoss, WebSphere, etc...

## 2. Spring Boot Initializr Demo

### Quick Word on Maven
- When building your java project, you may need additional JAR files(for example: Spring, Hibernate, Commons Loggin, JOSN, etc..)
- One approach is to download the JAR file from each project website & manually add the JAR file to your classpath/PATH

### Maven Solution
- Tell Maven the projects you are working with(dependencies Spring, Hibernate, etc...)
- Maven will go out and download the jAR files for those projects for you and Maven will make those JAR files available during compiple/runtime.
- Think of Maven as your friendly helper/ personal shopper :-)

## 3. Create a REST Controller

Sample code snippet for basic rest controller which returns "Hello World!"

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that returns "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
}
```

## 4. Spring Framework overview

- Lightweight development with Java POJOs(Plain-Old-Java-Objects)
- Dependency injection to promote loose coupling
- Minimize boilerplate java code

### Various Sections in Spring Framework

- Core Container :- Factory for creating beans, Manage bean dependencies
- Infrastructure :- AOP(Aspect Oriented Programming) Add functionality to objects declaratively Logging, Security, transactions, etc..
- Data Access Layer :- JDBC helper classes Reduce your JDBC code by 50%. Also provides Object to relational mapping Integration with Hibernate and JPA.
- Web Layer :- All web related classes Home of the Spring MVC framework.
- Test Layer :- Supports Test-Driven-Development(TDD) Mock objects and out-of-container testing.

## 5. [Spring Projects](https://spring.io/projects)

- Additional Spring modules build-on top of the core Spring Framework
- Only use what you need...
   1. Spring Cloud, Spring Data, Spring Batch, Spring Security, Spring Web Services, Spring LDAP, etc..

## 6. What is Maven?

- Maven is a Project Management tool
- Most popular use of Maven is for build management and dependencies

### What Problems Does Maven Solve?

- When building your Java Project, you may need additional JAR files for example: Spring, Hibernate, Commons Logging, JSON, etc...
- One approach is to download the JAR files from each project website & Mmanually add the JAR files to your build path/ classpath

### Maven Solution

- Tell Maven the projects you are working with(dependencies) Spring, Hibernate, etc
- Maven will go out and download the JAR files for those projects for you and maven will make those JAR files available during compile/ runtime
- Think of Maven as your friendly helper/ personal shopper :-)

### How Maven works?

- First Maven reads the config file and checks if the Maven local repository does not have those files It will look for those files inside the Maven Central Repository(Remote)
- Then it will save versions of those files in your local repository and then it will use that to build and run.
- Maven also handle JAR dependencies. It will also download the supporting dependencies.

### Maven Directory Structure
<img src="src/webapp/img.png" width="400" height="250">

### Maven key concepts

- POM File (pom.xml) :- Project Object Model file which acts as a shopping list for us.
- It has three parts :-
  1. project meta data :- Project name, version, etc Output file type: JAR, WAR,...
  2. dependencies :- List of projects we depend on Spring, Hibernate, etc...
  3. plugins :- Additional custom tasks to run: generate Junit test reports etc...

### Maven Wrapper files

- mvwn allows you to run a Maven project, No need to have Maven installed or present on your path
- If correct version of Maven is NOT found on your computer it automatically downloads correct version and runs Maven.

## 7. Spring Boot Actuators

### Problem
- How can i monitor and manage my application?
- How can i check the application health?
- How can i access application metrics?

### Solution: Spring Boot Actuators

- Exposes ednpoints to monitor and manage your application
- You easily get Devops functionality out-of-the-box
- Simply add the dependency to your POM file
- REST endpoints are automatically added to your application

### Exposing Endpoints

- By default, only /health is exposed
- The /info endpoint can provide information about your application
- To expose /info

Code Snippet for exposing endpoints
```
management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true
```

### What about Security?

- You may not want to expose all of this information
- Add Spring Security to project and endpoints are secured :-)


### How to add Custom Application Properties

- Define those properties in application.properties file
- use those properties in your application/ controller

Code snippet for Custom Application Properties
```java
    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose a new endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
```

## 8. Inversion of Control(IoC)

It is the approach of outsourcing the construction and management of objects.
We can achieve Inversion of Control through various mechanisms such as: Strategy design pattern, Service Locator pattern, Factory pattern, and Dependency Injection (DI).

### Dependency Injection

- The dependency inversion principle : The client delegates to another object the responsibility of providing its dependencies.
- Dependency Injection (DI) is a design pattern commonly used in software development, and Spring Framework is a popular Java framework that provides comprehensive support for DI. In Spring, DI is primarily implemented through inversion of control (IoC), where the control of object creation and wiring is shifted from the application code to the Spring container.
- There are two types of Injections :-
  1. Constructor Injection - use this when you have required dependencies
  2. Setter Injection - use this when you have optional dependencies

### What is Spring AutoWiring?

- For dependency injection, Spring can use autowiring
- Spring will look for a class that matches and will automatically inject it...hence it is autowired.

### Example Application for Dependency Injection

<img src="src/webapp/img_1.png" width="850" height="180">

### Development Process - Constructor Injection

- Define the dependency interface & class
- Create Demo REST Controller
- Create a constructor in your class for injections
- Add @GetMapping for /dailyworkout

NOTE : When we mark a class with the @Component annotation it marks the class as a Spring Bean and makes it a candidate for dependency injection. Spring Bean is just a regular java class that is managed by Spring

### Component Scanning

- Spring will scan your java classes for special annotations eg. @Component, etc and it will automatically register the beans in the Spring Container.
- Spring Boot does auto scanning for all the packages that fall under the parent package. 
- If you want spring to scan other packages you need to add them.

### Setter Injection
When we inject dependencies by calling setter methods of your class.

### Development Process - Setter Injection

- Create setter method in your class for injections
- Configure the dependency injection with @Autowired Annotation



 




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


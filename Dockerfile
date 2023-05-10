#FROM openjdk:17-jdk-temurin
#ARG JAR_FILE=target/*.jar
#COPY ./target/demo-0.0.1.jar app.jar

#ENTRYPOINT ["java", "jar", "/app.jar"]

FROM eclipse-temurin:17

LABEL mentainer="javaguides.net@gmail.com"

WORKDIR /app

COPY target/springboot-restful-webservices-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]
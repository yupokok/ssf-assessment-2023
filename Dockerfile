FROM maven:3-eclipse-temurin-21 AS builder

WORKDIR /src

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

FROM openjdk:21-jdk-slim

WORKDIR /kimberlywsp

COPY --from=builder /app/target/eventmanagement-0.0.1-SNAPSHOT.jar events.jar 
COPY events.json .
COPY templates templates


ENV SERVER_PORT=8080
ENV SPRING_REDIS_HOST = localhost SPRING_REDIS_PORT = 6379
ENV SPRING_REDIS_PASSWORD = NOT_SET ENV SPRING_REDIS_USERNAME = NOT_SET
EXPOSE ${SERVER_PORT}



ENTRYPOINT ["java", "-jar", "eventmanagement-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-alpine

LABEL authors="liviu"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/*.jar
COPY ./target/RPGCharacterCreation-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "/backend.jar"]
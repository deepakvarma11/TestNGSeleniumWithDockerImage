FROM maven:3.8.4-openjdk-11-slim AS build

COPY src /home/TestNGSelenium/src

COPY pom.xml /home/TestNGSelenium

RUN mvn -f /home/TestNGSelenium/pom.xml clean test -DskipTests=true
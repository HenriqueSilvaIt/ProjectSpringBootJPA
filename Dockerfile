FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
COPY . .

RUN apt-get install maven install -y
RUN mvn clean install

FROM openjdck:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/course.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar /app/examination-docker.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "examination-docker.jar"]
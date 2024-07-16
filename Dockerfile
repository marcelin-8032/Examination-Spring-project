FROM openjdk:17-jdk-slim

WORKDIR /app

ADD /Examination/target/Examination-0.0.1-SNAPSHOT.jar /app/examination-docker.jar

EXPOSE 9090

CMD ["java","-jar", "examination-docker.jar"]
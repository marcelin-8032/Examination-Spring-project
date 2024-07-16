FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /Examination/target/Examination-0.0.1-SNAPSHOT.jar /app

EXPOSE 9090

CMD ["java","-jar", "Examination-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY app/build/lib/* build/lib/

COPY app/build/libs/app.jar build/

WORKDIR /app/build

EXPOSE 9090

ENTRYPOINT java -jar app.jar
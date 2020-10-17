FROM openjdk:11-jdk-buster
LABEL maintainer="Brahim SLITI@eukleia.eu"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "/app.jar"]

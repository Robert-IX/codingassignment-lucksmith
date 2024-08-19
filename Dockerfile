# Use the official Maven image with OpenJDK 8 for building the application
FROM maven:3.8.6-openjdk-8 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and project source files to the working directory
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean package

# Use a lightweight OpenJDK image for running the application
FROM openjdk:8-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the previous build stage to the working directory
COPY --from=build /app/target/codingassignment-lucksmith-0.0.1-SNAPSHOT.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use an official JDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/config-server-0.0.1-SNAPSHOT.jar config-server.jar

# Expose port 8081
EXPOSE 1680

# Run the application
ENTRYPOINT ["java", "-jar", "config-server.jar"]
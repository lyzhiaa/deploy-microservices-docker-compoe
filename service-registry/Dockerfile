# Use an official JDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar

# Expose port
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "service-registry.jar"]
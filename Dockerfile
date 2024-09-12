# Use a multi-stage build to keep the image size smaller

# Stage 1: Build the application
FROM maven:3.9.2-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy the pom.xml and other Maven-related files
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the packaged JAR from the builder stage
COPY --from=builder /app/target/your-app-name.jar ./app.jar

# Expose the port on which the app will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]


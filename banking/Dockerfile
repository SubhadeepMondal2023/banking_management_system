# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first for better Docker layer caching
COPY pom.xml .

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application and create JAR file
RUN mvn clean package -DskipTests

# Verify JAR was created
RUN ls -la target/


# ---------- Runtime Stage ----------
FROM gcr.io/distroless/java21-debian12

# Set working directory
WORKDIR /app

# Copy the JAR file from build stage
COPY --from=build /app/target/banking-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will override with $PORT environment variable)
EXPOSE 8080

# Run the application with optimized JVM settings for containers
ENTRYPOINT ["java", \
    "-Xmx512m", \
    "-XX:+UseContainerSupport", \
    "-XX:MaxRAMPercentage=75.0", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-Dserver.port=${PORT:-8080}", \
    "-jar", "app.jar"]
# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copy pom.xml and download dependencies (caches layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build application
COPY src ./src
RUN mvn clean package -DskipTests


# ---------- Runtime Stage ----------
# Distroless Java 21 for small & secure runtime
FROM gcr.io/distroless/java21-debian12

WORKDIR /app

# Copy only the built JAR
COPY --from=build /app/target/banking-0.0.1-SNAPSHOT.jar app.jar

# Expose default Spring Boot port (Render will override with $PORT)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]

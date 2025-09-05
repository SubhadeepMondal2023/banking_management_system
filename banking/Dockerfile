# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copy pom.xml and download dependencies (caches layer)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build application
COPY src ./src
RUN mvn clean package -DskipTests


# ---------- Runtime Stage ----------
# Use distroless for small & secure runtime image
FROM gcr.io/distroless/java21-debian12

WORKDIR /app

# Copy only the built JAR (no Maven, no src)
COPY --from=build /app/target/banking-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
CMD ["app.jar"]

#FROM eclipse-temurin:17-jdk-alpine
# Stage 1: Build the JAR
FROM maven:3.9.4-eclipse-temurin:17-jdk-jammy AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Stage 2: Copy and run
FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
COPY --from=build /app/target/user-service-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
HEALTHCHECK --interval=30s --timeout=5s CMD curl -f http://localhost:8080/actuator/health || exit 1

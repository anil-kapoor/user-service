FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/user-service-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
HEALTHCHECK --interval=30s --timeout=5s CMD curl -f http://localhost:8080/actuator/health || exit 1

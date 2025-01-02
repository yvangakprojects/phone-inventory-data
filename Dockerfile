
FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app

COPY /build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
# Utilisez une image de base JDK pour construire l'application
FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Utilisez une image de base JRE pour exécuter l'application
FROM openjdk:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/myapp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

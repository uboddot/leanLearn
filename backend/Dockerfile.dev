# build jar
FROM maven:3.9.14-eclipse-temurin-25-alpine AS build
WORKDIR /app
COPY pom.xml ./
COPY .mvn .mvn
COPY src src
RUN mvn -B -DskipTests package

# start application
FROM eclipse-temurin:25
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD [ "java", "-jar", "/app/app.jar" ]
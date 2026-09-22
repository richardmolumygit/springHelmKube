FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /workspace
COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src src

RUN ./mvnw -B -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /workspace/target/demo-*.jar app.jar

ENV SERVER_PORT=9090
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
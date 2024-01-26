FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY pom.xml app/pom.xml
COPY src /app/src
COPY mvnw /app/mvnw

RUN ./mvnw install

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/target/my-app.jar"]
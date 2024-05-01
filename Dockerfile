FROM gradle:7.3.3-jdk17 AS build
COPY . .
RUN ./gradlew build

FROM openjdk:17.0.1-jdk-slim
COPY --from=build build/libs/fuelapi-0.0.1-SNAPSHOT.jar fuelapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fuelapi.jar"]

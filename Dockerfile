FROM gradle:7.3.3-jdk17 AS build
COPY . .
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk17:alpine-jre
COPY --from=build build/libs/fuelapi-0.0.1-SNAPSHOT.jar fuelapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fuelapi.jar"]

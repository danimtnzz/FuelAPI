FROM openjdk:17.0.1-jdk-slim
VOLUME /tmp
COPY build/libs/fuelapi-0.0.1-SNAPSHOT.jar fuelapi.jar
ENTRYPOINT ["java", "-jar", "fuelapi.jar"]
EXPOSE 8080

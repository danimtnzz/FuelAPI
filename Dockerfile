# Usar una imagen base de Java 17
FROM adoptopenjdk/openjdk17:alpine-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR de la aplicación al contenedor
COPY build/libs/fuelapi-0.0.1-SNAPSHOT.jar /app/fuelapi.jar

# Expone el puerto en el que la aplicación debe escuchar en Render
ENV PORT 8080
EXPOSE $PORT

# Comando para ejecutar la aplicación
CMD ["java", "-Dserver.port=${PORT}", "-jar", "fuelapi.jar"]

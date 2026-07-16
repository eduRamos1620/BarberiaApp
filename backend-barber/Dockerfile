# --- Etapa 1: Compilación ---
# Usamos una imagen oficial de Maven con Java 21 para compilar el código
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copiamos el archivo de configuración de dependencias
COPY pom.xml .
# Descargamos las dependencias (se quedan en caché si no cambia el pom.xml)
RUN mvn dependency:go-offline

# Copiamos el código fuente de nuestro backend
COPY src ./src
# Compilamos el proyecto omitiendo los tests para acelerar el proceso
RUN mvn clean package -DskipTests

# --- Etapa 2: Ejecución ---
# Usamos una imagen de Java 21 de solo ejecución (JRE), mucho más ligera y segura
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el archivo .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto estándar en el que corre Spring Boot
EXPOSE 8080

# Comando para arrancar nuestra aplicación de Java
ENTRYPOINT ["java", "-jar", "app.jar"]
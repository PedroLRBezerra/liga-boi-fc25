# Etapa 1: Build usando Maven
FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Rodar a aplicação
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copia o .jar gerado da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

# Copia o .env para dentro da imagem
# COPY .env .env


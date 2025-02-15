# Usando a imagem oficial do Maven para compilar o projeto
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia o código-fonte para o container
COPY . .

# Faz o build do projeto e gera o .jar
RUN mvn clean package -DskipTests

# Usando a imagem do OpenJDK 21
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para o container
# COPY target/*.jar app.jar
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta que a aplicação irá rodar
EXPOSE 5432

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]

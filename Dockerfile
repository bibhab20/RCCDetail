# Stage 1: Build the application
FROM maven:3.8.1-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
RUN ls -l /app/target
RUN echo "Here"
# Stage 2: Run the application
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/RCCDetailing-0.0.1-SNAPSHOT.jar /app/RCCDetailing.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "RCCDetailing.jar"]

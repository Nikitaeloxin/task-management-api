#Maven image for build
FROM jelastic/maven:3.9.5-openjdk-21 as builder

WORKDIR /app

COPY . .

#Build
RUN mvn clean package -DskipTests

#Java 21 image
FROM openjdk:21-jdk

WORKDIR /app

COPY --from=builder /app/target/testtask-0.0.1-SNAPSHOT.jar app.jar

#port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
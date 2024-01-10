#FROM gradle:8.1.1-jdk17 AS BUILD
#FROM eclipse-temurin:8-jdk-jammy AS BUILD
#COPY . .
#RUN gradle build
#
#FROM openjdk:19-jdk
#COPY --from=BUILD build/libs/server-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]

FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

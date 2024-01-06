FROM gradle:8.1.1-jdk17 AS BUILD
COPY . .
RUN gradle build

FROM openjdk:17-alpine
COPY --from=BUILD build/libs/server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","app.jar"]


#RUN apt-get update
#RUN apt-get installl openjdk-17-jdk -y
##VOLUME /tmp
##COPY build/libs/*.jar app.jar
#COPY . .
#RUN ./gradlew bootJar --no-daemon
#
#FROM openjdkL17-jdk-slim
#EXPOSE 3000
#COPY build/libs/server-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java","-jar","app.jar"]

FROM azul/zulu-openjdk:17-latest AS BUILD
RUN apt-get update
RUN apt-get installl openjdk-17-jdk -y
#VOLUME /tmp
#COPY build/libs/*.jar app.jar
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdkL17-jdk-slim
EXPOSE 3000
COPY build/libs/server-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

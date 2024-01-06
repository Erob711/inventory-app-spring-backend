FROM azul/zulu-openjdk:17-latest AS BUILD

#VOLUME /tmp
#COPY build/libs/*.jar app.jar
COPY build/libs/server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]



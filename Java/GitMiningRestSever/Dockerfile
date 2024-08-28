FROM openjdk:17-alpine
VOLUME /tmp
COPY target/*.jar app.jar
COPY *.csv /
ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM eclipse-temurin:19-alpine

COPY target/server-0.0.1-SNAPSHOT.jar app.jar

CMD java -jar app.jar

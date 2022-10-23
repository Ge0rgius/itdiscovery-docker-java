FROM eclipse-temurin:19-alpine

COPY target/client-0.0.1-SNAPSHOT.jar app.jar

CMD java -jar app.jar
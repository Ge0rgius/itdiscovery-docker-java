FROM eclipse-temurin:19-alpine

LABEL Author="Sergiy Morenets"

COPY src/main/java/MainStarter.java /sources/

COPY src/main/resources/mysql-connector-java-8.0.19.jar /sources/

WORKDIR /sources

RUN javac MainStarter.java && rm MainStarter.java

CMD java -classpath .:/sources/mysql-connector-java-8.0.19.jar MainStarter
FROM maven:3-eclipse-temurin-19-alpine as base

COPY pom.xml /opt/
WORKDIR /opt
RUN mvn dependency:resolve

COPY . /opt/
RUN mvn install spring-boot:repackage

FROM eclipse-temurin:19-alpine
COPY --from=base /opt/target/spring-boot-docker.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

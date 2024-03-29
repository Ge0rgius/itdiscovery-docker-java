﻿# syntax=docker/dockerfile:experimental
FROM ghcr.io/graalvm/graalvm-ce:22 as graalvm

RUN gu install native-image

ARG MAVEN_VERSION=3.8.6

ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

COPY pom.xml /opt/
WORKDIR /opt
RUN --mount=type=cache,target=/root/.m2 mvn dependency:resolve

COPY . /opt/
RUN --mount=type=cache,target=/root/.m2 mvn install spring-boot:repackage

FROM scratch

COPY --from=graalvm /opt/target/graalvm /graalvm

ENTRYPOINT ["./graalvm"]
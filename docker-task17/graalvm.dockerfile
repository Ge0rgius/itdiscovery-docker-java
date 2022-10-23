FROM ghcr.io/graalvm/graalvm-ce:22 as graalvm

RUN gu install native-image

COPY src/main/java/HelloWorld.java /sources/

WORKDIR /sources

RUN javac HelloWorld.java

RUN native-image --static HelloWorld

FROM scratch

COPY --from=graalvm /sources/helloworld /helloworld

ENTRYPOINT ["./helloworld"]

FROM ghcr.io/graalvm/graalvm-ce:22 as graalvm

RUN gu install native-image

COPY src/main/java/HelloWorld.java /sources/

WORKDIR /sources

RUN javac HelloWorld.java

RUN native-image --static HelloWorld

FROM ubuntu as upx

RUN apt-get update && apt-get install -y upx

COPY --from=graalvm /sources/helloworld /helloworld

RUN upx --lzma /helloworld

FROM scratch

COPY --from=upx /helloworld /helloworld

ENTRYPOINT ["./helloworld"]

FROM ghcr.io/graalvm/graalvm-ce:22 as graalvm

RUN gu install native-image

#TODO copy and compile HelloWord class

RUN native-image HelloWorld

FROM alpine

COPY --from=graalvm /sources/helloworld /helloworld

CMD ./helloworld

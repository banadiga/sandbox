#!/usr/bin/env bash

mkdir -p target/sandboxjava9jlink;

/usr/lib/jvm/java-9-oracle/bin/javac \
    --module-path ./../java9module/target/sandboxjava9module \
    -d target/sandboxjava9jlink  \
    $(find ./src/main/java -name "*.java")

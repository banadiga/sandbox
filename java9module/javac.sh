#!/usr/bin/env bash

mkdir -p target/sandboxjava9module

/usr/lib/jvm/java-9-oracle/bin/javac \
    -d target/sandboxjava9module \
    $(find ./src/main/java -name "*.java")

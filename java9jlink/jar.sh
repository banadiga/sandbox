#!/usr/bin/env bash

mkdir -p target/jar;

/usr/lib/jvm/java-9-oracle/bin/jar \
    --create \
    --file target/jar/sandbox-java9jlink@1.0.jar \
    --module-version=1.0 \
    --main-class com.banadiga.java9jlink.Application \
    -C target/sandboxjava9jlink .

/usr/lib/jvm/java-9-oracle/bin/java \
    --module-path ./../java9module/target/sandboxjava9module:target/jar \
    --module sandboxjava9jlink

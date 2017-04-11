#!/usr/bin/env bash

mkdir -p target/jar;

/usr/lib/jvm/java-9-oracle/bin/jar \
    --create \
    --file target/jar/sandboxjava9module@1.0.jar \
    --module-version=1.0 \
    -C target/sandboxjava9module .

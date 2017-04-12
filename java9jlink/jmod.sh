#!/usr/bin/env bash

mkdir -p target/jmods;
rm -rf target/jmods/sandboxjava9jlink.jmod

/usr/lib/jvm/java-9-oracle/bin/jmod \
    create \
    --class-path  target/sandboxjava9jlink \
    --main-class com.banadiga.java9jlink.Application \
    --module-version 2.0 \
    target/jmods/sandboxjava9jlink.jmod

#!/usr/bin/env bash

mkdir -p target/jmods;
rm -rf target/jmods/sandboxjava9module.jmod

/usr/lib/jvm/java-9-oracle/bin/jmod \
    create \
    --class-path target/sandboxjava9module \
    --module-version 2.0 \
    target/jmods/sandboxjava9module.jmod

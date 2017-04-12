#!/usr/bin/env bash

rm -rf target/jlink

/usr/lib/jvm/java-9-oracle/bin/jlink \
    --module-path /usr/lib/jvm/java-9-oracle/jmods:../java9module/target/jmods/:./target/jmods/ \
    --add-modules sandboxjava9jlink \
    --output target/jlink \
    --exclude-files *.diz \
    --strip-debug \
    --launcher myapp=sandboxjava9jlink \
    --compress 2

target/jlink/bin/java \
    --module sandboxjava9jlink

echo "Run myapp launcher:"
target/jlink/bin/myapp;

echo "List modules:"
target/jlink/bin/java \
    --list-modules

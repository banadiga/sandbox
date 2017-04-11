#!/usr/bin/env bash

/usr/lib/jvm/java-9-oracle/bin/java \
    --module-path ./../java9module/target/sandboxjava9module:./target/sandboxjava9jlink \
    --module sandboxjava9jlink/com.banadiga.java9jlink.Application

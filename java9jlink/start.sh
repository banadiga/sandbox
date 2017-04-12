#!/usr/bin/env bash

echo "Run javac...";
sh ./javac.sh;
echo "Run jmod...";
sh ./jmod.sh;
echo "Run java...";
sh ./java.sh;
echo "Run jar...";
sh ./jar.sh;
echo "Run jlink...";
sh ./jlink.sh;

#!/bin/bash

# TODO: use version automatically

./gradlew build
cp ./build/libs/vasya-1.0.0.jar ~/.local/share/multimc/instances/Fabric/.minecraft/mods/vasya-1.0.0.jar


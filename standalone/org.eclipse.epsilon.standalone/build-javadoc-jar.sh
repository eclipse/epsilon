#!/bin/bash

JAVADOC_FLAGS="-encoding UTF-8 -Xdoclint:none"

for srcjar in target/epsilon-*-sources.jar; do
    rm -rf tmpsrc tmpjavadoc
    mkdir tmpsrc tmpjavadoc

    pushd tmpsrc
    unzip "../$srcjar"
    javadoc $JAVADOC_FLAGS -subpackages org.eclipse.epsilon -d ../tmpjavadoc
    popd

    pushd tmpjavadoc
    TARGET="../${srcjar%-sources.jar}-javadoc.jar"
    rm -f "$TARGET"
    find . -mindepth 1 -type d -print0 | xargs -0 zip -r "$TARGET"
    popd
done

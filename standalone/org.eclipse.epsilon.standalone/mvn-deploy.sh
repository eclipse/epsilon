#!/bin/bash

# For Java 8
JAVADOC_FLAGS="-Xdoclint:none"

build_javadocs() {
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
	find -mindepth 1 -type d -print0 | xargs -0 zip -r "$TARGET"
	popd
    done
}

deploy_artefacts() {
    # Extract version from eol.engine POM
    VERSION="$(sed -rn '/eol.engine/,+1{s|.*<version>\s*(.*)\s*</version>.*|\1|p;};' ../../plugins/org.eclipse.epsilon.eol.engine/pom.xml)"
    echo "[mvn-deploy] Version to be deployed: '$VERSION'"
    
    for SRCJAR in target/epsilon-*-sources.jar; do
	# Example trace on the right to help read this
	PREFIX="${SRCJAR%-sources.jar}"         # target/epsilon-1.4-emf
	BASENAME="$(basename "$PREFIX")"        # epsilon-1.4-emf
	ARTIFACTID="${BASENAME/-[0-9]*[0-9]/}"  # epsilon-emf

	BINJAR="$PREFIX.jar"
	DOCJAR="$PREFIX-javadoc.jar"
	mvn -P ossrh gpg:sign-and-deploy-file \
	    "-DrepositoryId=ossrh" "-Durl=https://oss.sonatype.org/content/repositories/snapshots" \
	    "-DartifactId=$ARTIFACTID" "-DgroupId=org.eclipse.epsilon" "-Dversion=$VERSION" \
	    "-Dfile=$BINJAR" "-Djavadoc=$DOCJAR" "-Dsources=$SRCJAR"
    done
}

#build_javadocs
deploy_artefacts

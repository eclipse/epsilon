#!/bin/sh

# Downloads EMF Compare and installs it as a local dependency,
# to be embedded in the plain Maven eunit.cmp.emf JAR.

EMF_COMPARE_VERSION="3.5.3.202011201248"
EMF_COMPARE_URL="https://download.eclipse.org/releases/2020-12/202012161000/plugins/org.eclipse.emf.compare_${EMF_COMPARE_VERSION}.jar"
EMF_COMPARE_JAR=emf-compare.jar

cd "$(dirname "$(readlink -f "$0")")"
curl -C - -o "$EMF_COMPARE_JAR" -O "$EMF_COMPARE_URL"

mvn -f pom-plain.xml install:install-file \
  "-Dfile=$EMF_COMPARE_JAR" \
  -DgroupId=org.eclipse.emf \
  -DartifactId=org.eclipse.emf.compare \
  "-Dversion=$EMF_COMPARE_VERSION" \
  -Dpackaging=jar

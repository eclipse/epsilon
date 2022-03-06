#!/bin/sh

# Downloads EMF Compare and installs it as a local dependency,
# to be embedded in the plain Maven eunit.cmp.emf JAR.

EMF_COMPARE_VERSION="3.5.3.202111290942"
EMF_COMPARE_URL="https://download.eclipse.org/releases/2021-12/202112081000/plugins/org.eclipse.emf.compare_${EMF_COMPARE_VERSION}.jar"
EMF_COMPARE_JAR="org.eclipse.emf.compare_3.5.3.202111290942.jar"

cd "$(dirname "$(readlink -f "$0")")"
curl -C - -o "$EMF_COMPARE_JAR" -O "$EMF_COMPARE_URL"

mvn -f pom-plain.xml clean install:install-file \
  "-Dfile=$EMF_COMPARE_JAR" \
  -DgroupId=org.eclipse.emf \
  -DartifactId=org.eclipse.emf.compare \
  "-Dversion=$EMF_COMPARE_VERSION" \
  -Dpackaging=jar

# Powershell version:

 #mvn -f pom-plain.xml install:install-file "-Dfile=org.eclipse.emf.compare_3.5.3.202111290942.jar" "-DgroupId=org.eclipse.emf" "-DartifactId=org.eclipse.emf.compare" "-Dversion=3.5.3.202111290942" "-Dpackaging=jar"

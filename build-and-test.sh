# Build
mvn -T 1C clean install;

# Plugged-In tests
mvn -f tests/org.eclipse.epsilon.test verify -P plugged;

# Full test suite
mvn -f tests/org.eclipse.epsilon.test surefire:test -P unit;

# Build standalone JARs
# mvn -f standalone verify -P build

# Build update site
# mvn -f releng verify -P updatesite

# Bump version (replace X.Y.Z with appropriate numbers)
#mvn org.eclipse.tycho:tycho-versions-plugin:set-version "-DnewVersion=X.Y.Z"

# Query project version
#mvn help:evaluate -Dexpression=project.version -q -DforceStdout 

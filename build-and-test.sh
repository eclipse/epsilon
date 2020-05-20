mvn -T 1C clean install &&
mvn -f tests/org.eclipse.epsilon.test install -P plugged;
mvn -f tests/org.eclipse.epsilon.test surefire:test -P unit;


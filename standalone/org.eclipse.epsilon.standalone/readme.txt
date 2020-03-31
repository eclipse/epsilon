Standalone distribution
===

assembly/*.xml are Maven assembly descriptors that are automatically produced
from jarmodel.xml through the jarmodel2mvn.egx transformation. These
assembly descriptors are referenced from the pom.xml file and used from Jenkins
to automatically build the standalone jars.

This EGX file can be run from the jarmodel2mvn.launch Eclipse launch file. To
keep things simple, the assembly/*.xml files should be kept under version
control, so Maven doesn't need to run the EGX script.

The assemblies produce binary, binary+source, source and "kitchensink"
JARs. These can be linked from the website, but in order to be
promoted to Maven Central we need to follow the usual "main artifact +
sources attachment + javadoc attachment" approach.

To do this, we have a shell script that unzips the source assemblies
and produces javadoc JARs from them, and a custom Maven plugin that
reuses the maven-gpg-plugin to sign and deploy the binary, source, and
javadoc JARs in tandem to Sonatype OSSRH. The custom Maven plugin is
in ../eutils-maven-plugin. For more instructions on its use, check the
comments of its EpsilonStandaloneDeployMojo class.

IMPORTANT !!!

If the jarmodel.xml is modified it is IMPORTANT to run the jarmodel2mvn.launch file 
as this step is not part of the CI build process.

index.egl should be run to generate the webpage at eclipse.org/epsilon/download.
in the Epsilon website repo, the output should be directed to download/jars/interim.php.

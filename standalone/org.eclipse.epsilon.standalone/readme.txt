assembly/*.xml are Maven assembly descriptors that are automatically produced
from jarmodel.xml through the jarmodel2mvn.egx M2T transformation. These
assembly descriptors are referenced from the pom.xml file and used from Hudson
to automatically build the standalone jars.

This EGX file can be run from the jarmodel2mvn.launch Eclipse launch file. To
keep things simple, the assembly/*.xml files should be kept under version
control, so Maven doesn't need to run the EGX script.
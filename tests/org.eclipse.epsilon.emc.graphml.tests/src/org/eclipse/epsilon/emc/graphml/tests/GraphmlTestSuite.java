package org.eclipse.epsilon.emc.graphml.tests;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EdgeFeatureLabelParserTests.class,
               ValuedFeatureLabelParserTests.class})
public class GraphmlTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(GraphmlTestSuite.class);
	}
}

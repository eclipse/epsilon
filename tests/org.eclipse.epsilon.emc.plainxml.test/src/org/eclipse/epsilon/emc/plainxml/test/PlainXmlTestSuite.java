package org.eclipse.epsilon.emc.plainxml.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(PlainXmlModelTests.class)
public class PlainXmlTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(PlainXmlTestSuite.class);
	}
	
}

package org.eclipse.epsilon.emc.csv.test;

import org.eclipse.epsilon.emc.csv.CsvModelTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({CsvModelTests.class})
public class CsvModelTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(CsvModelTestSuite.class);
	}
}

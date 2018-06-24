package org.eclipse.epsilon.flexmi.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	StandaloneTests.class,
	ImportTests.class,
	IncludeTests.class,
	IncludeImportTests.class,
	TemplateTests.class
})
public class FlexmiTestSuite {

}

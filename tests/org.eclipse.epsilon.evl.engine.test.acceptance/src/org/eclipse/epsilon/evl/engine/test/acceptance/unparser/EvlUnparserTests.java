package org.eclipse.epsilon.evl.engine.test.acceptance.unparser;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.engine.test.acceptance.unparser.UnparserTests;
import org.eclipse.epsilon.eol.parse.EolUnparser;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestSuite;
import org.eclipse.epsilon.evl.parse.EvlUnparser;
import org.junit.Test;

public class EvlUnparserTests extends UnparserTests {

	@Test
	public void testExistingEvlFiles() throws Exception {
		test(EvlAcceptanceTestSuite.class,
				"scripts/cookbook.evl",
				"scripts/java_annotated.evl",
				"scripts/java_findbugs.evl",
				"scripts/java_equals.evl",
				"scripts/java_parallel.evl");
	}
	
	@Override
	public EolModule createModule() {
		return new EvlModule();
	}

	@Override
	public EolUnparser createUnparser() {
		return new EvlUnparser();
	}

}

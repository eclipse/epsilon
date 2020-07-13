package org.eclipse.epsilon.pinset.engine.test.acceptance.dummy;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.pinset.PinsetModule;
import org.eclipse.epsilon.pinset.engine.test.acceptance.PinsetTests;
import org.junit.BeforeClass;
import org.junit.Test;

public class PinsetDummyTests extends PinsetTests {

	@BeforeClass
	public static void setup() throws Exception {
		registerMetamodel("dummy.ecore", PinsetDummyTests.class);
	}

	@Test
	public void testDummy() throws Exception {
		PinsetModule module = new PinsetModule();
		module.setOutputFolder(getTempDir());
		module.parse(getFile("dummy.pinset"));
		if (!module.getParseProblems().isEmpty()) {
			System.err.println("The following errors were identified");
			for (ParseProblem parseProblem : module.getParseProblems()) {
				System.err.println("- " + parseProblem);
			}
			throw new RuntimeException("Parsing errors detected");
		}

		module.getContext().getModelRepository().addModel(
				loadModel("M", "dummy.model", "pinsetdummy", true, false));
		module.execute();

		assertEquivalent(module.getGeneratedDatasetFiles(), module.getOutputFolder());
	}

}

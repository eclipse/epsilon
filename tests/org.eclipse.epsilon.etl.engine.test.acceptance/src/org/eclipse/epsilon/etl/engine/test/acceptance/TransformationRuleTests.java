package org.eclipse.epsilon.etl.engine.test.acceptance;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransformationRuleTests extends EtlTest {

	private EtlModule module;

	@Before
	public void setup() throws Exception {
		module = new EtlModule();

		registerMetamodel("models/Tree.ecore");
		registerMetamodel("models/Graph.ecore");

		EmfModel graphModel = loadModel("Graph", "models/graph.model", "Graph", false, false);

		module.getContext().getModelRepository().addModel(loadModel("Tree", "models/tree.model", "Tree", true, false));
		module.getContext().getModelRepository().addModel(graphModel);
	}

	@After
	public void tearDown() throws Exception {
		module.getContext().dispose();
	}

	@Test
	public void testLazyRuleIdentification() throws Exception {
		EtlModule module = new EtlModule();
		module.parse(new File(getFullPath("TransformationRuleTests.etl")));
		assertTrue(module.getParseProblems().isEmpty());

		registerMetamodel("models/Tree.ecore");
		registerMetamodel("models/Graph.ecore");

		EmfModel graphModel = loadModel("Graph", "models/graph.model", "Graph", false, false);

		module.getContext().getModelRepository().addModel(loadModel("Tree", "models/tree.model", "Tree", true, false));
		module.getContext().getModelRepository().addModel(graphModel);
		
		module.execute();
		
		for (TransformationRule rule : module.getTransformationRules()) {
			assertEquals(rule.getName() + " should be lazy", rule.getBooleanAnnotationValue("isLazy", null), rule.isLazy());
		}
	}

}

package org.eclipse.epsilon.emc.graphml.tests;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.emc.graphml.GraphmlImporter;
import org.eclipse.epsilon.emc.muddle.Muddle;
import org.eclipse.epsilon.emc.muddle.MuddleModel;
import org.eclipse.epsilon.eol.EolEvaluator;

public class MuddleTests {
	
	protected MuddleModel loadMuddleModel(String filename) throws Exception {
		GraphmlImporter importer = new GraphmlImporter();
		String fileUri = GraphmlTestSuite.class.getResource("models/" + filename).toURI().toString();
		Muddle muddle = importer.importGraph(fileUri);
		MuddleModel model = new MuddleModel();
		model.setMuddle(muddle);
		return model;
	}
	
	protected void assertEval(String expression, Object result, String modelFileName) throws Exception {
		MuddleModel model = loadMuddleModel(modelFileName);
		EolEvaluator evaluator = new EolEvaluator(model);
		assertEquals(result, evaluator.evaluate(expression));
	}

}

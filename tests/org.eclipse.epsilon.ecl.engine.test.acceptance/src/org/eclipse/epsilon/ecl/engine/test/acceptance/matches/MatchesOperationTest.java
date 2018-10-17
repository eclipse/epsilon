package org.eclipse.epsilon.ecl.engine.test.acceptance.matches;

import static org.junit.Assert.assertEquals;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.junit.Before;
import org.junit.Test;

public class MatchesOperationTest {

	IEclModule module;
	
	@Before
	public void setup() throws Exception {
		module = new EclModule();
		module.parse(getClass().getResource("CompareInstance.ecl").toURI());
		ModelRepository modelRepo = module.getContext().getModelRepository();
		modelRepo.addModels(loadEmfModel("Left"), loadEmfModel("Right"));
		module.execute();
	}
	
	@Test
	public void testCorrectNumberOfMatches() throws Exception {
		assertEquals(1, module.getContext().getMatchTrace().getMatches().size());
	}
	
	private EmfModel loadEmfModel(String modelName) throws Exception {
		EmfModel model = new EmfModel();
		model.setName(modelName);
		model.setCachingEnabled(true);
		model.setMetamodelFile(getClass().getResource("mymetamodel.ecore").toURI().getPath().toString());
		model.setModelFile(getClass().getResource(modelName+".model").toURI().getPath().toString());
		model.load();
		return model;
	}
}

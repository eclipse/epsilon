package org.eclipse.epsilon.emc.simulink.test.perform;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelGenerator {

	protected final IModel model;
	
	public ModelGenerator(Integer modelId) {
		model = populateModel(modelId);
	}
	
	private String readEol() throws IOException{
		File file = new File("experiments/query-optimisation/models/generator.eol");
		return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	}
	
	private IModel populateModel(Integer modelId) {
		File file = new File(String.format("experiments/query-optimisation/models/%s.slx", modelId));
		if (file.exists()) {
			file.delete();
		}
		
		SimulinkModel model = new SimulinkModel();
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.setCloseOnDispose(true);
		model.setOpenOnLoad(false);
		model.setFile(file);
		return model;
	}
	
	public void generate() throws EolModelLoadingException, IOException {
		model.load();
		EolEvaluator eolEvaluator = new EolEvaluator(model);
		//eolEvaluator.setVariable("val", 2);
		eolEvaluator.execute(readEol());
	}
	
	public static void main(String[] args) throws Exception {
		for (int i=1; i<5; i++) {
			new ModelGenerator(i).generate();
		}
	}
	
}

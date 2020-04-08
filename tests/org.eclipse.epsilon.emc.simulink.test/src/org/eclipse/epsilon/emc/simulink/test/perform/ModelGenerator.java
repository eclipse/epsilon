package org.eclipse.epsilon.emc.simulink.test.perform;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelGenerator {

	protected final Path modelsRoot = Paths.get("experiments", "query-optimisation", "models");
	protected final IModel model;
	protected final Integer base, modelId;
	
	public ModelGenerator(Integer modelId) {
		this.modelId = modelId;
		this.model = populateModel();
		this.base = 4;
	}
	
	private IModel populateModel() {
		File file = modelsRoot.resolve(String.format("Model%s.slx", modelId)).toFile();
		if (file.exists()) {
			file.delete();
		}
		
		SimulinkModel model = new SimulinkModel();
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(true);
		model.setCloseOnDispose(true);
		model.setOpenOnLoad(false);
		model.setFile(file);
		model.setName("M");
		return model;
	}
	
	private String readEol() throws IOException{
		File file = modelsRoot.resolve("generator.eol").toFile();
		return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	}
	
	public void generate() throws EolModelLoadingException, IOException {
		model.load();
		EolEvaluator eolEvaluator = new EolEvaluator(model);
		eolEvaluator.setVariable("val", new Double(Math.pow(base, modelId)).intValue());
		eolEvaluator.execute(readEol());
		model.dispose();
	}
	
	public static void main(String[] args) {
		System.out.println("Starting Generation");
		int max = 1;//5;
		for (int i=1; i<=max; i++) {
			try {
				new ModelGenerator(i).generate();
			} catch (EolModelLoadingException e) {
				e.printStackTrace();
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("Finished Generation");
	}
	
}
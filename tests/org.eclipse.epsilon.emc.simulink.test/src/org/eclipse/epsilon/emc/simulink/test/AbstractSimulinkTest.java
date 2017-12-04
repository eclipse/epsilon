package org.eclipse.epsilon.emc.simulink.test;

import java.io.File;
import java.util.UUID;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngineFilesEnum;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class AbstractSimulinkTest {

	private static final String ERROR_CONFIG_FILES_NOT_FOUND = "Could not find Matlab Engine Jar or Library Path";
	private static final String TEST_TRACES = "=> TEST: %s.%s";
	
	protected String eol;

	@Rule 
	public TestName name = new TestName();

	@BeforeClass
	public static void engineLogLevel() {
		MatlabEngine.log(true);
	}
	
	@Before
	public void logTestName() {
		System.out.println(String.format(TEST_TRACES, this.getClass().getSimpleName(), name.getMethodName()));
	}

	@After
	public void execute(){
		if (eol != null && !eol.isEmpty()) {
			System.out.println(eol);
			AbstractSimulinkTest.run(eol);
		}
	}
	
	public static void run(String eol) {
		AbstractSimulinkTest.run(eol, null);
	}
	
	public static void run(String eol, String file) {	
		SimulinkModel model = null;
		try {
			EolModule module = new EolModule();
			module.parse(eol);
	
			model = loadSimulinkModel(file);
	
			module.getContext().getModelRepository().addModel(model);
			module.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			model.dispose();
		}
	}

	public static SimulinkModel loadSimulinkModel(String file)
			throws EolModelLoadingException {
		
		File simulinkEngineJar = MatlabEngineFilesEnum.ENGINE_JAR.file();
		File simulinkLibraryPath = MatlabEngineFilesEnum.LIBRARY_PATH.file();
	
		if (!simulinkEngineJar.exists() || !simulinkLibraryPath.exists()) 
			throw new EolModelLoadingException(new Exception(ERROR_CONFIG_FILES_NOT_FOUND), null);
		
		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		if (file != null) {
			model.setFile(new File(file));
			model.setReadOnLoad(true);
		} else {
			model.setFile(new File("model" + String.valueOf(UUID.randomUUID()).replace("-", "") + ".slx"));
			model.setReadOnLoad(false);
		}
		model.setStoredOnDisposal(false);
		model.setHiddenEditor(true);
		model.setLibraryPath(simulinkLibraryPath.getAbsolutePath());
		model.setEngineJarPath(simulinkEngineJar.getAbsolutePath());
		model.load();
		
		return model;
	}
	
}

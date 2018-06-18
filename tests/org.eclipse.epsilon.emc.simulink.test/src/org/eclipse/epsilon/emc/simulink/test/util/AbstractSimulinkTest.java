package org.eclipse.epsilon.emc.simulink.test.util;

import static org.eclipse.epsilon.emc.simulink.test.util.MatlabEngineFilesEnum.ENGINE_JAR;
import static org.eclipse.epsilon.emc.simulink.test.util.MatlabEngineFilesEnum.LIBRARY_PATH;
import static org.junit.Assert.fail;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class AbstractSimulinkTest {

	private static final String ERROR_CONFIG_FILES_NOT_FOUND = "Could not find Matlab Engine Jar or Library Path";
	private static final String TEST_TRACES = "=> TEST: %s.%s";
	private static final String LN_BR = System.getProperty("line.separator");
	
	protected static final String LN = " 'LINE BREAK'.println(); ";

	protected String eol;
	protected String eolResourceFile;
	protected File modelFile;

	protected boolean activeCache = false;

	@Rule
	public TestName name = new TestName();

	@BeforeClass
	public static void engineLogLevel() {
	}

	@Before
	public void logTestName() {
		System.out.println(String.format(TEST_TRACES, this.getClass().getSimpleName(), name.getMethodName()));
	}

	@After
	public void execute() {
		setupEOL();
		try {
			AbstractSimulinkTest.run(eol, modelFile, activeCache);
		} catch (EolRuntimeException re) {
			re.printStackTrace();
			fail("Caught EOL Runtime Exeption");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			eol = null;
			modelFile = null;
			eolResourceFile = null;
		}

	}

	protected void setupEOL() {
		if (eol == null) {
			if (eolResourceFile != null) {
				eolResourceFile = FileUtils.getResource(eolResourceFile);
			} else {
				eolResourceFile = FileUtils.getScript(getClass().getSimpleName() + "/" + name.getMethodName() + ".eol");
			}
			
			try {
				File eolAsFile = new File(eolResourceFile);
				List<String> lines = Files.readAllLines(Paths.get(eolAsFile.getAbsolutePath()));
				eol = String.join(LN_BR, lines);
			} catch (Exception e) {}
		}
		System.out.println("   >> EOL: " + LN_BR + eol);
	}

	public static void run(String eol, File file) throws Exception {
		AbstractSimulinkTest.run(eol, file, false);
	}

	public static void run(String eol, File file, boolean activeCaching) throws Exception {
		if (eol != null) {
			SimulinkModel model = null;
			try {
				EolModule module = new EolModule();
				try {
					File eolAsFile = new File(eol);
					if (eolAsFile.exists()) {
						module.parse(eolAsFile);
					} else {
						module.parse(eol);
					}
				} catch (Exception e) {
					System.err.println("Could not parse EOL");
					throw e;
				}

				model = loadSimulinkModel(file, activeCaching);

				module.getContext().getModelRepository().addModel(model);
				module.execute();
			} catch (Exception ex) {
				throw ex;
			} finally {
				if (model != null) {
					model.dispose();
				}
			}
		}
	}

	public static SimulinkModel loadSimulinkModel(File file, boolean activeCaching) throws EolModelLoadingException {

		if (!ENGINE_JAR.file().exists() || !LIBRARY_PATH.file().exists())
			throw new EolModelLoadingException(new Exception(ERROR_CONFIG_FILES_NOT_FOUND), null);

		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		if (file != null) {
			model.setFile(file);
			model.setReadOnLoad(true);
		} else {
			model.setFile(new File("model" + String.valueOf(UUID.randomUUID()).replace("-", "") + ".slx"));
			model.setReadOnLoad(false);
		}
		model.setStoredOnDisposal(false);
		model.setShowInMatlabEditor(true);
		model.setCachingEnabled(activeCaching);
		model.setLibraryPath(LIBRARY_PATH.path());
		model.setEngineJarPath(ENGINE_JAR.path());
		model.load();

		return model;
	}

}

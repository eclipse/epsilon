/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
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
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class AbstractSimulinkTest {

	private static final String TEST_TRACES = "=> TEST: %s.%s";
	private static final String LN_BR = System.getProperty("line.separator");
	
	protected static final String LN = " 'LINE BREAK'.println(); ";

	@ClassRule
	public static AssumeMatlabInstalled installation = new AssumeMatlabInstalled();

	protected String eol;
	protected String eolResourceFile;
	protected File modelFile;

	protected boolean activeCache = false;

	@Rule
	public TestName name = new TestName();

	@BeforeClass
	public static void engineLogLevel() {}

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
					module.parse(eol);
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

	public static SimulinkModel loadSimulinkModel(File file, boolean activeCaching) throws Exception {

		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		if (file != null) {
			model.setFile(file);
			model.setReadOnLoad(true);
			model.setWorkingDir(file.getParentFile());
		} else {
			model.setFile(new File("model" + String.valueOf(UUID.randomUUID()).replace("-", "") + ".slx"));
			model.setWorkingDir(new File(System.getProperty("user.dir")));
			model.setReadOnLoad(false);
		}
		model.setStoredOnDisposal(false);
		model.setShowInMatlabEditor(false);
		model.setCachingEnabled(activeCaching);
		String version = installation.getVersion();
		String path;
		try {
			path = LIBRARY_PATH.path(version);
			System.out.println(path);
			model.setLibraryPath(path);
			String engine = ENGINE_JAR.path(version);
			System.out.println(engine);
			model.setEngineJarPath(engine);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		model.setFollowLinks(false);
		try {
			model.load();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
			throw e;
		}
		return model;
	}

}

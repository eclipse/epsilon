/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.test.perform;

import static org.eclipse.epsilon.emc.simulink.common.test.MatlabEngineSetupEnum.ENGINE_JAR;
import static org.eclipse.epsilon.emc.simulink.common.test.MatlabEngineSetupEnum.LIBRARY_PATH;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.emc.simulink.common.test.AssumeMatlabInstalled;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.EolModule;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PerformanceExperiment {

	protected static String path, engine;
	protected static File resultsFile;
	protected static final Path root = Paths.get("experiments", "query-optimisation");
	protected SimulinkModel model;
	protected EolModule eolModule;
	protected Long duration;
	
	/** SETUP */
	protected static int maxModels = 4;
	protected static int maxScripts = 8; // TODO choose
	protected static int maxIterations = 20; // TODO choose
	protected static int warmupIterations = 5; // TODO choose
	
	@ClassRule
	public static AssumeMatlabInstalled installation = new AssumeMatlabInstalled();
	
	@BeforeClass
	public static void setup() throws Exception{
		String version = installation.getVersion();
		path = LIBRARY_PATH.path(version);
		engine = ENGINE_JAR.path(version);
		String pattern = "yyyy-MM-dd-hh:mm:ss";
		String dateOfExperiment = new SimpleDateFormat(pattern).format(new Date());
		resultsFile = root.resolve("results").resolve(String.format("results-%s.csv", dateOfExperiment)).toFile();
		prepareResultFile(resultsFile, getHeaders());
	}
	
	protected static void prepareResultFile(File file, String...headers) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader(headers);
		try(CSVPrinter csvPrinter = new CSVPrinter(fileWriter,csvFormat)) {}
	}
	
	@Parameters(name = "Test-{index}: QueryId={0},ModelId={1},Optimisation={2},Iteration={3}")
	public static Iterable<Object[]> parameters() {
		ArrayList<Object[]> list = new ArrayList<>();
		List<Boolean> bools = Arrays.asList(new Boolean[] {false, true});
		for (int queryId=1;queryId <= maxScripts; queryId++) {
			for (int modelId=1;modelId <= maxModels; modelId++) {
				for (Boolean optimisation : bools) {
					for (int iteration= - warmupIterations;iteration < maxIterations; iteration++) {
						list.add(new Object[] {queryId, modelId, optimisation, iteration});
					}
				}
			}
		}
		return list;
	}
	
	@Parameter(0)
	public Integer queryId;
	
	@Parameter(1)
	public Integer modelId;
	
	@Parameter(2)
	public boolean optimisation;
	
	@Parameter(3)
	public Integer iteration;
	
	protected static String[] getHeaders() {
		return Arrays.asList("queryId", "modelId", "optimisation", "iteration", "duration(nanosec)","elements").toArray(new String[0]);
	}
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void prepareForExecution() throws Exception {
		System.out.println(name.getMethodName());
		
		/** Prepare */
		loadModel();
		parseAndPopulateScript();

		/** Start timer */
		duration = System.nanoTime();
	}
	
	@After
	public void deleteNonExisting() throws IOException {
		/** Stop timer */
		duration = System.nanoTime() - duration;
		
		/** Results */
		if (iteration > 0) {			
			int elements = ((Double) Math.pow(4, modelId)).intValue();
			writeResults(resultsFile, queryId, modelId, optimisation, iteration, duration, elements);
		}
		
		/** Dispose */
		dispose(); //FIXME uncomment
	}
	
	@Test
	public void execution() {
		try {
			eolModule.execute(); //FIXME uncomment
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Helpers
	 */
	
	protected void loadModel() throws Exception{
		model = new SimulinkModel();

		model.setFile(getModel(modelId));
		
		model.setReadOnLoad(true);
		model.setStoredOnDisposal(false);
		model.setOpenOnLoad(false);
		model.setCloseOnDispose(true);
		model.setCachingEnabled(false);
		
		model.setName("M");
		model.setLibraryPath(path);
		model.setEngineJarPath(engine);
		
		model.setFindOptimisationEnabled(optimisation);
		model.setFollowLinks(false);
		model.setIncludeCommented(false);
		model.setLookUnderMasks("none");
		
		model.load(); //FIXME uncomment
	}
	
	protected void parseAndPopulateScript() throws Exception {
		eolModule = new EolModule();
		eolModule.getContext().getModelRepository().addModel(model);
		eolModule.parse(getScript(queryId)); //FIXME uncomment
	}
	
	protected void dispose() {
		System.out.println("Disposing");
		eolModule = null;
		model.dispose();
	}
	
	protected File getModel(Integer id){
		return root.resolve("models").resolve(String.format("Model%s.slx", id)).toFile();
	}
	
	protected String getScript(Integer id) throws IOException {
		File file = root.resolve("scripts").resolve(String.format("Scripts.eol", id)).toFile();
		return FileUtils.readLines(file, StandardCharsets.UTF_8).get(id-1);
	}
	
	protected void writeResults(File file, Object... record) throws IOException {
		FileWriter fileWriter = new FileWriter(file, true);
		CSVFormat csvFormat = CSVFormat.EXCEL;
		try(CSVPrinter csvPrinter = new CSVPrinter(fileWriter,csvFormat)) {
			csvPrinter.printRecord(record);
		}
	}
	
}

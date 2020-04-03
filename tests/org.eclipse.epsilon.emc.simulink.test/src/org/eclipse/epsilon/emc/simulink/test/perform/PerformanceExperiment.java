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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
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

	protected static String path, engine, fileName, root;
	
	protected SimulinkModel model;
	protected EolModule eolModule;
	protected Long duration;
	
	/** SETUP */
	protected static int maxModels = 10;
	protected static int maxScripts = 10;
	protected static int maxIterations = 5;
	
	@ClassRule
	public static AssumeMatlabInstalled installation = new AssumeMatlabInstalled();
	
	@BeforeClass
	public static void setup() throws Exception{
		root = "experiments/query-optimisation/";
		String version = installation.getVersion();
		path = LIBRARY_PATH.path(version);
		engine = ENGINE_JAR.path(version);
		String pattern = "yyyy-MM-dd-hh:mm:ss";
		String dateOfExperiment = new SimpleDateFormat(pattern).format(new Date());
		fileName = String.format(root + "results/results-%s.csv", dateOfExperiment);
		prepareResultFile();
	}
	
	protected static void prepareResultFile() throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader(getHeaders());
		try(CSVPrinter csvPrinter = new CSVPrinter(fileWriter,csvFormat)) {}
	}
	
	@Parameters(name = "Test-{index}: QueryId={0},ModelId={1},Optimisation={2},Iteration={3}")
	public static Iterable<Object[]> parameters() {
		ArrayList<Object[]> list = new ArrayList<>();
		List<Boolean> bools = Arrays.asList(new Boolean[] {false, true});
		for (int queryId=1;queryId <= maxScripts; queryId++) {
			for (int modelId=1;modelId <= maxModels; modelId++) {
				for (Boolean optimisation : bools) {
					for (int iteration=1;iteration <= maxIterations; iteration++) {
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
		return Arrays.asList("queryId", "modelId", "optimisation", "iteration", "duration(nanosec)").toArray(new String[0]);
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
		writeResults(queryId, modelId, optimisation, iteration, duration);
		
		/** Dispose */
		//dispose(); //FIXME uncomment
	}
	
	@Test
	public void execution() {
		try {
			//eolModule.execute(); //FIXME uncomment
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
		
		//model.load(); //FIXME uncomment
	}
	
	protected void parseAndPopulateScript() throws Exception {
		eolModule = new EolModule();
		eolModule.getContext().getModelRepository().addModel(model);
		//eolModule.parse(getScript(queryId)); //FIXME uncomment
	}
	
	protected void dispose() {
		eolModule = null;
		model.dispose();
	}
	
	protected File getModel(Integer id){
		return new File(String.format(root + "models/%s.slx", id));
	}
	
	protected File getScript(Integer id){
		return new File(String.format(root + "script/%s.eol", id));
	}
	
	protected void writeResults(Object... record) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName, true);
		CSVFormat csvFormat = CSVFormat.EXCEL;
		try(CSVPrinter csvPrinter = new CSVPrinter(fileWriter,csvFormat)) {
			csvPrinter.printRecord(record);
		}
	}
	
}

/*******************************************************************************
 * Copyright (c) 2018 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - Concurrency tests, refactoring, utilities etc.
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.evl.engine.test.acceptance;

import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import static org.eclipse.epsilon.erl.engine.test.util.ErlAcceptanceTestUtil.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.erl.engine.test.util.ErlAcceptanceTestUtil;
import org.eclipse.epsilon.evl.*;
import org.eclipse.epsilon.evl.concurrent.*;
import org.eclipse.epsilon.evl.engine.launch.EvlRunConfiguration;

public class EvlAcceptanceTestUtil {
	private EvlAcceptanceTestUtil() {}
	
	public static final String
		//Core
		testsBase = getTestBaseDir(EvlAcceptanceTestSuite.class),
		metamodelsRoot = testsBase+"metamodels/",
		scriptsRoot = testsBase+"scripts/",
		modelsRoot = testsBase+"models/",
		
		//Metamodels and scripts
		javaMetamodel = "java.ecore",
		javaModels[] = {
			"epsilon_profiling_test.xmi",
			"test001_java.xmi",
			"emf_cdo-example.xmi",
		},
		javaScripts[] = {
			"java_findbugs",
			"java_1Constraint",
			"java_manyConstraint1Context",
			"java_manyContext1Constraint"
		},
		
		thriftMetamodel = "thrift.ecore",
		thriftScripts[] = {"thrift_validator"},
		thriftModels[] = {
			"fb303.xmi",
			"SimpleService.xmi",
			"ThriftTest.xmi"
		},
		
		cookbookMetamodel = "cookbook.ecore",
		cookbookScripts[] = {"cookbook"},
		cookbookModels[],
		
		imdbMetamodel = "movies.ecore",
		imdbScripts[] = {"imdb_validator"},
		imdbModels[] = {"imdb-small.xmi"},
		
		dblpMetamodel = "dblp.ecore",
		dblpScripts[] = {"dblp_isbn"},
		dblpModels[] = {"simpleDBLP.xmi"};
	
	/*Nx3 array where N is number of test inputs;
	 *  0 is the script path,
	 *  1 is the model path,
	 *  2 is the metamodel path.
	 */
	public static final List<String[]>
		allInputs,
		javaInputs,
		thriftInputs,
		cookbookInputs,
		dblpInputs,
		imdbInputs;
	
	static {
		cookbookModels = new String[6];
		cookbookModels[0] = "cookbook_cyclic.model";
		for (int i = 1; i < 6; i++) {
			cookbookModels[i] = "cookbook"+i+".model";
		}
		
		javaInputs = addAllInputs(javaScripts, javaModels, javaMetamodel);
		thriftInputs = addAllInputs(thriftScripts, thriftModels, thriftMetamodel);
		cookbookInputs = addAllInputs(cookbookScripts, cookbookModels, cookbookMetamodel);
		imdbInputs = addAllInputs(imdbScripts, imdbModels, imdbMetamodel);
		dblpInputs = addAllInputs(dblpScripts, dblpModels, dblpMetamodel);
		
		allInputs = CollectionUtil.composeArrayListFrom(
			dblpInputs,
			imdbInputs,
			cookbookInputs,
			javaInputs,
			thriftInputs
		);
	}
	
	/*
	 * A list of pre-configured Runnables which will call the execute() method on the provided module.
	 * @param modules A collection of IEvlModules to use in combination with each set of test data.
	 */
	public static Collection<EvlRunConfiguration> getScenarios(List<String[]> testInputs, boolean includeTest, Collection<Supplier<? extends IEvlModule>> moduleGetters, Function<String[], Integer> idCalculator) {
		if (testInputs == null) testInputs = allInputs;
		if (moduleGetters == null) moduleGetters = modules();
		Collection<EvlRunConfiguration> scenarios = ErlAcceptanceTestUtil.getScenarios(EvlRunConfiguration.class, testInputs, moduleGetters, idCalculator);
		
		if (includeTest) {
			for (Supplier<? extends IEvlModule> moduleGetter : moduleGetters) {
				IEvlModule evlStd = moduleGetter.get();
				
				scenarios.add(
					new EvlRunConfiguration(
						EvlTests.getTestScript(evlStd).toPath(),
						null,
						EvlTests.getTestModel(false),
						Optional.of(false),
						Optional.of(false),
						Optional.of(evlStd),
						Optional.of(testInputs.size()+1),
						Optional.empty()
					)
				);
			}
		}
		
		return scenarios;
	}
	
	public static Collection<Supplier<? extends IEvlModule>> modules(boolean includeStandard) {
		return parallelModules(
			includeStandard ? EvlModule::new : null,
			EvlModuleParallelElements::new,
			EvlModuleParallelStaged::new,
			EvlModuleParallelConstraints::new,
			EvlModuleParallelContexts::new
		);
	}
	
	//Boilerplate defaults
	public static List<String[]> addAllInputs(String[] scripts, String[] models, String metamodel) {
		return ErlAcceptanceTestUtil.addAllInputs(scripts, models, metamodel, "evl", scriptsRoot, modelsRoot, metamodelsRoot);
	}
	@SafeVarargs
	public static Collection<EvlRunConfiguration> getScenarios(Supplier<? extends IEvlModule>... moduleGetters) {
		return getScenarios(null, true, Arrays.asList(moduleGetters), null);
	}
	public static Collection<EvlRunConfiguration> getScenarios(List<String[]> testInputs, boolean includeTest, Collection<Supplier<? extends IEvlModule>> moduleGetters) {
		return getScenarios(testInputs, includeTest, moduleGetters, null);
	}
	public static Collection<Supplier<? extends IEvlModule>> modules() {
		return modules(true);
	}
}

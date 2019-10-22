/*******************************************************************************
 * Copyright (c) 2018 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sina Madani - Concurrency tests, refactoring, utilities etc.
 ******************************************************************************
 */
package org.eclipse.epsilon.evl.engine.test.acceptance;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;
import org.eclipse.epsilon.evl.*;
import org.eclipse.epsilon.evl.concurrent.*;
import org.eclipse.epsilon.evl.concurrent.atomic.EvlModuleParallelConstraintAtoms;
import org.eclipse.epsilon.evl.concurrent.atomic.EvlModuleParallelContextAtoms;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.launch.EvlRunConfiguration;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlAcceptanceTestUtil extends EolAcceptanceTestUtil {
	protected EvlAcceptanceTestUtil() {}
	
	public static final String
		// Core
		testsBase = getTestBaseDir(EvlAcceptanceTestUtil.class),
		metamodelsRoot = testsBase+"metamodels/",
		scriptsRoot = testsBase+"scripts/",
		modelsRoot = testsBase+"models/",
		
		// Metamodels and scripts
		javaMetamodel = "java.ecore",
		javaModels[] = {
			"epsilon_profiling_test.xmi",
			"test001_java.xmi",
			"emf_cdo-example.xmi",
		},
		javaScripts[] = {
			"java_equals",
			"java_findbugs",
			"java_sequential"
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
		imdbModels[] = {"imdb-small.xmi"};
	
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
		
		allInputs = CollectionUtil.composeArrayListFrom(
			imdbInputs,
			thriftInputs,
			javaInputs,
			cookbookInputs
		);
	}
	
	/**
	 * A list of pre-configured Runnables which will call the execute() method on the provided module.
	 * @param modules A collection of IEvlModules to use in combination with each set of test data.
	 */
	public static Collection<EvlRunConfiguration> getScenarios(List<String[]> testInputs, boolean includeTest, Collection<Supplier<? extends IEvlModule>> moduleGetters, Function<String[], Integer> idCalculator) {
		if (testInputs == null) testInputs = allInputs;
		if (moduleGetters == null) moduleGetters = modules();
		Collection<EvlRunConfiguration> scenarios = EolAcceptanceTestUtil.getScenarios(EvlRunConfiguration.class, testInputs, moduleGetters, idCalculator);
		
		if (includeTest) {
			for (Supplier<? extends IEvlModule> moduleGetter : moduleGetters) {
				IEvlModule evlModule = moduleGetter.get();
				
				scenarios.add(
					EvlRunConfiguration.Builder()
						.withScript(EvlTests.getTestScript(evlModule).toPath())
						.withModel(EvlTests.getTestModel(false))
						.withModule(evlModule)
						.profileExecution(false)
						.showResults(false)
						.withId(testInputs.size()+1)
						.build()
				);
			}
		}
		
		return scenarios;
	}
	
	public static Collection<Supplier<? extends IEvlModule>> modules(boolean includeStandard) {
		return parallelModules(THREADS,
			includeStandard ? EvlModule::new : null,
			p -> new EvlModuleParallelElements(new EvlContextParallel(p)),
			p -> new EvlModuleParallelContextAtoms(new EvlContextParallel(p)),
			p -> new EvlModuleParallelConstraintAtoms(new EvlContextParallel(p)),
			p -> new EvlModuleParallelAnnotation(new EvlContextParallel(p))
		);
	}
	
	// Boilerplate defaults
	public static List<String[]> addAllInputs(String[] scripts, String[] models, String metamodel) {
		return EolAcceptanceTestUtil.addAllInputs(scripts, models, metamodel, "evl", scriptsRoot, modelsRoot, metamodelsRoot);
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

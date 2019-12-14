/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance.firstOrder;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.io.File;
import java.util.ArrayList;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.concurrent.EolModuleParallel;
import static org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil.*;
import org.eclipse.epsilon.eol.engine.test.acceptance.firstOrder.lambda.LambdaExpressionTests;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests the engine internals of the parallel module for consistency with the sequential one.
 * 
 * @author Sina Madani
 * @since 1.6
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EolModuleEquivalenceTests extends EolEquivalenceTests<EolRunConfiguration> {
	
	static final String[] scripts = Stream.of(
			new File(getTestBaseDir(FirstOrderOperationTests.class)),
			new File(getTestBaseDir(LambdaExpressionTests.class))
		)
		.<File> flatMap(f -> Stream.of(f.listFiles()))
		.<String> map(File::getAbsolutePath)
		.filter(fn -> fn.endsWith(".eol"))
		.toArray(String[]::new);
	
	public EolModuleEquivalenceTests(EolRunConfiguration configUnderTest) {
		super(configUnderTest);
	}

	public static Collection<EolRunConfiguration> getScenarios(Collection<Supplier<? extends IEolModule>> moduleConstructors) {
		Collection<EolRunConfiguration> scenarios = new ArrayList<>(scripts.length * moduleConstructors.size());
		for (Supplier<? extends IEolModule> moduleConstructor : moduleConstructors) {
			for (String script : scripts) {
				scenarios.add(EolRunConfiguration.Builder()
					.withScript(script)
					.withModule(moduleConstructor.get())
					.build()
				);
			}
		}
		return scenarios;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpEquivalenceTest(getScenarios(Collections.singleton(EolModule::new)));
	}
	
	@Parameters//(name = "0")	// Don't use this as the Eclipse JUnit view won't show failures!
	public static Collection<EolRunConfiguration> configurations() {
		return getScenarios(parallelModules(THREADS, null, p -> new EolModuleParallel(new EolContextParallel(p))));
	}
	
	@Test
	@Override
	public void _0test0() throws Exception  {
		super.beforeTests();
	}
}

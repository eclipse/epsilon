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
import java.io.IOException;
import java.util.ArrayList;
import org.eclipse.epsilon.common.util.FileUtil;
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
	
	static final String[] scripts;
	
	static {
		scripts = new String[6];
		try {
			scripts[0] = FileUtil.getFileStandalone("LambdaExpressionTests.eol", LambdaExpressionTests.class).getAbsolutePath();
			scripts[1] = FileUtil.getFileStandalone("FirstOrderOperationTests.eol", FirstOrderOperationTests.class).getAbsolutePath();
			scripts[2] = FileUtil.getFileStandalone("FirstOrderOperationAdvancedTests.eol", FirstOrderOperationAdvancedTests.class).getAbsolutePath();
			scripts[3] = FileUtil.getFileStandalone("SequentialFirstOrderOperationTests.eol", SequentialFirstOrderOperationTests.class).getAbsolutePath();
			scripts[4] = FileUtil.getFileStandalone("ParallelFirstOrderOperationTests.eol", ParallelFirstOrderOperationTests.class).getAbsolutePath();
			scripts[5] = FileUtil.getFileStandalone("ParallelFirstOrderOperationEquivalenceTests.eol", ParallelFirstOrderOperationEquivalenceTests.class).getAbsolutePath();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public EolModuleEquivalenceTests(EolRunConfiguration configUnderTest) {
		super(configUnderTest);
	}

	public static Collection<EolRunConfiguration> getScenarios(Collection<Supplier<? extends IEolModule>> moduleConstructors) throws Exception {
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
	public static Collection<EolRunConfiguration> configurations() throws Exception {
		return getScenarios(parallelModules(THREADS, null, p -> new EolModuleParallel(new EolContextParallel(p))));
	}
	
	@Test
	@Override
	public void _0test0() throws Exception  {
		super.beforeTests();
	}
}

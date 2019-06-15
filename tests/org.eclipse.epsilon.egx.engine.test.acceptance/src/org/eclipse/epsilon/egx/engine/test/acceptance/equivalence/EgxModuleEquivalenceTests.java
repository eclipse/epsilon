/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.egx.engine.test.acceptance.EgxAcceptanceTestUtil.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.nio.file.Path;
import java.util.*;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.launch.EgxRunConfiguration;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EgxModuleEquivalenceTests extends EolEquivalenceTests<EgxRunConfiguration> {

	static Map<Path, byte[]> expectedOutput, actualOutput;
	
	public EgxModuleEquivalenceTests(EgxRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(thriftInputs, Collections.singleton(EgxModule::new));
		setUpEquivalenceTest();
		expectedOutput = getOutputFiles();
		deleteOutputDirectories();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deleteOutputDirectories();
	}

	@Parameters//(name = "0")	//Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends IErlRunConfiguration> configurations() {
		return getScenarios(thriftInputs, modules(false));
	}
	
	@Test
	@Override
	public void _test0() throws Exception {
		super.beforeTests();
		actualOutput = getOutputFiles();
		deleteOutputDirectories();
	}
	
	@Test
	public void testEquivalentOutput() throws Exception {
		
		assertEquals(expectedOutput.size(), actualOutput.size());
		assertEquals(expectedOutput.keySet(), actualOutput.keySet());
		
		Collection<byte[]>
			expectedOutputs = expectedOutput.values(),
			actualOutputs = actualOutput.values();
		
		Iterator<byte[]> actualIter = actualOutputs.iterator();
		for (byte[] expectedBytes : expectedOutputs) {
			assert actualIter.hasNext();
			byte[] actualBytes = actualIter.next();
			assertArrayEquals(expectedBytes, actualBytes);
		}
	}
}

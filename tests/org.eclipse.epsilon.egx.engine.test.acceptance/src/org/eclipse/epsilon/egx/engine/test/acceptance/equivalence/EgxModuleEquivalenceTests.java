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

	public EgxModuleEquivalenceTests(EgxRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpEquivalenceTest(getScenarios(allInputs, Collections.singleton(EgxModule::new)));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deleteOutputDirectories();
	}

	@Parameters//(name = "0")	// Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends EgxRunConfiguration> configurations() throws Exception {
		return getScenarios(allInputs, modules(false));
	}
	
	@Test
	@Override
	public void _0test0() throws Exception {
		super.beforeTests();
	}
	
	@Test
	public void testEquivalentOutput() throws Exception {
		Map<Path, byte[]>
			expectedOutput = getResult(expectedConfig),
			actualOutput = getResult(testConfig);
		
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

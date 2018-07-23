/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eugenia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.junit.Test;


/**
 * Tests for the optional attributes in the Eugenia Ant task.
 */
public class EugeniaOptionalAttributeTest extends EugeniaTest {

	private static final String CASE_NAME = "friends";

	public EugeniaOptionalAttributeTest() {
		super(CASE_NAME);
	}

	@Test
	public void lastStep() throws Exception {
		// If lastStep="genmodel" is honored, the .genmodel model should exist,
		// and the GMF models should have been cleaned up.
		final long tstampBeforeGenmodel = getModelModificationStamp("genmodel", true);
		getModelModificationStamp("gmfgraph", true);

		// We need to wait at least a second, to make sure the modification stamp will change
		Thread.sleep(1000);
		runAntTarget("only-last");

		final long tstampAfterGenmodel = getModelModificationStamp("genmodel", true);
		getModelModificationStamp("gmfgraph", false);

		assertNotEquals("The .genmodel model should have changed", tstampBeforeGenmodel, tstampAfterGenmodel);
	}

	@Test
	public void firstAndLastStepsFromGenmodel() throws Exception {
		// If firstStep="genmodel" and lastStep="genmodel" are honored, only
		// the .ecore model should have changed.
		final long tstampBeforeEcore = getModelModificationStamp("ecore", true);
		final long tstampBeforeGenmodel = getModelModificationStamp("genmodel", true);
		final long tstampBeforeGmfMap = getModelModificationStamp("gmfmap", true);

		// We need to wait at least a second, to make sure the modification stamp will change
		Thread.sleep(1000);
		runAntTarget("first-and-last-from-genmodel");

		final long tstampAfterEcore = getModelModificationStamp("ecore", true);
		final long tstampAfterGenmodel = getModelModificationStamp("genmodel", true);
		final long tstampAfterGmfMap = getModelModificationStamp("gmfmap", true);

		assertEquals("The .ecore model should remain as is", tstampBeforeEcore, tstampAfterEcore);
		assertNotEquals("The .genmodel model should have changed", tstampBeforeGenmodel, tstampAfterGenmodel);
		assertEquals("The .gmfmap model should remain as is", tstampBeforeGmfMap, tstampAfterGmfMap);
	}

	@Test
	public void firstAndLastStepsFromEcore() throws Exception {
		// If firstStep="ecore" and lastStep="genmodel" are honored, the .ecore
		// and .genmodel models should have changed, and the GMF models should
		// remain untouched.
		final long tstampBeforeEcore = getModelModificationStamp("ecore", true);
		final long tstampBeforeGenmodel = getModelModificationStamp("genmodel", true);
		final long tstampBeforeGmfMap = getModelModificationStamp("gmfmap", true);

		// We need to wait at least a second, to make sure the modification stamp will change
		Thread.sleep(1000);
		runAntTarget("first-and-last-from-ecore");

		final long tstampAfterEcore = getModelModificationStamp("ecore", true);
		final long tstampAfterGenmodel = getModelModificationStamp("genmodel", true);
		final long tstampAfterGmfMap = getModelModificationStamp("gmfmap", true);

		assertNotEquals("The .ecore model should have changed", tstampBeforeEcore, tstampAfterEcore);
		assertNotEquals("The .genmodel model should have changed", tstampBeforeGenmodel, tstampAfterGenmodel);
		assertEquals("The .gmfmap model should remain as is", tstampBeforeGmfMap, tstampAfterGmfMap);
	}

	/**
	 * Returns the modification timestamp of a file and checks if it exists or not.
	 */
	private long getModelModificationStamp(String extension, boolean shouldExist) {
		final String modelPath = RES_PREFIX + CASE_NAME + "/" + CASE_NAME + "." + extension;
		final IFile modelFile = getTestProject().getFile(new Path(modelPath));
		final long value = modelFile.getModificationStamp();

		if (shouldExist) {
			assertNotEquals("The model with path " + modelPath + " should exist", IFile.NULL_STAMP, value);
		} else {
			assertEquals("The model with path " + modelPath + " should not exist", IFile.NULL_STAMP, value);
		}

		return value;
	}

	private void assertNotEquals(String msg, long expected, long obtained) {
		assertTrue(msg, expected != obtained);
	}

}

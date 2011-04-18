/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eunit;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.epsilon.eunit.EUnitModule;
import org.junit.Test;

/**
 * Test cases for the EGL integration in EUnit. Note that the
 * creation and deletion of the 'generated' directory is done
 * from the .eunit files themselves. This should help test
 * <code>@teardown</code>, which didn't have any tests until now.
 *
 * @author Antonio Garcia-Dominguez
 */
public class EUnitWithEGLTests extends EUnitTestCase {

	@Test
	public void fileTests() throws Exception {
		runTarget(ANT_BUILD_FILE, "egl-file-tests");
		checkOutput(new File(BASE_DIR, "TEST-default.file-tests.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"expectedModelGeneratesExpectedFile",
					"expectedModelGeneratesExpectedFileFailing",
					"differentModelGeneratesDifferentFile",
					"differentModelGeneratesDifferentFileFailing",
					"missingExpectedPathFailsTest",
					"missingActualPathFailsTest"
				},
				new HashSet<String>(Arrays.asList(
					"expectedModelGeneratesExpectedFileFailing",
					"differentModelGeneratesDifferentFileFailing"
				)),
				new HashSet<String>(Arrays.asList(
					"missingExpectedPathFailsTest",
					"missingActualPathFailsTest"
				)));
	}

	@Test
	public void dirTests() throws Exception {
		runTarget(ANT_BUILD_FILE, "egl-dir-tests");
		String[] passedNames = generateCaseNames("shouldPass", 9);
		String[] failedNames = generateCaseNames("shouldFail", passedNames.length);
		String[] interlaced  = interlace(passedNames, failedNames);

		checkOutput(new File(BASE_DIR, "TEST-default.dir-tests.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				interlaced,
				new HashSet<String>(Arrays.asList(failedNames)),
				new HashSet<String>());
	}

	private String[] interlace(String[] left, String[] right) {
		assert left.length == right.length;
		String[] interlaced = new String[left.length + right.length];
		int j = 0;
		for (int i = 0; i < left.length; ++i) {
			interlaced[j++] = left[i];
			interlaced[j++] = right[i];
		}
		return interlaced;
	}

	private String[] generateCaseNames(final String prefix, final int length) {
		String[] strings = new String[length];
		for (int i = 0; i < strings.length; ++i) {
			strings[i] = prefix + "[" + (i + 1) + "]";
		}
		return strings;
	}
}

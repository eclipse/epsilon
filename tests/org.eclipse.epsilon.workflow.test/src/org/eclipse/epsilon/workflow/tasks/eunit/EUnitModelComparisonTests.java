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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eunit.EUnitModule;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * Tests for the EUnit model comparison assertions.
 *
 * @author Antonio Garcia-Dominguez
 */
public class EUnitModelComparisonTests extends EUnitTestCase {

	@Test
	public void compareEMFWithEMF() throws Exception {
		runBasicTests("emf-emf");
	}

	@Test
	public void compareEMFWithEMFWithModelReferences() throws Exception {
		runBasicTests("emf-emf-refs");
	}

	@Test
	public void compareEMFWithEMFUsingGeneratedModels() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-generated");
	}

	@Test
	public void compareEMFWithEMFCopy() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-copy");
	}

	@Test
	public void compareEMFInMemoryModels() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-memory");
	}

	@Test
	public void leftModelIsEmpty() throws Exception {
		try {
			runTarget(ANT_BUILD_FILE, "emf-emf-empty-left");
			fail("Expected a BuildException");
		} catch (BuildException ex) {
			if (!(ex.getCause() instanceof EolAssertionException)) {
				fail("Expected an EolAssertionException");
			}
			final EolAssertionException assEx = (EolAssertionException)ex.getCause();
			assertThat(assEx.getMessage(), containsString("Expected B to be also empty, but it is not"));
			assertThat(assEx.getDelta(), is(notNullValue()));
		}
	}

	@Test
	public void rightModelIsEmpty() throws Exception {
		try {
			runTarget(ANT_BUILD_FILE, "emf-emf-empty-right");
			fail("Expected a BuildException");
		} catch (BuildException ex) {
			if (!(ex.getCause() instanceof EolAssertionException)) {
				fail("Expected an EolAssertionException");
			}
			final EolAssertionException assEx = (EolAssertionException)ex.getCause();
			assertThat(assEx.getMessage(), containsString("Expected B to be equal to A, but it is empty"));
			assertThat(assEx.getDelta(), is(notNullValue()));
		}
	}

	@Test
	public void bothModelsAreEmpty() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-empty-both");
	}

	@Test
	public void leftModelIsEmptyNotEquals() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-empty-left-noteq");
	}

	@Test
	public void rightModelIsEmptyNotEquals() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-empty-right-noteq");
	}

	@Test
	public void bothModelsAreEmptyNotEquals() throws Exception {
		try {
			runTarget(ANT_BUILD_FILE, "emf-emf-empty-both-noteq");
			fail("Expected a BuildException");
		} catch (BuildException ex) {
			if (!(ex.getCause() instanceof EolAssertionException)) {
				fail("Expected an EolAssertionException");
			}
			final EolAssertionException assEx = (EolAssertionException)ex.getCause();
			assertThat(assEx.getMessage(), containsString("Expected B not to be empty, but it is empty"));
			assertThat(assEx.getDelta(), is(nullValue()));
		}
	}

	private void runBasicTests(String targetName) throws IOException,
			SAXException, ParserConfigurationException {
		runTarget(ANT_BUILD_FILE, targetName);
		checkOutput(new File(BASE_DIR, "TEST-default.emf-emf.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"sameModelsAreEqual[1]", "sameModelsAreEqual[2]", "sameModelsAreEqual[3]",
					"modelsFromDifferentMetamodelsAreDifferent[1]",
					"modelsFromDifferentMetamodelsAreDifferent[2]",
					"modelsWithDifferentContentAreDifferent",
					"modelsWithDifferentContentAreDifferentFailing",
					"transformedIsEqualToExpected",
					"transformedIsEqualToExpectedFailing"
				},
				new HashSet<String>(
					Arrays.asList(
						"modelsWithDifferentContentAreDifferentFailing",
						"transformedIsEqualToExpectedFailing")),
				new HashSet<String>());
	}

}

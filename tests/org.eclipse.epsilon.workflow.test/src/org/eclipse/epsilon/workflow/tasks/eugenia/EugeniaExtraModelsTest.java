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

import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

/**
 * Tests for the capability to use additional models in the Eugenia
 * polishing transformations.
 */
public class EugeniaExtraModelsTest extends EugeniaTest {

	private static final String CASE_NAME = "flowchartextra";
	private static final String[] CASE_FILES = new String[]{
		"ECore2GMF.eol", "FixGMFGen.eol", CASE_NAME + ".emf",
		"labels.ecore", "labels.model", "tests.eunit"
	};

	public EugeniaExtraModelsTest() {
		super(CASE_NAME);
	}

	@Override
	public void copyCaseFiles() throws CoreException {
		for (String extraFile : CASE_FILES) {
			copyIntoProject(RES_PREFIX + CASE_NAME + "/" + extraFile);
		}
	}

	@Test
	public void useExtraModelForGmfGraph() throws Exception {
		runAntTarget("extra-models");
	}
}

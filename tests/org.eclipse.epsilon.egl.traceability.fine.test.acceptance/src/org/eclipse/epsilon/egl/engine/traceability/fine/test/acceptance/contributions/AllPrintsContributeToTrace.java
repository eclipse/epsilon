/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.contributions;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EPackageBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.Test;

public class AllPrintsContributeToTrace extends EglFineGrainedTraceabilityAcceptanceTest {

	// print, prinx, printdyn, println
	
	private static final EPackage model = aMetamodel().with(anEClass().named("Person")).build();
	
	@Test
	public void print() throws Exception {
		printTest("print");
	}
	
	@Test
	public void prinx() throws Exception {
		printTest("prinx");
	}
	
	@Test
	public void println() throws Exception {
		printTest("println");
	}
	
	@Test
	public void printdyn() throws Exception {
		printTest("printdyn");
	}

	private void printTest(String methodName) throws Exception {
		final String egl = "[% out." + methodName + "(EClass.all.first.name); %]";
		generateTrace(egl, model);
		trace.assertEquals(1, "trace.traceLinks.size()");
	}
}

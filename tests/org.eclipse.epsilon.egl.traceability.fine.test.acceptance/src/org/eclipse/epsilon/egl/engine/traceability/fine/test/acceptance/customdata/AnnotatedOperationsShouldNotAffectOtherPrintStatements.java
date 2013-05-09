/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.customdata;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;
import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EPackageBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotatedOperationsShouldNotAffectOtherPrintStatements extends EglFineGrainedTraceabilityAcceptanceTest {
	
	private static final String egl = "[%=crucial(EClass.all.first)%]"      + NEWLINE +
	                                  "[%=EClass.all.first.name%]"          + NEWLINE +
	                                  "[%"                                  + NEWLINE +
	                                  "$trace Map {'priority' = 'crucial'}" + NEWLINE +
	                                  "operation crucial(c : EClass)  {"    + NEWLINE +
	                                  "   return c.name;"                   + NEWLINE +
	                                  "} %]";

	private static final EClass   person = anEClass().named("Person").build();
	private static final EPackage model  = aMetamodel().with(person).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		generateTrace(egl, model);
	}
	
	@Test
	public void traceShouldHaveTwoTraceLinks() throws Throwable {
		trace.assertEquals(2, "trace.traceLinks.size");
	}
	
	@Test
	public void onlyOneTraceLinkShouldHaveCustomData() {
		trace.assertEquals(1, "trace.traceLinks.reject(tl|tl.customData.isEmpty()).size()");
	}
}

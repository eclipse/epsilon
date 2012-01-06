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
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotatedOperationsCanCreateSeveralCustomDataItems extends EglFineGrainedTraceabilityAcceptanceTest {
	
	private static final String egl = "[%=crucial(EClass.all.first)%]"                        + NEWLINE +
	                                  "[%"                                                    + NEWLINE +
	                                  "$trace Map {'priority' = 'crucial', 'custom' = 'yes'}" + NEWLINE +
	                                  "operation crucial(c : EClass)  {"                      + NEWLINE +
	                                  "   return c.name;"                                     + NEWLINE +
	                                  "} %]";

	private static final EClass   person = anEClass().named("Person").build();
	private static final EPackage model  = aMetamodel().with(person).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		generateTrace(egl, model);
		
		trace.setVariable("traceLink", "trace.traceLinks.first");
	}
	
	@Test
	public void customDataShouldHaveTwoDataItems() throws Throwable {
		trace.assertEquals(2, "traceLink.customData.size");
	}
	
	@Test
	public void firstDataItemShouldHaveValuesFromAnnotation() {
		trace.assertEquals("priority", "traceLink.customData.keySet.first");
		trace.assertEquals("crucial",  "traceLink.customData.values.first");
	}
	
	@Test
	public void secondDataItemShouldHaveValuesFromAnnotation() {
		trace.assertEquals("custom", "traceLink.customData.keySet.second");
		trace.assertEquals("yes",    "traceLink.customData.values.second");
	}
}

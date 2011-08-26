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
package org.eclipse.epsilon.egl.test.acceptance.traceability.sections;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;
import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.test.acceptance.traceability.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class DynamicOutputSectionsContributeToTrace extends EglFineGrainedTraceabilityAcceptanceTest {

	// TODO: location should be updated when generating to a file
	
	private static final String egl = "[%=EClass.all.first.name%]";

	private static final EClass   person = anEClass().named("Person").build();
	private static final EPackage model  = aMetamodel().with(person).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		generateTrace(egl, model);
		
		trace.setVariable("element", "trace.elements.first");
	}
	
	@Test
	public void sourceShouldBeTheNameAttributeOfPerson() throws Throwable {
		assertEquals(person, trace.evaluate("element.source.modelElement"));
		trace.assertEquals("name", "element.source.featureName");
	}
	
	@Test
	public void destinationShouldStartAtBeginningOfFirstLine() {
		trace.assertEquals(1, "element.destination.region.start.line");
		trace.assertEquals(1, "element.destination.region.start.column");
	}
	
	@Test
	public void destinationShouldEndAtTheEndOfTheValue() {
		trace.assertEquals(1,                     "element.destination.region.end.line");
		trace.assertEquals("Person".length() + 1, "element.destination.region.end.column");
	}
}

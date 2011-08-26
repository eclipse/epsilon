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
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.misc;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubtemplateTraceShouldBeAdjustedWhenContributedToParent extends EglFineGrainedTraceabilityAcceptanceTest {

	//                                 12345678901
	private static final String egl = "EClasses: [%=TemplateFactory.prepare(openOutputTag + 'EClass.all.first.name' + closeTag).process()%]";

	private static final EPackage model = aMetamodel().with(anEClass().named("Person")).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		generateTrace(egl, model);
	}
	
	@Test
	public void thereShouldBeOneTraceElement() {
		trace.assertEquals(1, "trace.elements.size()");
	}
	
	@Test
	public void elementShouldStartAfterTextEmittedByParent() {
		trace.assertEquals(1,  "trace.elements.first.destination.region.start.line");		
		trace.assertEquals(11, "trace.elements.first.destination.region.start.column");		
	}
}

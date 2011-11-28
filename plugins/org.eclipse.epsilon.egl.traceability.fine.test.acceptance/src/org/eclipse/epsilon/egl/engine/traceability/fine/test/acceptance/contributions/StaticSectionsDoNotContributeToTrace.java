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
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.contributions;

import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class StaticSectionsDoNotContributeToTrace extends EglFineGrainedTraceabilityAcceptanceTest {

	private static final String egl = "Hello world!";

	private static final EPackage model = aMetamodel().build();
	
	@BeforeClass
	public static void setup() throws Exception {
		generateTrace(egl, model);	
	}
	
	@Test
	public void thereShouldBeNoTraceElements() {
		trace.assertEquals(0, "trace.elements.size()");
	}
	
	@Test
	public void thereShouldBeNoTextLocations() {
		trace.assertEquals(0, "trace.locations.size()");
	}	
}
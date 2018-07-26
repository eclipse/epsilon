/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.subtemplates;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EPackageBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubtemplateShouldContributeToTraceOfParent extends EglFineGrainedTraceabilityAcceptanceTest {

	private static final String egl = "[%=TemplateFactory.prepare(openOutputTag + 'EClass.all.first.name' + closeTag).process()%]";

	private static final EPackage model = aMetamodel().with(anEClass().named("Person")).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		generateTrace(egl, model);
	}
	
	@Test
	public void thereShouldBeOneTraceLink() throws Throwable {
		trace.assertEquals(1, "trace.traceLinks.size()");
	}
	
	@Test
	public void destinationShouldStartAtTheOrigin() {
		trace.assertEquals(0, "trace.traceLinks.first.destination.region.offset");		
	}	
}

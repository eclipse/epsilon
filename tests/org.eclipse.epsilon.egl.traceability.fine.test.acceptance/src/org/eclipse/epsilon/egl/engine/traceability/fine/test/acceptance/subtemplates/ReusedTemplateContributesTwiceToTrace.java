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
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.subtemplates;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EPackageBuilder.aMetamodel;

import java.io.File;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.EglFineGrainedTraceabilityAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReusedTemplateContributesTwiceToTrace extends EglFineGrainedTraceabilityAcceptanceTest {
	
	
	private static final String egl = "[% var template = TemplateFactory.prepare(openOutputTag + 'EClass.all.first.name' + closeTag); %]" +
	                                  "[% template.generate('Out.txt'); %]" +
	                                  "[% template.generate('Out2.txt'); %]";

	private static final EClass   person = anEClass().named("Person").build();
	private static final EPackage model  = aMetamodel().with(person).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		deleteOutputFile("Out.txt");
		deleteOutputFile("Out2.txt");
		
		generateTrace(egl, model);
	}
	
	@Test
	public void thereShouldBeTwoTraceLinks() {
		trace.assertEquals(2, "trace.traceLinks.size()");
	}
	
	@Test
	public void firstDestinationResourceShouldBeFirstFile() {
		final File generatedFile = new File(getOutputPath(), "Out.txt"); 
		trace.assertEquals(generatedFile.getAbsolutePath(), "trace.traceLinks.first.destination.resource");
	}
	
	@Test
	public void secondDestinationResourceShouldBeSecondFile() {
		final File generatedFile = new File(getOutputPath(), "Out2.txt"); 
		trace.assertEquals(generatedFile.getAbsolutePath(), "trace.traceLinks.second.destination.resource");
	}
//	
//	@Test
//	public void destinationShouldEndAtTheEndOfTheValue() {
//		trace.assertEquals("Person".length(), "element.destination.region.length");
//	}
}

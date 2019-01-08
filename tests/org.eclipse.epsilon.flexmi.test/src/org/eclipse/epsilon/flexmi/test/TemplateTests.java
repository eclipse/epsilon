/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.test;

import org.eclipse.epsilon.flexmi.FlexmiResource;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TemplateTests extends FlexmiTests {
	
	@Test
	public void testModelWithTemplate() throws Exception {
		FlexmiResource resource = loadResource("templates/model-with-template.flexmi");
		
		assertEquals(0, resource.getWarnings().size());
		assertEquals(2, resource.getTemplates().size());
		assertEquals("t1", resource.getTemplates().get(0).getName());
		assertEquals("p", resource.getTemplates().get(0).getParameters().get(0));
		
	}
	
	@Test
	public void testTemplateApplicationContents() throws Exception {
		assertEval("EAttribute.all.at(0).name", "a1", "templates/model-with-template.flexmi");		
	}
	
	@Test
	public void testTemplateSlot() throws Exception {
		assertEval("EClass.all.third().eStructuralFeatures.name", Arrays.asList("a1", "a2"), "templates/model-with-template.flexmi");		
		assertEval("EClass.all.fourth().eStructuralFeatures.name", Arrays.asList("a3"), "templates/model-with-template.flexmi");		
		assertEval("EClass.all[4].eStructuralFeatures.name", Arrays.asList("a4", "a5"), "templates/model-with-template.flexmi");
		assertEval("EClass.all.exists(c|c.name='C4')", true, "templates/model-with-template.flexmi");
	}
	
	@Test
	public void testModelWithImportedTemplate() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-imported-template.flexmi");
	}
	
	@Test
	public void testModelWithImportedTemplates() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "O1", "templates/model-with-imported-templates.flexmi");
		assertEval("EPackage.all.first().eClassifiers.at(1).name", "C2", "templates/model-with-imported-templates.flexmi");
	}

	@Test
	public void testModelWithParameterisedTemplate() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-parameterised-template.flexmi");
		assertEval("EAttribute.all.first().name", "a1", "templates/model-with-parameterised-template.flexmi");
	}

	@Test
	public void testModelWithNestedTemplates() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-nested-templates.flexmi");
		assertEval("EAttribute.all.first().name", "a1", "templates/model-with-nested-templates.flexmi");
	}
	
	@Test
	public void testModelWithMultiElementTemplate() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-multi-element-template.flexmi");
		assertEval("EPackage.all.first().eClassifiers.at(1).name", "C2", "templates/model-with-multi-element-template.flexmi");
	}
	
	@Test
	public void testTemplateInstantiation() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-template.flexmi");
		assertEval("EPackage.all.second().eClassifiers.at(0).name", "C2", "templates/model-with-template.flexmi");
		
	}
	
	@Test
	public void testModelWithEolTemplates() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-eol-templates.flexmi");
		assertEval("EPackage.all.first().eClassifiers.size()", 10, "templates/model-with-eol-templates.flexmi");
		assertEval("EPackage.all.second().eClassifiers.at(0).name", "C11", "templates/model-with-eol-templates.flexmi");
		assertEval("EPackage.all.third().eClassifiers.size()", 5, "templates/model-with-eol-templates.flexmi");
		assertEval("EPackage.all.fourth().eClassifiers.size()", 5, "templates/model-with-eol-templates.flexmi");
	}
	
	@Test
	public void testModelWithEglTemplates() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-egl-templates.flexmi");
		assertEval("EPackage.all.first().eClassifiers.size()", 10, "templates/model-with-egl-templates.flexmi");
		assertEval("EPackage.all.second().eClassifiers.at(0).name", "C11", "templates/model-with-egl-templates.flexmi");
		assertEval("EPackage.all.third().eClassifiers.size()", 5, "templates/model-with-egl-templates.flexmi");
		assertEval("EPackage.all.fourth().eClassifiers.size()", 5, "templates/model-with-egl-templates.flexmi");
	}
	
	@Test
	public void testModelWithEglTemplateImportingEOL() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-egl-template-importing-eol.flexmi");
		assertEval("EPackage.all.second().eClassifiers.at(0).name", "C2", "templates/model-with-egl-template-importing-eol.flexmi");

	}
	
	@Test
	public void testModelWithEolTemplateImportingEOL() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-eol-template-importing-eol.flexmi");
		assertEval("EPackage.all.second().eClassifiers.at(0).name", "C2", "templates/model-with-eol-template-importing-eol.flexmi");

	}
}

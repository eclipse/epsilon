package org.eclipse.epsilon.flexmi.test;

import org.eclipse.epsilon.flexmi.FlexmiResource;
import static org.junit.Assert.*;
import org.junit.Test;

public class TemplateTests extends FlexmiTests {
	
	@Test
	public void testModelWithTemplate() throws Exception {
		FlexmiResource resource = loadResource("templates/model-with-template.flexmi");
		
		assertEquals(0, resource.getWarnings().size());
		assertEquals(1, resource.getTemplates().size());
		assertEquals("t1", resource.getTemplates().get(0).getName());
		assertEquals("p1", resource.getTemplates().get(0).getParameters().get(0));
		
	}
	
	@Test
	public void testTemplateApplicationContents() throws Exception {
		assertEval("EAttribute.all.at(0).name", "a1", "templates/model-with-template.flexmi");		
	}
	
	@Test
	public void testModelWithImportedTemplate() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-imported-template.flexmi");
	}
	
	@Test
	public void testModelWithUnknownTemplate() throws Exception {
		FlexmiResource resource = loadResource("templates/model-with-unknown-template.flexmi");
		assertEquals(1, resource.getWarnings().size());
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
	}
	
}

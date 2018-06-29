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
	public void testTemplateInstantiation() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.at(0).name", "C1", "templates/model-with-template.flexmi");
	}
	
}

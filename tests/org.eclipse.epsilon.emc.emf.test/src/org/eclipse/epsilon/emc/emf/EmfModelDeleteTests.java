package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.junit.Test;

public class EmfModelDeleteTests {
	
	@Test
	public void unregisteredMetamodelResultsInEpsilonException() throws Exception {
		
		EmfModel model = EmfModelFactory.getInstance().loadEmfModel("Ecore", new File("model/Delete.ecore"), EcorePackage.eINSTANCE.getNsURI(), AccessMode.READ_ONLY);	
		model.setCachingEnabled(true);
		
		assertEquals(1,model.getAllOfType("EClass").size());
		assertEquals(1, model.getAllOfKind("EOperation").size());
		assertEquals(1, model.getAllOfType("EParameter").size());
		
		model.deleteElement(model.getAllOfType("EClass").iterator().next());
		
		assertEquals(0, model.getAllOfKind("EOperation").size());
		assertEquals(0, model.getAllOfType("EParameter").size());
		
	}
	
}

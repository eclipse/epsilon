package org.eclipse.epsilon.flexmi.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompsTests extends FlexmiTests {
	protected EPackage comps = null;
	
	@Test
	public void testInPorts() throws Exception {
		assertEval("Component.all.first().inPorts.size()", 1, "comps/comp-with-ports.flexmi");
	}
	
	@Test
	public void testOutPorts() throws Exception {
		assertEval("Component.all.first().outPorts.size()", 1, "comps/comp-with-ports.flexmi");
	}
	
	@Before
	public void setup() throws Exception {
		comps = EmfUtil.register(URI.createURI(
			FlexmiTestSuite.class.getResource("models/comps/comps.ecore").toURI().toString()), 
				EPackage.Registry.INSTANCE).get(0);
	}
	
	@After
	public void teardown() {
		EPackage.Registry.INSTANCE.remove(comps.getNsURI());
	}
	
}

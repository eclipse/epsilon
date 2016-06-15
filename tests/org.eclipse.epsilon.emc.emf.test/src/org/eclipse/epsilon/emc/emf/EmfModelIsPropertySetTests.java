/*******************************************************************************
 * Copyright (c) 2016 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.junit.Before;
import org.junit.Test;

public class EmfModelIsPropertySetTests {

	private EmfModel model;

	@Before
	public void setUp() throws EolModelLoadingException, URISyntaxException {
		model = new EmfModel();
		model.setMetamodelFileUri(URI.createURI(EmfModelIsPropertySetTests.class.getResource("DefaultValue.ecore").toURI().toString()));
		model.setModelFile("model/dummy.model");
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.load();
	}
	
	@Test
	public void defaultValueTest() throws Exception {
		EObject eob = model.createInstance("DVTestModel");

		final String pname = "count";
		assertTrue("The type should know about 'count'", model.knowsAboutProperty(eob, pname));
		assertEquals("The instance should have a default value for 'count'", 0, model.getPropertyGetter().invoke(eob, pname));
		assertFalse("The instance should know that 'count' has not been explicitly set", model.isPropertySet(eob, pname));

		final IReflectivePropertySetter setter = model.getPropertySetter();
		setter.setObject(eob);
		setter.setProperty("count");
		setter.invoke(0);
		assertEquals("count should be 0", 0, model.getPropertyGetter().invoke(eob, pname));
		assertFalse("count is equal to the default, so EMF should still report it as unset", model.isPropertySet(eob, pname));

		setter.invoke(1);
		assertEquals("count should be 1", 1, model.getPropertyGetter().invoke(eob, pname));
		assertTrue("count is not equal to the default, so it is now reported as set", model.isPropertySet(eob, pname));

		setter.invoke(null);
		assertEquals("count should be back to the default 0 after being unset", 0, model.getPropertyGetter().invoke(eob, pname));
		assertFalse("count should have been unset", model.isPropertySet(eob, pname));
	}
}

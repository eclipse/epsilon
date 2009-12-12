package org.eclipse.epsilon.hutn.xmi.dt.startup;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.hutn.xmi.dt.startup.RegisteredMetamodels;
import org.junit.Test;

/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */

public class RegisteredMetamodelsTests {

	@Test
	public void shouldReturnFileExtensionsOfAllRegisteredMetamodels() {
		final Registry registry = Resource.Factory.Registry.INSTANCE;
		
		registry.getExtensionToFactoryMap().put("ecore",    new EcoreResourceFactoryImpl());
		registry.getExtensionToFactoryMap().put("genmodel", new EcoreResourceFactoryImpl());
		
	
		final Collection<String> fileExtensionsOfAllRegisteredMetamodels = RegisteredMetamodels.getInstance().getFileExtensionsOfAllRegisteredMetamodels();
		
		assertThat(fileExtensionsOfAllRegisteredMetamodels, containsInAnyOrder("ecore", "genmodel"));
		assertThat(fileExtensionsOfAllRegisteredMetamodels, not(contains("uml")));
	}
}

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public class InMemoryEmfModel extends EmfModel {
	
	public InMemoryEmfModel(String name, Resource modelImpl, EPackage... ePackages) {
		init(name, modelImpl, Arrays.asList(ePackages));
	}
	
	public InMemoryEmfModel(String name, Resource modelImpl, String... nsUris) {
		
		Collection<EPackage> ePackages = new ArrayList<EPackage>();
		
		for (String nsUri : nsUris) {
			ePackages.add(EPackage.Registry.INSTANCE.getEPackage(nsUri));
		}
		init(name, modelImpl, ePackages);
	}

	public InMemoryEmfModel(Resource modelImpl) {
		init("Model", modelImpl, Collections.<EPackage> emptyList());
	}
	
	public InMemoryEmfModel(String name, Resource modelImpl) {
		init(name, modelImpl, Collections.<EPackage> emptyList());
	}
	
	public InMemoryEmfModel(String name, Resource modelImpl, Collection<EPackage> ePackages) {
		init(name, modelImpl, ePackages);
	}
	
	public boolean getExpand() { return true; }
	
	protected void init(String name, Resource modelImpl, Collection<EPackage> ePackages) {
		
		setName(name);
		this.modelImpl = modelImpl;
		this.expand = getExpand();

		// If there is no ResourceSet we cannot register or call the resource creation factory
		if(modelImpl.getResourceSet() != null) {
			modelImpl.getResourceSet().setResourceFactoryRegistry(Resource.Factory.Registry.INSTANCE);
		}

		if (ePackages == null || ePackages.isEmpty()) {
			// No additional packages are provided, so just use the global registry,
			// instead of the delegate registry that ResourceSetImpl would create
			
			// If there is no ResourceSet available, AbstractEmfModel#getPackageRegistry()
			// already returns the global registry, so no need to worry about this
			if(modelImpl.getResourceSet() != null) {
				modelImpl.getResourceSet().setPackageRegistry(EPackage.Registry.INSTANCE);
			}
		}
		else {
			for (EPackage ePackage : ePackages) {
				getPackageRegistry().put(ePackage.getNsURI(), ePackage);
				
				//Added : Collect dependencies
				
				List<EPackage> dependencies =  new ArrayList<EPackage>();
				EmfUtil.collectDependencies(ePackage, dependencies);
				for (EPackage dependency : dependencies) {
					getPackageRegistry().put(dependency.getNsURI(), dependency);	
				}
			}
		}
		
		this.setupContainmentChangeListeners();
	}
	
	@Override
	public void loadModel() {
		// In-memory models should not be loaded
	}
}

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public class InMemoryEmfModel extends EmfModel {
	
	public InMemoryEmfModel(String name, Resource modelImpl, EPackage... ePackages) {
		init(name, modelImpl, Arrays.asList(ePackages), true);
	}
	
	public InMemoryEmfModel(String name, Resource modelImpl, String... nsUris) {
		Collection<EPackage> ePackages = new ArrayList<>();
		for (String nsUri : nsUris) {
			ePackages.add(EPackage.Registry.INSTANCE.getEPackage(nsUri));
		}
		init(name, modelImpl, ePackages, true);
	}

	public InMemoryEmfModel(Resource modelImpl) {
		this(modelImpl, true);
	}

	public InMemoryEmfModel(Resource modelImpl, boolean isContainerListenerEnabled) {
		init("Model", modelImpl, Collections.<EPackage> emptyList(), isContainerListenerEnabled);
	}

	public InMemoryEmfModel(String name, Resource modelImpl) {
		this(name, modelImpl, Collections.<EPackage> emptyList(), true);
	}
	
	public InMemoryEmfModel(String name, Resource modelImpl, boolean isContainerListenerEnabled) {
		init(name, modelImpl, Collections.<EPackage> emptyList(), isContainerListenerEnabled);
	}

	public InMemoryEmfModel(String name, Resource modelImpl, Collection<EPackage> ePackages) {
		this(name, modelImpl, ePackages, true);
	}
	
	public InMemoryEmfModel(String name, Resource modelImpl, Collection<EPackage> ePackages, boolean isContainerListenerEnabled) {
		init(name, modelImpl, ePackages, isContainerListenerEnabled);
	}

	public boolean getExpand() { return true; }
	
	protected void init(String name, Resource modelImpl, Collection<EPackage> ePackages, boolean isContainerListenerEnabled) {
		
		setName(name);
		this.modelImpl = modelImpl;
		this.expand = getExpand();

		// If there is no ResourceSet we cannot register or call the resource creation factory
		if(modelImpl.getResourceSet() != null) {
			modelImpl.getResourceSet().setResourceFactoryRegistry(Resource.Factory.Registry.INSTANCE);
		}

		if (ePackages == null || ePackages.isEmpty()) {
			// No additional packages are provided, so if the package registry of 
			// the local resource registry is empty, use the global registry instead
			
			// If there is no ResourceSet available, AbstractEmfModel#getPackageRegistry()
			// already returns the global registry, so no need to worry about this
			if(modelImpl.getResourceSet() != null && modelImpl.getResourceSet().getPackageRegistry().isEmpty()) {
				modelImpl.getResourceSet().setPackageRegistry(EPackage.Registry.INSTANCE);
			}
		}
		else {
			for (EPackage ePackage : ePackages) {
				getPackageRegistry().put(ePackage.getNsURI(), ePackage);
				
				//Added : Collect dependencies
				
				List<EPackage> dependencies =  new ArrayList<>();
				EmfUtil.collectDependencies(ePackage, dependencies);
				for (EPackage dependency : dependencies) {
					getPackageRegistry().put(dependency.getNsURI(), dependency);	
				}
			}
		}

		boolean bHasCachedContentsAdapter = false;
		for (Adapter adapter : modelImpl.eAdapters()) {
			if (adapter instanceof CachedContentsAdapter) {
				bHasCachedContentsAdapter = true;
				break;
			}
		}
		if (!bHasCachedContentsAdapter) {
			modelImpl.eAdapters().add(new CachedContentsAdapter());
		}

		if (isContainerListenerEnabled) {
			this.setupContainmentChangeListeners();
		}
	}

	@Override
	public void loadModel() {
		// In-memory models should not be loaded
	}
}

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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class EmfMetaModel extends AbstractEmfModel {
	
	public static final String PROPERTY_METAMODEL_URI = "metamodelUri";
	
	protected String metamodelUri;
	
	public EmfMetaModel() {
		super();
	}
	
	public EmfMetaModel(String metamodelUri) {
		this.metamodelUri = metamodelUri;
	}
	
	public EmfMetaModel(String name, String metamodelUri) {
		setName(name);
		this.metamodelUri = metamodelUri;
	}


	@Override
	public void loadModel() throws EolModelLoadingException {
		this.expand = false;
		
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
		
		if (ePackage != null) {
			this.modelImpl = ePackage.eResource();
		}
		else {
			throw new EolModelLoadingException(new Exception("Package with URI " + metamodelUri + " not found"), this);
		}
	}

	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		this.metamodelUri = properties.getProperty(PROPERTY_METAMODEL_URI);
		load();
	}
	
	/*
	Registry registry = null;
	@Override
	protected Registry getPackageRegistry() {
		if (registry == null) {
			registry = new EPackageRegistryImpl();
			registry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		return registry;
	}*/

	public boolean store() {
		return false;
	}

	public String getMetamodelUri() {
		return metamodelUri;
	}

	public void setMetamodelUri(String metamodelUri) {
		this.metamodelUri = metamodelUri;
	}
	
}

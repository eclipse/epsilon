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
package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public final class EmfModelFactory {

	private static EmfModelFactory instance = new EmfModelFactory();
	
	private EmfModelFactory() {}
	
	public static EmfModelFactory getInstance() {
		return instance;
	}
	
	/**
	 * The metamodel parameter can be of type EPackage, File or URI. Any other
	 * type will cause an IllegalArgumentException to be raised.
	 */
	public EmfModel createEmfModel(String name, File model, Object metamodel) {
		final EmfModel emfModel = createEmfModel(name, model);
		
		if (metamodel instanceof String) {
			emfModel.setMetamodelFileBased(false);
			emfModel.setMetamodelUri((String) metamodel);
		
		} else if (metamodel instanceof EPackage) {
			emfModel.setMetamodelFileBased(false);
			emfModel.setMetamodelUri(((EPackage)metamodel).getNsURI());
		
		} else if (metamodel instanceof EPackage[]) {
			final List<String> nsUris = new LinkedList<String>();
			for (EPackage p : (EPackage[])metamodel)
				nsUris.add(p.getNsURI());
			
			emfModel.setMetamodelUris(nsUris);
			
		} else if (metamodel instanceof File) {
			emfModel.setMetamodelFileBased(true);
			emfModel.setMetamodelFile(((File)metamodel).getAbsolutePath());
		
		} else if (metamodel instanceof URI) {
			emfModel.setMetamodelFileBased(true);
			emfModel.setMetamodelFileUri((URI)metamodel);
			
		} else {
			throw new IllegalArgumentException("Not a recognised metamodel type: " + metamodel.getClass().getCanonicalName());
		}
		
		return emfModel;
	}
	

	/**
	 * The metamodel parameter can be of type EPackage, File or URI. Any other
	 * type will cause an IllegalArgumentException to be raised.
	 */
	public EmfModel createEmfModel(String name, File model, Object metamodel, AccessMode accessMode) {
		final EmfModel emfModel = createEmfModel(name, model, metamodel);
		
		accessMode.applyTo(emfModel);
		
		return emfModel;
	}
	
	
	/**
	 * The metamodel parameter can be of type EPackage, File or URI. Any other
	 * type will cause an IllegalArgumentException to be raised.
	 */
	public EmfModel loadEmfModel(String name, File model, Object metamodel) throws EolModelLoadingException {
		final EmfModel emfModel = createEmfModel(name, model, metamodel);
		
		emfModel.load();
		
		return emfModel;
	}
	
	/**
	 * The metamodel parameter can be of type EPackage, File or URI. Any other
	 * type will cause an IllegalArgumentException to be raised.
	 */
	public EmfModel loadEmfModel(String name, File model, Object metamodel, AccessMode accessMode) throws EolModelLoadingException {
		final EmfModel emfModel = createEmfModel(name, model, metamodel, accessMode);
		
		emfModel.load();
		
		return emfModel;
	}

	
	
	private EmfModel createEmfModel(String name, File model) {
		final EmfModel emfModel = new EmfModel();
		
		emfModel.setName(name);
		emfModel.setModelFile(model.getAbsolutePath());
			
		return emfModel;
	}
	
	
	public enum AccessMode {
		READ_ONLY (true, false),
		WRITE_ONLY(false, true),
		READ_WRITE(true, true);
		
		private final boolean readOnLoad, storedOnDisposal;
		
		private AccessMode(boolean readOnLoad, boolean storedOnDisposal) {
			this.readOnLoad       = readOnLoad;
			this.storedOnDisposal = storedOnDisposal;
		}
		
		public void applyTo(EmfModel model) {
			model.setReadOnLoad(readOnLoad);
			model.setStoredOnDisposal(storedOnDisposal);
		}
	}
}

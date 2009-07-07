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
/**
 * 
 */
package org.eclipse.epsilon.migration.engine.test.util.builders;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;


public class MetamodelBuilder {
	
	public static MetamodelBuilder aMetamodel() {
		return new MetamodelBuilder();
	}

	private final List<EClass> eClasses = new LinkedList<EClass>();
	private String nsURI;
	
	public MetamodelBuilder withNsURI(String nsURI) {
		this.nsURI = nsURI;
		return this;
	}
	
	public MetamodelBuilder with(EClassBuilder eClassBuilder) {
		return with(eClassBuilder.build());
	}
	
	public MetamodelBuilder with(EClass eClass) {
		eClasses.add(eClass);
		return this;
	}
	
	public EPackage build() {
		final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		
		ePackage.setNsURI(nsURI);
		
		for (EClass eClass : eClasses) {
			ePackage.getEClassifiers().add(eClass);
		}
		
		return ePackage;
	}
}
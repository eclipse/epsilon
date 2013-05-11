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
package org.eclipse.epsilon.test.util.builders.emf;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;


public class EPackageBuilder {
	
	public static EPackageBuilder aMetamodel() {
		return new EPackageBuilder();
	}
	
	public static EPackageBuilder anEPackage() {
		return new EPackageBuilder();
	}

	private final List<EPackage> subpackages = new LinkedList<EPackage>();
	private final List<EClassifier> eClassifiers = new LinkedList<EClassifier>();
	private String nsURI, name;
	
	public EPackageBuilder withNsURI(String nsURI) {
		this.nsURI = nsURI;
		return this;
	}

	public EPackageBuilder with(EPackageBuilder ePackageBuilder) {
		return with(ePackageBuilder.build());
	}
	
	public EPackageBuilder with(EPackage ePackage) {
		subpackages.add(ePackage);
		return this;
	}
	
	public EPackageBuilder with(EClassifierBuilder eClassifierBuilder) {
		return with(eClassifierBuilder.build());
	}
	
	public EPackageBuilder with(EClassifier eClassifier) {
		eClassifiers.add(eClassifier);
		return this;
	}
	
	public EPackageBuilder named(String name) {
		this.name = name;
		return this;
	}
	
	public EPackage build() {
		final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		
		ePackage.setName(name);
		ePackage.setNsURI(nsURI);
		
		ePackage.getESubpackages().addAll(subpackages);
		ePackage.getEClassifiers().addAll(eClassifiers);
		
		return ePackage;
	}
}
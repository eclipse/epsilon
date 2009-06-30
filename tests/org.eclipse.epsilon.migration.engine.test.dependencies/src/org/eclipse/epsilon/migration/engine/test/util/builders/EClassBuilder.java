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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;


public class EClassBuilder {
	
	public static EClassBuilder anEClass() {
		return new EClassBuilder();
	}

	private final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
	
	public EClassBuilder named(String name) {
		eClass.setName(name);
		return this;
	}
	
	public EClassBuilder with(EAttributeBuilder eAttributeBuilder) {
		eClass.getEStructuralFeatures().add(eAttributeBuilder.build());
		return this;
	}

	public EClass build() {
		return eClass;
	}
}
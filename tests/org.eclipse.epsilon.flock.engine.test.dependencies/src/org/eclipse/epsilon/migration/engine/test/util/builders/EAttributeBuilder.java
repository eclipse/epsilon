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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class EAttributeBuilder {
	
	public static EAttributeBuilder anEAttribute() {
		return new EAttributeBuilder();
	}

	private final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute(); 
	
	public EAttributeBuilder named(String name) {
		attribute.setName(name);
		return this;
	}

	public EAttributeBuilder withType(EClassifier type) {
		attribute.setEType(type);
		return this;
	}
	
	public EStructuralFeature build() {
		return attribute;
	}
}
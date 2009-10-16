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

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EcoreFactory;

public class EEnumBuilder implements EClassifierBuilder {
	
	public static EEnumBuilder anEEnum() {
		return new EEnumBuilder();
	}

	private final EEnum enumeration = EcoreFactory.eINSTANCE.createEEnum(); 
	
	public EEnumBuilder named(String name) {
		enumeration.setName(name);
		return this;
	}

	public EEnumBuilder withLiteral(String name, int value) {
		enumeration.getELiterals().add(createLiteral(name, value));
		return this;
	}

	private EEnumLiteral createLiteral(String name, int value) {
		final EEnumLiteral literal = EcoreFactory.eINSTANCE.createEEnumLiteral();
		literal.setName(name);
		literal.setLiteral(name);
		literal.setValue(value);
		return literal;
	}
	
	public EEnum build() {
		return enumeration;
	}
}
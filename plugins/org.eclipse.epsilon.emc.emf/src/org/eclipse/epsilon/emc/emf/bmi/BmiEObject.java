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
package org.eclipse.epsilon.emc.emf.bmi;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;

public class BmiEObject extends DynamicEObjectImpl {

	public BmiEObject() {
		super();
	}

	public BmiEObject(EClass eClass) {
		super(eClass);
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return super.eGet(feature);
	}
	
	
	
}

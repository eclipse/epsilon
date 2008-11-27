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

package org.eclipse.epsilon.emc.emf.bridge;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class BridgeDescriptor {
	
	protected EClass eClass;
	protected EReference reference;
	protected EStructuralFeature lastValueFeature;
	
	public EClass getEClass() {
		return eClass;
	}
	
	public void setEClass(EClass eClass) {
		this.eClass = eClass;
	}
	
	public EReference getEReference() {
		return reference;
	}
	
	public void setEReference(EReference reference) {
		this.reference = reference;
	}
	
	public EStructuralFeature getLastValueFeature() {
		return lastValueFeature;
	}

	public void setLastValueFeature(EStructuralFeature lastValueFeature) {
		this.lastValueFeature = lastValueFeature;
	}

	public boolean bridges(EObject eObject, String property) {
		if (reference.getEType().isInstance(eObject)) {
			for (EStructuralFeature sf : eClass.getEAllStructuralFeatures()) {
				if (sf.getName().equals(property)) { 
					this.lastValueFeature = sf; 
					return true; 
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return eClass.getName() + "." + reference.getName();
	}
	
}
 
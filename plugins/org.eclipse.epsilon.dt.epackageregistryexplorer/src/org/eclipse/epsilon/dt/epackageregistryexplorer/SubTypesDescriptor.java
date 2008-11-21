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

package org.eclipse.epsilon.dt.epackageregistryexplorer;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class SubTypesDescriptor {
	
	protected EClass eClass;
	
	public SubTypesDescriptor(EClass eClass) {
		this.eClass = eClass;
	}
	
	public EClass getEClass() {
		return eClass;
	}
	
	public Collection<EClass> getSubtypes(Collection<EPackage> ePackages) {
		
		Collection<EClass> subtypes = new ArrayList<EClass>();
		
		for (EPackage p : ePackages) {
			for (EClassifier o : p.getEClassifiers()) {
				if (o instanceof EClass) {
					EClass eClass = (EClass) o;
					if (eClass.getESuperTypes().contains(this.eClass)) {
						subtypes.add(eClass);
					}
				}
			}
		}
		
		return subtypes;
	}
	
	public boolean hasSubtypes(Collection<EPackage> ePackages) {
		
		Collection<EClass> subtypes = new ArrayList<EClass>();
		
		for (EPackage p : ePackages) {
			for (EClassifier o : p.getEClassifiers()) {
				if (o instanceof EClass) {
					EClass eClass = (EClass) o;
					if (eClass.getESuperTypes().contains(this.eClass)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
 
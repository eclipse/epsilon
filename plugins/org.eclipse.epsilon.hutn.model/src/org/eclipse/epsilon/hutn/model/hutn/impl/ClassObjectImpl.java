/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: ClassObjectImpl.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ClassObjectImpl extends ObjectImpl implements ClassObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HutnPackage.Literals.CLASS_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns an EClass from the specified collection that
	 * matches the type of this Object
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	public EClass getEClass(Collection<EClass> eClasses) {
		if (getType() == null)
			return null;
		
		for (EClass eClass : eClasses) {
			if (getType().equals(eClass.getName())) {
				return eClass;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Indicates whether every Slot contained in this ClassObject
	 * has the same type as some EStructuralFeature contained in eClass
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	public boolean typeCompatibleWith(EClass eClass) {
		for (Slot slot : getSlots()) {
			boolean foundFeature = false;
			int index = 0;
			
			while (!foundFeature && index < eClass.getEAllStructuralFeatures().size()) {
				final EStructuralFeature feature = eClass.getEAllStructuralFeatures().get(index++);
				
				foundFeature = slot.getFeature().equals(feature.getName()) &&
				               slot.typeCompatibleWith(feature);
			}
			
			if (!foundFeature) return false;
		}
		
		return true;
	}

} //ClassObjectImpl

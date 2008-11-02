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
 * $Id: ReferenceSlotImpl.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.impl.ReferenceSlotImpl#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceSlotImpl extends AssociativeSlotImpl implements ReferenceSlot {
	/**
	 * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> identifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HutnPackage.Literals.REFERENCE_SLOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIdentifiers() {
		if (identifiers == null) {
			identifiers = new EDataTypeEList<String>(String.class, this, HutnPackage.REFERENCE_SLOT__IDENTIFIERS);
		}
		return identifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HutnPackage.REFERENCE_SLOT__IDENTIFIERS:
				return getIdentifiers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HutnPackage.REFERENCE_SLOT__IDENTIFIERS:
				getIdentifiers().clear();
				getIdentifiers().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case HutnPackage.REFERENCE_SLOT__IDENTIFIERS:
				getIdentifiers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case HutnPackage.REFERENCE_SLOT__IDENTIFIERS:
				return identifiers != null && !identifiers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (identifiers: ");
		result.append(identifiers);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void append(Slot slot) {
		if (slot instanceof ReferenceSlot) {
			this.getIdentifiers().addAll(((ReferenceSlot)slot).getIdentifiers());
		
		} else {
			throw new IllegalArgumentException("Cannot append the contents of a " + slot.getClass().getSimpleName() + " to a ReferenceSlot");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ClassObject> getClassObjects() {
		final EList<ClassObject> classObjects = new BasicEList<ClassObject>();
		
		for (String identifier : getIdentifiers()) {
			final ClassObject classObject = getClassObject(identifier);
			
			if (classObject != null)
				classObjects.add(classObject);
		}
		
		return classObjects;
	}
	
	private ClassObject getClassObject(String identifier) {
		for (ClassObject classObject : eAllClassObjects()) {
			if (identifier.equals(classObject.getIdentifier())) {
				return classObject;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean typeCompatibleWith(EStructuralFeature feature) {
		if (feature.getEType() instanceof EClass) {
			final EClass type           = (EClass)feature.getEType();
			final List<EClass> eClasses = EmfUtil.getAllEClassesFromSameMetamodelAs(feature);
			
			for (String identifier : getIdentifiers()) {
				final EClass eClass = findClassByIdentifier(identifier, eClasses);
				
				if (eClass != null && !type.isSuperTypeOf(eClass)) {
					return false;
				}
			}
			
			return true;
			
		} else {
			return false;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private EClass findClassByIdentifier(String identifier, Collection<EClass> eClasses) {
		final ClassObject classObject = getClassObject(identifier);
		
		if (classObject != null) {
			return classObject.getEClass();
		}
		
		return null;
	}	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private List<ClassObject> eAllClassObjects() {
		return EmfUtil.getAllModelElementsOfType(this, ClassObject.class);
	}
	
	/**
	 * * <!-- begin-user-doc -->
	 * Returns the size of the contents of this Slot.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	@Override
	protected int getSize() {
		return getIdentifiers().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	@Override
	public void addClassObject(ClassObject classObject) {
		if (classObject.getIdentifier() == null)
			throw new IllegalArgumentException("ClassObjects must have an identifier if they are to be added to a ReferenceSlot.");
		
		getIdentifiers().add(classObject.getIdentifier());
	}
} //ReferenceSlotImpl

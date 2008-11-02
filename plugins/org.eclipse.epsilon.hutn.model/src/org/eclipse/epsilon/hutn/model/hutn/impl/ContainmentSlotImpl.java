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
 * $Id: ContainmentSlotImpl.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectContainer;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.impl.ContainmentSlotImpl#getClassObjects <em>Class Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainmentSlotImpl extends AssociativeSlotImpl implements ContainmentSlot {
	/**
	 * The cached value of the '{@link #getClassObjects() <em>Class Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassObject> classObjects;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainmentSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HutnPackage.Literals.CONTAINMENT_SLOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassObject> getClassObjects() {
		if (classObjects == null) {
			classObjects = new EObjectContainmentWithInverseEList<ClassObject>(ClassObject.class, this, HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS, HutnPackage.CLASS_OBJECT__CONTAINER);
		}
		return classObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the PackageObject that contains this ClassObjectContainer.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PackageObject getPackageObject() {
		return getOwner().getPackageObject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassObjects()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS:
				return ((InternalEList<?>)getClassObjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS:
				return getClassObjects();
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
			case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS:
				getClassObjects().clear();
				getClassObjects().addAll((Collection<? extends ClassObject>)newValue);
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
			case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS:
				getClassObjects().clear();
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
			case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS:
				return classObjects != null && !classObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ClassObjectContainer.class) {
			switch (derivedFeatureID) {
				case HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS: return HutnPackage.CLASS_OBJECT_CONTAINER__CLASS_OBJECTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ClassObjectContainer.class) {
			switch (baseFeatureID) {
				case HutnPackage.CLASS_OBJECT_CONTAINER__CLASS_OBJECTS: return HutnPackage.CONTAINMENT_SLOT__CLASS_OBJECTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void append(Slot slot) {
		if (slot instanceof ContainmentSlot) {
			this.getClassObjects().addAll(((ContainmentSlot)slot).getClassObjects());
		
		} else {
			throw new IllegalArgumentException("Cannot append the contents of a " + slot.getClass().getSimpleName() + " to a ContainmentSlot");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean typeCompatibleWith(EStructuralFeature feature) {	
		if (feature.getEType() instanceof EClass) {
			final EClass type           = (EClass)feature.getEType();
			
			for (ClassObject classObject : getClassObjects()) {
				if (!type.isSuperTypeOf(classObject.getEClass())) {
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
	 * Returns the size of the contents of this Slot.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	@Override
	protected int getSize() {
		return getClassObjects().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	@Override
	public void addClassObject(ClassObject classObject) {
		getClassObjects().add(classObject);
	}
	
} //ContainmentSlotImpl

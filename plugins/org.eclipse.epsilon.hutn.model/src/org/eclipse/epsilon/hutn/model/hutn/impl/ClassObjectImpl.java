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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectContainer;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.impl.ClassObjectImpl#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.impl.ClassObjectImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassObjectImpl extends ObjectImpl implements ClassObject {
	/**
	 * The cached value of the '{@link #getSlots() <em>Slots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlots()
	 * @generated
	 * @ordered
	 */
	protected EList<Slot> slots;

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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Slot> getSlots() {
		if (slots == null) {
			slots = new EObjectContainmentWithInverseEList<Slot>(Slot.class, this, HutnPackage.CLASS_OBJECT__SLOTS, HutnPackage.SLOT__OWNER);
		}
		return slots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassObjectContainer getContainer() {
		if (eContainerFeatureID != HutnPackage.CLASS_OBJECT__CONTAINER) return null;
		return (ClassObjectContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(ClassObjectContainer newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, HutnPackage.CLASS_OBJECT__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(ClassObjectContainer newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID != HutnPackage.CLASS_OBJECT__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, HutnPackage.CLASS_OBJECT_CONTAINER__CLASS_OBJECTS, ClassObjectContainer.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HutnPackage.CLASS_OBJECT__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Finds a slot with the specified feature for this object.
	 * Returns null when no such slot exists.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Slot findSlot(String feature) {
		for (Slot slot : getSlots()) {
			if (feature.equals(slot.getFeature()))
				return slot;
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the PackageObject that contains this ClassObject.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PackageObject getPackageObject() {
		return getContainer().getPackageObject();
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
			case HutnPackage.CLASS_OBJECT__SLOTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSlots()).basicAdd(otherEnd, msgs);
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((ClassObjectContainer)otherEnd, msgs);
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
			case HutnPackage.CLASS_OBJECT__SLOTS:
				return ((InternalEList<?>)getSlots()).basicRemove(otherEnd, msgs);
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				return basicSetContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				return eInternalContainer().eInverseRemove(this, HutnPackage.CLASS_OBJECT_CONTAINER__CLASS_OBJECTS, ClassObjectContainer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HutnPackage.CLASS_OBJECT__SLOTS:
				return getSlots();
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				return getContainer();
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
			case HutnPackage.CLASS_OBJECT__SLOTS:
				getSlots().clear();
				getSlots().addAll((Collection<? extends Slot>)newValue);
				return;
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				setContainer((ClassObjectContainer)newValue);
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
			case HutnPackage.CLASS_OBJECT__SLOTS:
				getSlots().clear();
				return;
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				setContainer((ClassObjectContainer)null);
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
			case HutnPackage.CLASS_OBJECT__SLOTS:
				return slots != null && !slots.isEmpty();
			case HutnPackage.CLASS_OBJECT__CONTAINER:
				return getContainer() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the corresponding EClass in the containing 
	 * PackageObject's metamodel.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	public EClass getEClass() {
		if (getType() == null)
			return null;
		
		for (EClass eClass : getPackageObject().getAllEClasses()) {
			if (getType().equals(eClass.getName())) {
				return eClass;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns true only if this Slot has a corresponding EClass
	 * in the containing PackageObject's metamodel.
	 * @model
	 * @generated NOT
	 */
	public boolean hasEClass() {
		return getEClass() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Indicates whether every Slot contained in this ClassObject is
	 * type compatible with some EStructuralFeature contained in eClass
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

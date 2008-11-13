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
 * $Id: PackageObjectImpl.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ClassObjectContainer;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.impl.PackageObjectImpl#getClassObjects <em>Class Objects</em>}</li>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.impl.PackageObjectImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageObjectImpl extends ObjectImpl implements PackageObject {
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
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> metamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HutnPackage.Literals.PACKAGE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassObject> getClassObjects() {
		if (classObjects == null) {
			classObjects = new EObjectContainmentWithInverseEList<ClassObject>(ClassObject.class, this, HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS, HutnPackage.CLASS_OBJECT__CONTAINER);
		}
		return classObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getMetamodel() {
		if (metamodel == null) {
			metamodel = new EObjectResolvingEList<EPackage>(EPackage.class, this, HutnPackage.PACKAGE_OBJECT__METAMODEL);
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns all of the EClasses contained in this PackageObject's metamodel.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EClass> getAllEClasses() {
		final EList<EClass> eClasses = new BasicEList<EClass>();
		
		if (!getMetamodel().isEmpty()) {
			for (EPackage ePackage : getMetamodel()) {
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						eClasses.add((EClass)eClassifier);
					}
				}
			}
		}

		return eClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the PackageObject that contains this ClassObjectContainer.
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	public PackageObject getPackageObject() {
		return this;
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
			case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS:
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
			case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS:
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
			case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS:
				return getClassObjects();
			case HutnPackage.PACKAGE_OBJECT__METAMODEL:
				return getMetamodel();
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
			case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS:
				getClassObjects().clear();
				getClassObjects().addAll((Collection<? extends ClassObject>)newValue);
				return;
			case HutnPackage.PACKAGE_OBJECT__METAMODEL:
				getMetamodel().clear();
				getMetamodel().addAll((Collection<? extends EPackage>)newValue);
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
			case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS:
				getClassObjects().clear();
				return;
			case HutnPackage.PACKAGE_OBJECT__METAMODEL:
				getMetamodel().clear();
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
			case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS:
				return classObjects != null && !classObjects.isEmpty();
			case HutnPackage.PACKAGE_OBJECT__METAMODEL:
				return metamodel != null && !metamodel.isEmpty();
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
				case HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS: return HutnPackage.CLASS_OBJECT_CONTAINER__CLASS_OBJECTS;
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
				case HutnPackage.CLASS_OBJECT_CONTAINER__CLASS_OBJECTS: return HutnPackage.PACKAGE_OBJECT__CLASS_OBJECTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //PackageObjectImpl

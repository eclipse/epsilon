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
 * $Id: ClassObject.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.ClassObject#getSlots <em>Slots</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getClassObject()
 * @model
 * @generated
 */
public interface ClassObject extends org.eclipse.epsilon.hutn.model.hutn.Object {
	
	/**
	 * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.hutn.model.hutn.Slot}&lt;?>.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.hutn.model.hutn.Slot#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slots</em>' containment reference list.
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getClassObject_Slots()
	 * @see org.eclipse.epsilon.hutn.model.hutn.Slot#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Slot<?>> getSlots();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Slot<?> findSlot(String feature);


	/**
	 * <!-- begin-user-doc -->
	 * Returns the PackageObject that contains this ClassObject.
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	PackageObject getPackageObject();


	/**
	 * <!-- begin-user-doc -->
	 * Returns the corresponding EClass in the containing 
	 * PackageObject's metamodel.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EClass getEClass();
	
	
	/**
	 * <!-- begin-user-doc -->
	 * Returns true only if this Slot has a corresponding EClass
	 * in the containing PackageObject's metamodel.
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasEClass();
	
	
	/**
	 * <!-- begin-user-doc -->
	 * Indicates whether every Slot contained in this ClassObject is
	 * type compatible with some EStructuralFeature contained in eClass
	 * <!-- end-user-doc -->
	 * @model required="true" eClassRequired="true"
	 * @generated
	 */
	boolean typeCompatibleWith(EClass eClass);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AttributeSlot findOrCreateAttributeSlot(String feature);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ReferenceSlot findOrCreateReferenceSlot(String feature);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ContainmentSlot findOrCreateContainmentSlot(String feature);
	
} // ClassObject

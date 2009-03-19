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
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.ClassObject#getContainer <em>Container</em>}</li>
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
	 * The list contents are of type {@link org.eclipse.epsilon.hutn.model.hutn.Slot}.
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
	EList<Slot> getSlots();


	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.hutn.model.hutn.ClassObjectContainer#getClassObjects <em>Class Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(ClassObjectContainer)
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getClassObject_Container()
	 * @see org.eclipse.epsilon.hutn.model.hutn.ClassObjectContainer#getClassObjects
	 * @model opposite="classObjects" required="true" transient="false"
	 * @generated
	 */
	ClassObjectContainer getContainer();


	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.hutn.model.hutn.ClassObject#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ClassObjectContainer value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Slot findSlot(String feature);


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
	
} // ClassObject

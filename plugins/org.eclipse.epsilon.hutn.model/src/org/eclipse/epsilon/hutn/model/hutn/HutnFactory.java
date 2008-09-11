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
 * $Id: HutnFactory.java,v 1.4 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage
 * @generated
 */
public interface HutnFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HutnFactory eINSTANCE = org.eclipse.epsilon.hutn.model.hutn.impl.HutnFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spec</em>'.
	 * @generated
	 */
	Spec createSpec();

	/**
	 * Returns a new object of class '<em>Ns Uri</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ns Uri</em>'.
	 * @generated
	 */
	NsUri createNsUri();

	/**
	 * Returns a new object of class '<em>Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element</em>'.
	 * @generated
	 */
	ModelElement createModelElement();

	/**
	 * Returns a new object of class '<em>Package Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Object</em>'.
	 * @generated
	 */
	PackageObject createPackageObject();

	/**
	 * Returns a new object of class '<em>Class Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Object</em>'.
	 * @generated
	 */
	ClassObject createClassObject();

	/**
	 * Returns a new object of class '<em>String Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Slot</em>'.
	 * @generated
	 */
	StringSlot createStringSlot();

	/**
	 * Returns a new object of class '<em>Boolean Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Slot</em>'.
	 * @generated
	 */
	BooleanSlot createBooleanSlot();

	/**
	 * Returns a new object of class '<em>Integer Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Slot</em>'.
	 * @generated
	 */
	IntegerSlot createIntegerSlot();

	/**
	 * Returns a new object of class '<em>Float Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float Slot</em>'.
	 * @generated
	 */
	FloatSlot createFloatSlot();

	/**
	 * Returns a new object of class '<em>Null Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Slot</em>'.
	 * @generated
	 */
	NullSlot createNullSlot();

	/**
	 * Returns a new object of class '<em>Containment Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Containment Slot</em>'.
	 * @generated
	 */
	ContainmentSlot createContainmentSlot();

	/**
	 * Returns a new object of class '<em>Reference Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Slot</em>'.
	 * @generated
	 */
	ReferenceSlot createReferenceSlot();

	/**
	 * Returns a new object of class '<em>Enum Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Slot</em>'.
	 * @generated
	 */
	EnumSlot createEnumSlot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HutnPackage getHutnPackage();

} //HutnFactory

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
 * $Id: PackageObject.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.PackageObject#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getPackageObject()
 * @model
 * @generated
 */
public interface PackageObject extends org.eclipse.epsilon.hutn.model.hutn.Object, ClassObjectContainer {

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(EPackage)
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getPackageObject_Metamodel()
	 * @model
	 * @generated
	 */
	EPackage getMetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.hutn.model.hutn.PackageObject#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(EPackage value);

	/**
	 * <!-- begin-user-doc -->
	 * Returns all of the EClasses contained in this PackageObject's metamodel.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EClass> getAllEClasses();
} // PackageObject

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
 * $Id$
 */
package org.eclipse.epsilon.hutn.model.hutn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Associative Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getAssociativeSlot()
 * @model abstract="true"
 * @generated
 */
public interface AssociativeSlot extends Slot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ClassObject> getClassObjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model classObjectRequired="true"
	 * @generated
	 */
	void addClassObject(ClassObject classObject);

} // AssociativeSlot

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
 * A representation of the model object '<em><b>Containment Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot#getClassObjects <em>Class Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getContainmentSlot()
 * @model
 * @generated
 */
public interface ContainmentSlot extends ClassObjectSlot<ClassObject> {

	/**
	 * Returns the value of the '<em><b>Class Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.hutn.model.hutn.ClassObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Objects</em>' containment reference list.
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getContainmentSlot_ClassObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassObject> getClassObjects();
} // ContainmentSlot

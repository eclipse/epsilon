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
 * $Id: IntegerSlot.java,v 1.2 2008/07/30 11:13:02 dkolovos Exp $
 */
package org.eclipse.epsilon.emc.emf.virtual;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.emf.virtual.IntegerSlot#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.emf.virtual.VirtualPackage#getIntegerSlot()
 * @model
 * @generated
 */
public interface IntegerSlot extends Slot {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.eclipse.epsilon.emc.emf.virtual.VirtualPackage#getIntegerSlot_Values()
	 * @model
	 * @generated
	 */
	EList<Integer> getValues();

} // IntegerSlot

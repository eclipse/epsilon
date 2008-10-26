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
 * $Id: Slot.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn;

import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.Slot#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.Slot#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getSlot()
 * @model abstract="true"
 * @generated
 */
public interface Slot extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getSlot_Feature()
	 * @model
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.hutn.model.hutn.Slot#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.hutn.model.hutn.Object#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(org.eclipse.epsilon.hutn.model.hutn.Object)
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getSlot_Owner()
	 * @see org.eclipse.epsilon.hutn.model.hutn.Object#getSlots
	 * @model opposite="slots" required="true" transient="false"
	 * @generated
	 */
	org.eclipse.epsilon.hutn.model.hutn.Object getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.hutn.model.hutn.Slot#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(org.eclipse.epsilon.hutn.model.hutn.Object value);

	/**
	 * <!-- begin-user-doc -->
	 * Appends the contents of slot to the contents of this Slot.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void append(Slot slot);
	
	/**
	 * <!-- begin-user-doc -->
	 * Indicates whether the contents of this Slot has the same
	 * type as the specified EStructuralFeature.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	boolean typeCompatibleWith(EStructuralFeature feature);

} // Slot

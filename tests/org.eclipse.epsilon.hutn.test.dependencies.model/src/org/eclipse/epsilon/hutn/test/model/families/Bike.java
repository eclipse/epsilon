/**
 * *******************************************************************************
 *  Copyright (c) 2008 The University of York.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  Contributors:
 *    Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.test.model.families;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bike</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.test.model.families.Bike#getRider <em>Rider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage#getBike()
 * @model
 * @generated
 */
public interface Bike extends EObject {
	/**
	 * Returns the value of the '<em><b>Rider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rider</em>' containment reference.
	 * @see #setRider(Person)
	 * @see org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage#getBike_Rider()
	 * @model containment="true"
	 * @generated
	 */
	Person getRider();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.hutn.test.model.families.Bike#getRider <em>Rider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rider</em>' containment reference.
	 * @see #getRider()
	 * @generated
	 */
	void setRider(Person value);

} // Bike

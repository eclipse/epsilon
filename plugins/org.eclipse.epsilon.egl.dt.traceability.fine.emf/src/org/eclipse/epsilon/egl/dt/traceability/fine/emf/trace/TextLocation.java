/**
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Louis Rose - initial API and implementation
 */
package org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TextLocation#getResources <em>Resources</em>}</li>
 *   <li>{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TextLocation#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getTextLocation()
 * @model
 * @generated
 */
public interface TextLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' attribute list.
	 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getTextLocation_Resources()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getResources();

	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' containment reference.
	 * @see #setRegion(Region)
	 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getTextLocation_Region()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Region getRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TextLocation#getRegion <em>Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' containment reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(Region value);

} // TextLocation

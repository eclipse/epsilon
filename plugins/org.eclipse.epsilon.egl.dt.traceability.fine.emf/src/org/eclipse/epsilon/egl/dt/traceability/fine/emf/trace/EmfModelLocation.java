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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emf Model Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.EmfModelLocation#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getEmfModelLocation()
 * @model
 * @generated
 */
public interface EmfModelLocation extends ModelLocation {
	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(EObject)
	 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getEmfModelLocation_ModelElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.EmfModelLocation#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

} // EmfModelLocation

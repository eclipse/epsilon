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
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.Trace#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.Trace#getLocations <em>Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TraceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getTrace_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceElement> getElements();

	/**
	 * Returns the value of the '<em><b>Locations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TextLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locations</em>' containment reference list.
	 * @see org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TracePackage#getTrace_Locations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TextLocation> getLocations();

} // Trace

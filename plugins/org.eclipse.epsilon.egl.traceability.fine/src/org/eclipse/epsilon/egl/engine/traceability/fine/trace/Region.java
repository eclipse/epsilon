/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(Position)
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage#getRegion_Start()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Position getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Position value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' containment reference.
	 * @see #setEnd(Position)
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage#getRegion_End()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Position getEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region#getEnd <em>End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' containment reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Position value);

} // Region

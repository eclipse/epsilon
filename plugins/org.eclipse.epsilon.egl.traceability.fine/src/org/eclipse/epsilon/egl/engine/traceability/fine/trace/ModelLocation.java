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
 * A representation of the model object '<em><b>Model Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage#getModelLocation()
 * @model
 * @generated
 */
public interface ModelLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(EObject)
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage#getModelLocation_ModelElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage#getModelLocation_FeatureName()
	 * @model required="true"
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

} // ModelLocation

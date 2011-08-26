/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.egl.engine.traceability.fine.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = org.eclipse.epsilon.egl.engine.traceability.fine.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace</em>'.
	 * @generated
	 */
	Trace createTrace();

	/**
	 * Returns a new object of class '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element</em>'.
	 * @generated
	 */
	TraceElement createTraceElement();

	/**
	 * Returns a new object of class '<em>Model Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Location</em>'.
	 * @generated
	 */
	ModelLocation createModelLocation();

	/**
	 * Returns a new object of class '<em>Text Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Location</em>'.
	 * @generated
	 */
	TextLocation createTextLocation();

	/**
	 * Returns a new object of class '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Region</em>'.
	 * @generated
	 */
	Region createRegion();

	/**
	 * Returns a new object of class '<em>Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Position</em>'.
	 * @generated
	 */
	Position createPosition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceFactory

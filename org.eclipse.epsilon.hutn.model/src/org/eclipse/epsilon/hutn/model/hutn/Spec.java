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
 * $Id: Spec.java,v 1.3 2008/08/15 10:05:57 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.hutn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.Spec#getNsUris <em>Ns Uris</em>}</li>
 *   <li>{@link org.eclipse.epsilon.hutn.model.hutn.Spec#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getSpec()
 * @model
 * @generated
 */
public interface Spec extends EObject {
	/**
	 * Returns the value of the '<em><b>Ns Uris</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.hutn.model.hutn.NsUri}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns Uris</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Uris</em>' containment reference list.
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getSpec_NsUris()
	 * @model containment="true"
	 * @generated
	 */
	EList<NsUri> getNsUris();

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.hutn.model.hutn.PackageObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see org.eclipse.epsilon.hutn.model.hutn.HutnPackage#getSpec_Objects()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageObject> getObjects();

} // Spec

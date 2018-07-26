/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package friends;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link friends.World#getPeople <em>People</em>}</li>
 * </ul>
 * </p>
 *
 * @see friends.FriendsPackage#getWorld()
 * @model annotation="gmf.diagram foo='bar'"
 * @generated
 */
public interface World extends EObject {
	/**
   * Returns the value of the '<em><b>People</b></em>' containment reference list.
   * The list contents are of type {@link friends.Person}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>People</em>' containment reference list.
   * @see friends.FriendsPackage#getWorld_People()
   * @model containment="true"
   * @generated
   */
	EList<Person> getPeople();

} // World

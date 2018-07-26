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
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link friends.Person#getName <em>Name</em>}</li>
 *   <li>{@link friends.Person#getFriendOf <em>Friend Of</em>}</li>
 *   <li>{@link friends.Person#getEnemyOf <em>Enemy Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see friends.FriendsPackage#getPerson()
 * @model annotation="gmf.node figure='figures.PersonFigure' label.icon='false' label='name' label.placement='external'"
 * @generated
 */
public interface Person extends EObject {
	/**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see friends.FriendsPackage#getPerson_Name()
   * @model
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link friends.Person#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Friend Of</b></em>' reference list.
   * The list contents are of type {@link friends.Person}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friend Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Friend Of</em>' reference list.
   * @see friends.FriendsPackage#getPerson_FriendOf()
   * @model annotation="gmf.link width='2' color='0,255,0' source.decoration='arrow' target.decoration='arrow' style='dash'"
   * @generated
   */
	EList<Person> getFriendOf();

	/**
   * Returns the value of the '<em><b>Enemy Of</b></em>' reference list.
   * The list contents are of type {@link friends.Person}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enemy Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Enemy Of</em>' reference list.
   * @see friends.FriendsPackage#getPerson_EnemyOf()
   * @model annotation="gmf.link width='2' color='255,0,0' source.decoration='arrow' target.decoration='arrow' style='dash'"
   * @generated
   */
	EList<Person> getEnemyOf();

} // Person

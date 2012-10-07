/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
package friends.impl;

import friends.FriendsPackage;
import friends.Person;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link friends.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link friends.impl.PersonImpl#getFriendOf <em>Friend Of</em>}</li>
 *   <li>{@link friends.impl.PersonImpl#getEnemyOf <em>Enemy Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends EObjectImpl implements Person {
	/**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected static final String NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected String name = NAME_EDEFAULT;

	/**
   * The cached value of the '{@link #getFriendOf() <em>Friend Of</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getFriendOf()
   * @generated
   * @ordered
   */
	protected EList<Person> friendOf;

	/**
   * The cached value of the '{@link #getEnemyOf() <em>Enemy Of</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getEnemyOf()
   * @generated
   * @ordered
   */
	protected EList<Person> enemyOf;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected PersonImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return FriendsPackage.Literals.PERSON;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FriendsPackage.PERSON__NAME, oldName, name));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Person> getFriendOf() {
    if (friendOf == null)
    {
      friendOf = new EObjectResolvingEList<Person>(Person.class, this, FriendsPackage.PERSON__FRIEND_OF);
    }
    return friendOf;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Person> getEnemyOf() {
    if (enemyOf == null)
    {
      enemyOf = new EObjectResolvingEList<Person>(Person.class, this, FriendsPackage.PERSON__ENEMY_OF);
    }
    return enemyOf;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case FriendsPackage.PERSON__NAME:
        return getName();
      case FriendsPackage.PERSON__FRIEND_OF:
        return getFriendOf();
      case FriendsPackage.PERSON__ENEMY_OF:
        return getEnemyOf();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case FriendsPackage.PERSON__NAME:
        setName((String)newValue);
        return;
      case FriendsPackage.PERSON__FRIEND_OF:
        getFriendOf().clear();
        getFriendOf().addAll((Collection<? extends Person>)newValue);
        return;
      case FriendsPackage.PERSON__ENEMY_OF:
        getEnemyOf().clear();
        getEnemyOf().addAll((Collection<? extends Person>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case FriendsPackage.PERSON__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FriendsPackage.PERSON__FRIEND_OF:
        getFriendOf().clear();
        return;
      case FriendsPackage.PERSON__ENEMY_OF:
        getEnemyOf().clear();
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case FriendsPackage.PERSON__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FriendsPackage.PERSON__FRIEND_OF:
        return friendOf != null && !friendOf.isEmpty();
      case FriendsPackage.PERSON__ENEMY_OF:
        return enemyOf != null && !enemyOf.isEmpty();
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PersonImpl

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
package friends.tests;

import friends.FriendsFactory;
import friends.World;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldTest extends TestCase {

	/**
   * The fixture for this World test case.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected World fixture = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static void main(String[] args) {
    TestRunner.run(WorldTest.class);
  }

	/**
   * Constructs a new World test case with the given name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public WorldTest(String name) {
    super(name);
  }

	/**
   * Sets the fixture for this World test case.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void setFixture(World fixture) {
    this.fixture = fixture;
  }

	/**
   * Returns the fixture for this World test case.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected World getFixture() {
    return fixture;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
	@Override
	protected void setUp() throws Exception {
    setFixture(FriendsFactory.eINSTANCE.createWorld());
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
	@Override
	protected void tearDown() throws Exception {
    setFixture(null);
  }

} //WorldTest

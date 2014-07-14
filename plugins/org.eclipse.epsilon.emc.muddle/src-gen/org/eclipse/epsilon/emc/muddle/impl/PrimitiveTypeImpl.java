/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitris Kolovos - initial API and implementation
 ******************************************************************************/
/**
 */
package org.eclipse.epsilon.emc.muddle.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.epsilon.emc.muddle.MuddlePackage;
import org.eclipse.epsilon.emc.muddle.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PrimitiveTypeImpl extends TypeImpl implements PrimitiveType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MuddlePackage.Literals.PRIMITIVE_TYPE;
	}

} //PrimitiveTypeImpl

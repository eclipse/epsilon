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
 * $Id: IdentifierRuleImpl.java,v 1.2 2008/07/30 11:13:12 dkolovos Exp $
 */
package org.eclipse.epsilon.hutn.model.config.hutnConfig.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.epsilon.hutn.model.config.hutnConfig.HutnConfigPackage;
import org.eclipse.epsilon.hutn.model.config.hutnConfig.IdentifierRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IdentifierRuleImpl extends RuleImpl implements IdentifierRule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HutnConfigPackage.Literals.IDENTIFIER_RULE;
	}

} //IdentifierRuleImpl

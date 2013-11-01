/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - cleanup
 ******************************************************************************/
package org.eclipse.epsilon.erl.exceptions;

import java.util.Arrays;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class ErlRuleNotFoundException extends EolRuntimeException {
	private static final long serialVersionUID = 2474082128792086880L;

	public ErlRuleNotFoundException(AST ast) {
		super("Rule '" + ast + "' not found", Arrays.asList(ast));
	}
}

/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York, Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - reuse EolRuntimeException ctor, add accessor
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.module.ModuleElement;

public class EolUndefinedVariableException extends EolRuntimeException {

	private static final long serialVersionUID = 1L;
	private final String variableName;

	public EolUndefinedVariableException(String variableName, ModuleElement ast) {
		super("Undefined variable, type or model: '" + variableName + "'", ast);
		this.variableName = variableName;
	}

	public String getVariableName() {
		return variableName;
	}

}

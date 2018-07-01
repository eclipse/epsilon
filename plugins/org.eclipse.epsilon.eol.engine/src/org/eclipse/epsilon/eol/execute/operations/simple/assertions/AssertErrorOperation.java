/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.simple.assertions;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class AssertErrorOperation extends AssertOperation {

	@Override
	public boolean conditionSatisfied(Object condition) {
		return condition instanceof EolRuntimeException;
	}

	@Override
	public boolean getTolerateExceptionInParameter(int parameterIndex) {
		return parameterIndex == 0;
	}

	@Override
	public boolean isOverridable() {
		return false;
	}
	
}

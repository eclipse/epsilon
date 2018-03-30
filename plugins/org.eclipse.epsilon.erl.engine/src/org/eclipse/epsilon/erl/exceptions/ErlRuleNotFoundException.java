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
package org.eclipse.epsilon.erl.exceptions;

import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class ErlRuleNotFoundException extends EolRuntimeException{
	
	public ErlRuleNotFoundException(NameExpression ast) {
		this.ast = ast;
	}
	
	@Override
	public String getReason() {
		return "Rule '" + ((NameExpression) ast).getName() + "' not found";
	}
}

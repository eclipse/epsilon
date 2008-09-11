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
package org.eclipse.epsilon.eol.execute.operations;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public abstract class AbstractOperation {
	
	//TODO: Make operations aware of their names e.g. add a name attribute that the OperationFactory will populate
	
	public abstract Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException;
	
	public boolean appliesTo(Object source, AST operationAst, IEolContext context) throws EolRuntimeException{
		return true;
	}
	
	public boolean isOverridable() {
		return true;
	}
	
}

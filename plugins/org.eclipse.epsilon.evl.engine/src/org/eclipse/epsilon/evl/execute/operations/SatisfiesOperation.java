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
package org.eclipse.epsilon.evl.execute.operations;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.evl.EvlConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;


//TODO Add satisfiesAll and satisfiesOne operations
public class SatisfiesOperation extends AbstractOperation{

	public SatisfiesOperation() {
		super();
	}
	
	@Override
	public Object execute(Object obj, AST ast, IEolContext context_) throws EolRuntimeException {
		
		if (obj == null) return EolBoolean.FALSE;
		
		IEvlContext context = (IEvlContext) context_;
		
		for (AST child : ast.getFirstChild().getChildren()) {
			Object result = context.getExecutorFactory().executeAST(child, context);
			String constraintName = context.getPrettyPrinterManager().toString(result);
			
			EvlConstraint constraint = context.getModule().getConstraints().getConstraint(constraintName, obj, context);
			
			if (constraint == null) {
				throw new EvlConstraintNotFoundException(constraintName,ast);
			}
			
			if (constraint.check(obj,context) == false) return EolBoolean.FALSE;
		}
		
		return EolBoolean.TRUE;
		
	}
}

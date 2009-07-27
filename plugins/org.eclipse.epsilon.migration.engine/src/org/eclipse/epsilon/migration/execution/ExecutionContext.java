/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.migration.execution;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolBoolean;

public class ExecutionContext extends EolContext {

	public ExecutionContext(IModel... models) {
		for (IModel model : models) {
			if (model != null)
				getModelRepository().addModel(model);
		}
	}
	
	public String getTypeNameOf(Object instance) {
		final IModel owningModel = getModelRepository().getOwningModel(instance);
		
		if (owningModel != null) {
			return owningModel.getTypeNameOf(instance);
		}
		
		return null;
	}
	
	public Object executeBlock(AST block, Variable... variables) throws EolRuntimeException {
		enterProtectedFrame(block, variables);
		
		final Object result = getExecutorFactory().executeAST(block, this);
		
		leaveFrame(block);
		
		return result;
	}

	public boolean executeGuard(AST guard, Variable originalVar) {
		enterProtectedFrame(guard, originalVar);
		
		final EolBoolean guardSatisfied = (EolBoolean)getExecutorFactory().executeBlockOrExpressionAst(guard, this, EolBoolean.FALSE);
		
		leaveFrame(guard);
		
		return guardSatisfied.booleanValue();
	}
}

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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Iterator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;


public class ClosureOldOperation extends AbstractOperation{

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		EolSequence closure = new EolSequence();
		AST expressionAst = operationAst.getFirstChild().getFirstChild();
		closure(source, expressionAst, context, closure);
		return closure;
	}
	
	public void closure(Object source, AST expressionAST, IEolContext context, EolSequence closure) throws EolRuntimeException {
		
		context.getFrameStack().enter(FrameType.PROTECTED, expressionAST);
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", source));
		
		Object result = context.getExecutorFactory().executeAST(expressionAST, context);
		
		if (result instanceof EolCollection) {
			Iterator it = ((EolCollection) result).iterator();
			while (it.hasNext()) {
				Object next = it.next();
				if (!closure.includes(next).booleanValue()) {
					closure.add(next);
					closure(next, expressionAST, context, closure);
				}
			}
		}
		else if (result != null) {
			if (!closure.includes(result).booleanValue()) {
				closure.add(result);
				closure(result, expressionAST, context, closure);
			}
		}
		
		context.getFrameStack().leave(expressionAST);
		
		/*
		PropertyGetter propertyGetter = context.getIntrospectionManager().getPropertyGetterFor(source,property,context);
		if (propertyGetter != null) {
			Object result = propertyGetter.invoke(source, property);
			if (result instanceof Collection) {
				Iterator it = ((Collection) result).iterator();
				while (it.hasNext()) {
					Object next = it.next();
					if (!closure.includes(next).booleanValue()) {
						closure.add(next);
						closure(next, property, context, closure);
					}
				}
			}
			else {
				if (!closure.includes(result).booleanValue()) {
					closure.add(result);
					closure(result, property, context, closure);
				}
			}
		}
		*/
	}
	
}

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
package org.eclipse.epsilon.eol.execute.operations.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;


public abstract class SimpleOperation extends AbstractOperation{

	public SimpleOperation() {
		super();
	}
	
	@Override
	public Object execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
	
		List<Object> parameters = new ArrayList<Object>();
		int parameterIndex = 0;
		ListIterator<Expression> it = expressions.listIterator();
		while (it.hasNext()){
			try {
				parameters.add(context.getExecutorFactory().execute(it.next(), context));
			}
			catch (EolRuntimeException ex) {
				if (getTolerateExceptionInParameter(parameterIndex)) {
					parameters.add(ex);
				}
				else {
					throw ex;
				}
			}
			catch (Throwable t) {
				context.getErrorStream().println("THROWABLE " + t.getClass().getName());
			}
			parameterIndex++;
		}

		try {
			return execute(target, parameters, context, operationNameExpression);
		}
		catch (EolRuntimeException ex){
			if (ex.getAst() == null) {
				ex.setAst(operationNameExpression);
			}
			throw ex;
		}
	}
	
	public abstract Object execute(Object source, List<?> parameters, IEolContext context, ModuleElement ast) throws EolRuntimeException;
	
	public boolean getTolerateExceptionInParameter(int parameterIndex) {
		return false;
	}
	
}

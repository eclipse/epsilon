/*******************************************************************************
 * Copyright (c) 2011 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/**
 * <p>
 * Labeled block which constitutes an EVL guard. It may be a single Boolean
 * expression, or a sequence of statements which returns a Boolean result.
 * </p>
 * 
 * <p>
 * Empty guards (with {@link #getAst()} returning <code>null</code>) are
 * considered to be true.
 * </p>
 */
public class EvlGuard extends EolLabeledBlock {

	public EvlGuard(AST ast) {
		super(ast, "guard");
	}

	/**
	 * Returns <code>true</code> if the guard holds and the associated code
	 * should be run, or <code>false</code> otherwise. Empty guards are
	 * considered to be true.
	 */
	public boolean evaluate(Object object, IEvlContext context) throws EolRuntimeException {
		if (getAst() == null) {
			return true;
		}

		context.getFrameStack().enterLocal(FrameType.PROTECTED, getAst());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", object));
		Object result = context.getExecutorFactory().executeBlockOrExpressionAst(getAst(), context);
		
		if (result instanceof Return) {
			Object value = Return.getValue(result);
			if (value instanceof Boolean){
				return ((Boolean) value);
			}
			else {
				throw new EolIllegalReturnException("Boolean", value, getAst(), context);
			}
		}
		else {
			throw new EolNoReturnException("Boolean", getAst(), context);
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.simple.assertions;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;

/**
 * Simple assertion class which expects that a certain Boolean expression yields
 * a true or false value. Can be used with 1 or 2 arguments: the 2 argument version
 * expects a message and a boolean expression.
 *
 * This is different from {@link AssertOperation}, which expects the condition and
 * the message and may surprise typical JUnit users. We cannot change AssertOperation,
 * as it may break existing code. Instead, we will provide new operations with the
 * JUnit argument order.
 *
 * @author Antonio Garcia-Dominguez
 * @version 1.0
 */
public class BooleanAssertionOperation extends AbstractSimpleOperation {

	private final boolean fExpected;

	/**
	 * Creates a new instance.
	 * @param expected The expected value for the argument.
	 */
	public BooleanAssertionOperation(boolean expected) {
		fExpected = expected;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(Object source, List parameters, IEolContext context, AST ast)
		throws EolRuntimeException
	{
		if (!context.isAssertionsEnabled()) {
			return null;
		}

		Object message = "Violated assertion";
		Object condition = null;

		switch (parameters.size()) {
		case 1:
			condition = parameters.get(0);
			break;
		case 2:
			message = parameters.get(0);
			condition = parameters.get(1);
			break;
		default:
			throw new EolRuntimeException("Invalid number of arguments", ast);
		}

		boolean bResult = evaluateCondition(condition);
		if (bResult != fExpected) {
			throw new EolAssertionException(context.getPrettyPrinterManager().toString(message), ast, fExpected, bResult, null);
		}
		else {
			return null;
		}
	}

	protected boolean evaluateCondition(Object condition) {
		boolean bResult = false;
		if (condition instanceof Boolean) {
			bResult = ((Boolean)condition).booleanValue();
		}
		return bResult;
	}

}

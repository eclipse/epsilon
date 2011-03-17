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
 * Simple operation which fails a test with a custom message. Useful when the
 * prewritten tests aren't good enough.
 * 
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class FailOperation extends AbstractSimpleOperation {

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
		Object msg = null;
		if (parameters.size() > 0) {
			msg = parameters.get(0);
		}
		throw new EolAssertionException(msg.toString(), ast);
	}

}

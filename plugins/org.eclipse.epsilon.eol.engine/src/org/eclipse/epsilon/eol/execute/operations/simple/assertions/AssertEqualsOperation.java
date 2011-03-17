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

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.types.EolObjectComparator;

/**
 * Basic equality assertion: the first argument is the expected value, and the second one is the actual
 * value obtained by running the program under test.
 */
public class AssertEqualsOperation extends AbstractSimpleOperation {

	@Override
	public Object execute(Object source, List parameters, IEolContext context,
			AST ast) throws EolRuntimeException {
		
		if (!context.isAssertionsEnabled()) {return null;}
		
		if (EolObjectComparator.equals(parameters.get(0), parameters.get(1))) return true;
		
		String expected = context.getPrettyPrinterManager().toString(parameters.get(0));
		String obtained = context.getPrettyPrinterManager().toString(parameters.get(1));
		
		throw new EolAssertionException("Expected " + expected + ", but got " + obtained + " instead", ast);
	}
		
}

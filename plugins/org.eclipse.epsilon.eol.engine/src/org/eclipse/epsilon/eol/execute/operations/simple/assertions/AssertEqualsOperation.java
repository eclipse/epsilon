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
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;
import org.eclipse.epsilon.eol.types.EolBoolean;


public class AssertEqualsOperation extends AbstractSimpleOperation {

	@Override
	public Object execute(Object source, List parameters, IEolContext context,
			AST ast) throws EolRuntimeException {
		
		if (!context.isAssertionsEnabled()) {return null;}
		
		if (parameters.get(0).equals(parameters.get(1))) return true;
		
		String p0 = context.getPrettyPrinterManager().toString(parameters.get(0));
		String p1 = context.getPrettyPrinterManager().toString(parameters.get(1));
		
		throw new EolAssertionException(p0 + " must be equal to " + p1, ast);
	}
		
}

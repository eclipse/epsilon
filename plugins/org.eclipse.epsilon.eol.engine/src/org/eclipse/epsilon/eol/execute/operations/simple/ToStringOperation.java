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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;
import org.eclipse.epsilon.eol.types.EolString;


public class ToStringOperation extends AbstractOperation {

	public ToStringOperation() {
		super();
	}

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		PrettyPrinter prettyPrinter = context.getPrettyPrinterManager().getPrettyPrinterFor(source);
		return new EolString(prettyPrinter.print(source));
	}

}

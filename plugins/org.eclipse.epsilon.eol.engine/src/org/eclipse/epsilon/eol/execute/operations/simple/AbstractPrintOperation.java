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

import java.io.PrintStream;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;


public abstract class AbstractPrintOperation extends AbstractSimpleOperation {
	
	protected PrintStream printStream;
	
	@Override
	public Object execute(Object source, List parameters, IEolContext context,
			AST ast) throws EolRuntimeException {
		
		PrettyPrinterManager manager = context.getPrettyPrinterManager();
		String prefix = "";
		String suffix = "";
		if (parameters.size() > 0) {
			prefix = context.getPrettyPrinterManager().toString(parameters.get(0));
		}
		if (parameters.size() > 1) {
			suffix = context.getPrettyPrinterManager().toString(parameters.get(1));
		}
		
		if (printStream == null) {
			printStream = getPrintStream(context);
		}
		
		if (printsNewLine()) {
			printStream.println(prefix + manager.toString(source) + suffix);
		}
		else {
			printStream.print(prefix + manager.toString(source) + suffix);
		}
		
		return source;
		
	}
	
	public abstract PrintStream getPrintStream(IEolContext context);
	
	public abstract boolean printsNewLine();
	
}

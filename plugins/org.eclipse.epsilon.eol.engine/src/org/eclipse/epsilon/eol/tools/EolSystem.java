/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.tools;

import java.io.PrintStream;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.AsyncStatementInstance;
import org.eclipse.epsilon.eol.userinput.IUserInput;

public class EolSystem extends AbstractTool{
	
	public IUserInput getUser() {
		return context.getUserInput();
	}
	
	public PrintStream getOut() {
		return context.getOutputStream();
	}
	
	public PrintStream getErr() {
		return context.getErrorStream();
	}
	
	public String getPlatformProperty(String property) {
		return System.getProperty(property);
	}
	
	public void execAsync() throws EolRuntimeException {
		List<AsyncStatementInstance> queque = context.getAsyncStatementsQueque();
		while (queque.size() > 0) {
			AsyncStatementInstance statement = queque.get(0);
			statement.execute(context);
			queque.remove(statement);
		}
	}
	
}

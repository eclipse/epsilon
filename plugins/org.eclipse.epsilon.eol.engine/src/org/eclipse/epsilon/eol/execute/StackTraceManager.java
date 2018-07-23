/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class StackTraceManager implements IExecutionListener {
	
	protected Stack<ModuleElement> stackTrace = new Stack<ModuleElement>();
	
	@Override
	public void aboutToExecute(ModuleElement ast, IEolContext context) {
		stackTrace.push(ast);
	}

	@Override
	public void finishedExecuting(ModuleElement ast, Object result, IEolContext context) {
		stackTrace.pop();
	}
	
	@Override
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context) {}
	
	public List<ModuleElement> getStackTrace() {
		ArrayList<ModuleElement> stackTrace = new ArrayList<ModuleElement>();
		stackTrace.addAll(this.stackTrace);
		Collections.reverse(stackTrace);
		return stackTrace;
	}
	
	public void printStackTrace(PrintWriter writer) {
		writer.print(getStackTraceAsString());
	}
	
	public void printStackTrace(PrintStream stream) {
		stream.print(getStackTraceAsString());
	}
	
	public String getStackTraceAsString() {
		StringBuffer buffer = new StringBuffer();
		for (ModuleElement ast : getStackTrace()) {
			buffer.append(toString(ast) + "\r\n");
		}
		return buffer.toString();
	}
	
	protected String toString(ModuleElement ast) {
		
		String location = "unknown";
		if (ast.getFile() != null) {
			location = ast.getFile().getAbsolutePath();
		}
		else if (ast.getUri() != null) {
			location = ast.getUri().toString();
		}
		
		return "\tat (" + location 
				+ "@" + ast.getRegion().getStart().getLine() + ":" 
				+ ast.getRegion().getStart().getColumn() + "-" + 
				ast.getRegion().getEnd().getLine() + ":" +
				ast.getRegion().getEnd().getColumn() + ")";
	}
	
}

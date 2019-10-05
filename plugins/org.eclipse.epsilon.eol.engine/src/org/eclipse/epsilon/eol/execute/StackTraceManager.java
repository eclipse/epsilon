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
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class StackTraceManager implements IExecutionListener {
	
	/** Use Deque instead of Stack to avoid bottlenecks due to synchronisation overhead!
	 * Concurrency can be handled by having a different StackTraceManager for each thread,
	 * or by using a {@linkplain ConcurrentLinkedDeque}
	 * @since 1.6
	 */
	Deque<ModuleElement> stackTrace;
	
	public StackTraceManager() {
		this(false);
	}
	
	/**
	 * 
	 * @param concurrent
	 * @since 1.6
	 */
	public StackTraceManager(boolean concurrent) {
		stackTrace = concurrent ? new ConcurrentLinkedDeque<>() : new ArrayDeque<>();
	}
	
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
		return new ArrayList<>(this.stackTrace);
	}
	
	public void printStackTrace(PrintWriter writer) {
		writer.print(getStackTraceAsString());
	}
	
	public void printStackTrace(PrintStream stream) {
		stream.print(getStackTraceAsString());
	}
	
	public String getStackTraceAsString() {
		StringBuilder sb = new StringBuilder();
		for (ModuleElement ast : getStackTrace()) {
			sb.append(toString(ast) + "\r\n");
		}
		return sb.toString();
	}
	
	protected String toString(ModuleElement ast) {
		String location = "unknown";
		if (ast == null) return location;
		
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
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public boolean isThreadSafe() {
		return stackTrace instanceof ConcurrentLinkedDeque;
	}
	
	/**
	 * 
	 * @param concurrent
	 * @since 1.6
	 */
	public void setThreadSafe(boolean concurrent) {
		if (concurrent != isThreadSafe()) {
			stackTrace = concurrent ?
				new ConcurrentLinkedDeque<>(stackTrace) :
				new ArrayDeque<>(stackTrace);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(stackTrace);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof StackTraceManager)) return false;
		StackTraceManager other = (StackTraceManager) obj;
		return Objects.equals(this.stackTrace, other.stackTrace);
	}
}

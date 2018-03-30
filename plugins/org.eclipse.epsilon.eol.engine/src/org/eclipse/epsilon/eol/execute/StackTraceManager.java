package org.eclipse.epsilon.eol.execute;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class StackTraceManager implements IExecutionListener {
	
	//Use Deque instead of Stack to avoid bottlenecks due to synchronisation overhead!
	//Concurrency should be handled by having a different StackTraceManager for each thread.
	protected Deque<ModuleElement> stackTrace = new ArrayDeque<>();
	
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
		ArrayList<ModuleElement> trace = new ArrayList<>(this.stackTrace);
		Collections.reverse(trace);
		return trace;
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

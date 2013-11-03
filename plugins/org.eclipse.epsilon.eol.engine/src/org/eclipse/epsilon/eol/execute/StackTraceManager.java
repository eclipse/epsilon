package org.eclipse.epsilon.eol.execute;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class StackTraceManager implements IExecutionListener {
	
	protected Stack<AST> stackTrace = new Stack<AST>();
	
	@Override
	public void aboutToExecute(AST ast, IEolContext context) {
		if (!ast.isImaginary()) {
			stackTrace.push(ast);
		}
	}

	@Override
	public void finishedExecuting(AST ast, Object result, IEolContext context) {
		if (!ast.isImaginary()) {
			stackTrace.pop();
		}
	}
	
	public List<AST> getStackTrace() {
		ArrayList<AST> stackTrace = new ArrayList<AST>();
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
		for (AST ast : getStackTrace()) {
			buffer.append(toString(ast) + "\r\n");
		}
		return buffer.toString();
	}
	
	protected String toString(AST ast) {
		
		String location = null;
		if (ast.getFile() != null) {
			location = ast.getFile().getAbsolutePath();
		}
		else {
			location = ast.getUri().toString();
		}
		
		return "\tat (" + location 
				+ "@" + ast.getRegion().getStart().getLine() + ":" 
				+ ast.getRegion().getStart().getColumn() + "-" + 
				ast.getRegion().getEnd().getLine() + ":" +
				ast.getRegion().getEnd().getColumn() + ")";
	}
	
}

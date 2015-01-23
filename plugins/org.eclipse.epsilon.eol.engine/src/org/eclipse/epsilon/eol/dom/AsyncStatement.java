package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.AsyncStatementInstance;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class AsyncStatement extends Statement {

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		if (getFirstChild() != null){
			final FrameStack frameStack = context.getFrameStack().clone();
			AsyncStatementInstance asyncStatement = new AsyncStatementInstance();
			asyncStatement.setAst(getFirstChild());
			asyncStatement.setLocalFrameStack(frameStack);
			context.getAsyncStatementsQueque().add(asyncStatement);
		}
		
		return null;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {}
	
}

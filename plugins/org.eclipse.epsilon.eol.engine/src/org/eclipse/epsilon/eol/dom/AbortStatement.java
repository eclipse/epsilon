package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolAbortTransactionException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class AbortStatement extends Statement {

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		throw new EolAbortTransactionException();
	}
	
	@Override
	public void compile(EolCompilationContext context) {}
	
}

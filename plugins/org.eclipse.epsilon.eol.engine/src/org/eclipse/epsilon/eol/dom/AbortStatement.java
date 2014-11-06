package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolAbortTransactionException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class AbortStatement extends Statement implements IExecutableModuleElement {

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		throw new EolAbortTransactionException();
	}
	
}

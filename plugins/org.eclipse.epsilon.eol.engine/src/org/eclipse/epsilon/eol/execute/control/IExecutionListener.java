package org.eclipse.epsilon.eol.execute.control;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IExecutionListener {

	public void aboutToExecute(AST ast, IEolContext context);
	
	public void finishedExecuting(AST ast, IEolContext context);
	
}

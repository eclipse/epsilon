package org.eclipse.epsilon.eol.execute.control;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IExecutionListener {

	public void aboutToExecute(AST ast, IEolContext context);
	
	/**
	 * @param evaluatedAst the result of evaluating ast, calculated during execution
	 *                     or null if an exception occurred during the execution of ast
	 */
	public void finishedExecuting(AST ast, Object evaluatedAst, IEolContext context);
	
}

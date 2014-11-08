package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class StatementBlock extends AbstractExecutableModuleElement {

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return execute(this, context);
	}
	
	public static Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		AST statementAst = ast.getFirstChild();
		while (statementAst != null){
			context.getFrameStack().setCurrentStatement(statementAst);
			Object result = context.getExecutorFactory().executeAST(statementAst, context);
			if (result instanceof Return) {
				return result;
			}
			statementAst = statementAst.getNextSibling();
		}
		return null;	
	}
	
}

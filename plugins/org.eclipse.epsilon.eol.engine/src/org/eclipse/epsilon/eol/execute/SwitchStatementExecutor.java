package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchStatementExecutor extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		AST switchValueAst = ast.getFirstChild();
		
		Object switchValue = context.getExecutorFactory().executeAST(switchValueAst, context);
		
		AST nextCase = switchValueAst.getNextSibling();
		
		try {
			
			boolean continue_ = false;
			
			while (nextCase != null) {
				
				if (nextCase.getType() == EolParser.CASE) {
					AST caseValueAst = nextCase.getFirstChild();
					
					if (continue_ || equals(context.getExecutorFactory().executeAST(caseValueAst, context), switchValue)) {
						AST caseBodyStatement = caseValueAst.getNextSibling();
						try {
							while (caseBodyStatement != null) {
								context.getExecutorFactory().executeAST(caseBodyStatement, context);
								caseBodyStatement = caseBodyStatement.getNextSibling();
							}
						}
						catch (EolContinueException ex) {
							continue_ = true;
						}
						
						if (!continue_) { break; }
						
					}
				}
				else if (nextCase.getType() == EolParser.DEFAULT) {
					AST defaultBodyStatement = nextCase.getFirstChild();
					while (defaultBodyStatement != null) {
						context.getExecutorFactory().executeAST(defaultBodyStatement, context);
						defaultBodyStatement = defaultBodyStatement.getNextSibling();
					}
				}
				
				nextCase = nextCase.getNextSibling();
				
			}
			
		}
		catch (EolBreakException e) {
			
		}
		
		return null;
	}
	
	protected boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) return true;
		if (o1 == null || o2 == null) return false;
		return o1.equals(o2);
	}
	
}

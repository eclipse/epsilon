package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class IteratorOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object source, AST operationAst, IEolContext context)
			throws EolRuntimeException {
		
		AST declarationsAst = operationAst.getFirstChild();
		AST expressionAst = declarationsAst.getNextSibling();
		
		AST declarationAst = declarationsAst.getFirstChild();
		AST iteratorNameAst = declarationAst.getFirstChild();
		AST iteratorTypeAst = iteratorNameAst.getNextSibling();
		
		String iteratorName = iteratorNameAst.getText();
		EolType iteratorType = null;
		
		if (iteratorTypeAst != null){
			iteratorType = (EolType) context.getExecutorFactory().executeAST(iteratorTypeAst,context);
		}
		else {
			iteratorType = EolAnyType.Instance;
		}
		
		return execute(source, new Variable(iteratorName, null, iteratorType), expressionAst, context);
	}
	
	public abstract Object execute(Object target, Variable iterator, AST expressionAst, IEolContext context) throws EolRuntimeException;
	
}

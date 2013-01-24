package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.types.EolType;

public class FindOperation extends AbstractOperation {

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		if (source instanceof ISearchableModel) {
			ISearchableModel searchableModel = (ISearchableModel) source;
			AST parameterAst = operationAst.getFirstChild().getFirstChild();
			AST queryAst = operationAst.getFirstChild().getNextSibling();
			
			String iteratorName = parameterAst.getFirstChild().getText();
			EolType iteratorType = (EolType) context.getExecutorFactory().
					executeAST(parameterAst.getFirstChild().getNextSibling(), context);
			
			Variable iterator = new Variable(iteratorName, null, iteratorType);
			
			return searchableModel.find(iterator, queryAst, context);
		}
		else {
			return new SelectOperation().execute(source, operationAst, context);
		}
	}

	@Override
	public boolean appliesTo(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		return source instanceof ISearchableModel;
	}
	
}

package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectBasedOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.models.IModel;

public class HigherOrderOperationCallExpression extends FeatureCallExpression implements IExecutableModuleElement {
	
	public Object execute(IEolContext context) throws EolRuntimeException {
		AST objectAst = getFirstChild();
		AST featureCallAst = objectAst.getNextSibling();
		Object target = context.getExecutorFactory().executeAST(objectAst, context);
		
		String operationName = featureCallAst.getText();
		IModel owningModel = context.getModelRepository().getOwningModel(target);
		
		AbstractOperation operation = getAbstractOperation(target, operationName, featureCallAst, owningModel, context);
		if (operation instanceof SelectBasedOperation) {
			((SelectBasedOperation) operation).setSelectOperation(
				(SelectOperation) getAbstractOperation(target, "select", featureCallAst, owningModel, context));
		}
		return operation.execute(target, featureCallAst, context);
	}
	
	
}

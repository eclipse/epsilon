package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectBasedOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.models.IModel;

public class FirstOrderOperationCallExpression extends FeatureCallExpression {
	
	protected NameExpression operationNameExpression;
	protected List<Parameter> parameters = new ArrayList<Parameter>();
	protected List<Expression> expressions = new ArrayList<Expression>();
	
	@Override
	public void build() {
		super.build();
		targetExpression = (Expression) getFirstChild();
		operationNameExpression = (NameExpression) getSecondChild();
		for (AST ast : operationNameExpression.getFirstChild().getChildren()) {
			parameters.add((Parameter) ast);
		}
		for (AST ast : operationNameExpression.getChildren()) {
			if (ast != operationNameExpression.getFirstChild()) {
				expressions.add((Expression) ast);
			}
		}
	}
	
	public Object execute(IEolContext context) throws EolRuntimeException {
		AST featureCallAst = getSecondChild();
		Object target = context.getExecutorFactory().executeAST(targetExpression, context);
		
		String operationName = featureCallAst.getText();
		IModel owningModel = context.getModelRepository().getOwningModel(target);
		
		AbstractOperation operation = getAbstractOperation(target, operationName, featureCallAst, owningModel, context);
		if (operation instanceof SelectBasedOperation) {
			((SelectBasedOperation) operation).setSelectOperation(
				(SelectOperation) getAbstractOperation(target, "select", featureCallAst, owningModel, context));
		}
		return operation.execute(target, featureCallAst, context);
	}
	
	public void setOperationNameExpression(
			NameExpression operationNameExpression) {
		this.operationNameExpression = operationNameExpression;
	}
	
	public NameExpression getOperationNameExpression() {
		return operationNameExpression;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}
	
	public List<Expression> getExpressions() {
		return expressions;
	}
	
}

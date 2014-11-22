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
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolNoType;

public class FirstOrderOperationCallExpression extends FeatureCallExpression {
	
	protected NameExpression nameExpression;
	protected List<Parameter> parameters = new ArrayList<Parameter>();
	protected List<Expression> expressions = new ArrayList<Expression>();
	
	public FirstOrderOperationCallExpression() {}
	
	public FirstOrderOperationCallExpression(Expression targetExpression, NameExpression nameExpression, Parameter parameter, Expression expression) {
		this.targetExpression = targetExpression;
		this.nameExpression = nameExpression;
		this.parameters.add(parameter);
		this.expressions.add(expression);
	}
	
	@Override
	public void build() {
		super.build();
		if (getFirstChild().getType() != EolParser.PARAMLIST) { 
			targetExpression = (Expression) getFirstChild();
			nameExpression = (NameExpression) getSecondChild();
			for (AST ast : nameExpression.getFirstChild().getChildren()) {
				parameters.add((Parameter) ast);
			}
			for (AST ast : nameExpression.getChildren()) {
				if (ast != nameExpression.getFirstChild()) {
					expressions.add((Expression) ast);
				}
			}
		}
		else {
			nameExpression = new NameExpression(this.getText());
			nameExpression.setRegion(this.getRegion());
			nameExpression.setUri(this.getUri());
			nameExpression.setModule(this.getModule());
			for (AST ast : getFirstChild().getChildren()) {
				parameters.add((Parameter) ast);
			}
			for (AST ast : getChildren()) {
				if (ast != getFirstChild()) {
					expressions.add((Expression) ast);
				}
			}
		}
	}
	
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object target = EolNoType.Instance;
		if (targetExpression != null) {
			target = context.getExecutorFactory().executeAST(targetExpression, context);
		}
		
		String operationName = nameExpression.getName();
		IModel owningModel = context.getModelRepository().getOwningModel(target);
		
		AbstractOperation operation = getAbstractOperation(target, operationName, nameExpression, owningModel, context);
		if (operation instanceof SelectBasedOperation) {
			((SelectBasedOperation) operation).setSelectOperation(
				(SelectOperation) getAbstractOperation(target, "select", nameExpression, owningModel, context));
		}
		return operation.execute(target, nameExpression, parameters, expressions, context);
	}
	
	public NameExpression getNameExpression() {
		return nameExpression;
	}
	
	public void setNameExpression(NameExpression nameExpression) {
		this.nameExpression = nameExpression;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}
	
	public List<Expression> getExpressions() {
		return expressions;
	}
	
}

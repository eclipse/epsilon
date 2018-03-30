package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectBasedOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolMapType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public class FirstOrderOperationCallExpression extends FeatureCallExpression {
	
	protected NameExpression nameExpression;
	protected List<Parameter> parameters = new ArrayList<>();
	protected List<Expression> expressions = new ArrayList<>();
	
	public FirstOrderOperationCallExpression() {}
	
	public FirstOrderOperationCallExpression(Expression targetExpression, NameExpression nameExpression, Parameter parameter, Expression expression) {
		this.targetExpression = targetExpression;
		this.nameExpression = nameExpression;
		this.parameters.add(parameter);
		this.expressions.add(expression);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		if (cst.getFirstChild().getType() != EolParser.PARAMLIST) { 
			targetExpression = (Expression) module.createAst(cst.getFirstChild(), this);
			nameExpression = (NameExpression) module.createAst(cst.getSecondChild(), this);
			for (AST ast : cst.getSecondChild().getFirstChild().getChildren()) {
				parameters.add((Parameter) module.createAst(ast, this));
			}
			for (AST ast : cst.getSecondChild().getChildren()) {
				if (ast != cst.getSecondChild().getFirstChild()) {
					expressions.add((Expression) module.createAst(ast, this));
				}
			}
		}
		else {
			nameExpression = new NameExpression(cst.getText());
			nameExpression.setRegion(cst.getRegion());
			nameExpression.setUri(cst.getUri());
			nameExpression.setModule(cst.getModule());
			for (AST ast : cst.getFirstChild().getChildren()) {
				parameters.add((Parameter) module.createAst(ast, this));
			}
			for (AST ast : cst.getChildren()) {
				if (ast != cst.getFirstChild()) {
					expressions.add((Expression) module.createAst(ast, this));
				}
			}
		}
	}
	
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object target = EolNoType.Instance;
		if (targetExpression != null) {
			target = context.getExecutorFactory().execute(targetExpression, context);
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
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
		EolType contextType = null;
		if (targetExpression.getResolvedType() instanceof EolCollectionType) {
			contextType = ((EolCollectionType) targetExpression.getResolvedType()).getContentType();
		}
		else if (targetExpression.getResolvedType() == EolAnyType.Instance) {
			contextType = targetExpression.getResolvedType();
		}
		if (contextType != null) {
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			Parameter parameter = parameters.get(0);
			parameter.compile(context, false);
			if (parameter.isExplicitlyTyped()) {
				//TODO: Check that the type of the parameter is a subtype of the type of the collection
				contextType = parameter.getCompilationType();
			}
			context.getFrameStack().put(new Variable(parameter.getName(), contextType));
			
			Expression expression = expressions.get(0);
			expression.compile(context);
			
			context.getFrameStack().leaveLocal(this);
			
			if (StringUtil.isOneOf(nameExpression.getName(), "select", "reject", "closure", "sortBy")) {
				resolvedType = new EolCollectionType("Sequence", contextType);
			}
			else if (nameExpression.getName().equals("selectOne")) {
				resolvedType = contextType;
			}
			else if (nameExpression.getName().equals("collect")) {
				resolvedType = new EolCollectionType("Sequence", expression.getResolvedType());
			}
			else if (StringUtil.isOneOf(nameExpression.getName(), "exists", "forAll")) {
				resolvedType = EolPrimitiveType.Boolean;
			}
			else if (nameExpression.getName().equals("aggregate")) {
				if (expressions.size() == 2) {
					Expression valueExpression = expressions.get(1);
					valueExpression.compile(context);
					resolvedType = new EolMapType(expression.getResolvedType(), valueExpression.getResolvedType());
				}
				else {
					context.addErrorMarker(nameExpression, "Aggregate requires a key and a value expression");
				}
			}
			
			if (StringUtil.isOneOf(nameExpression.getName(), "select", "selectOne", "reject", "exists", "one", "forAll", "closure")) {
				if (expression.getResolvedType().isNot(EolPrimitiveType.Boolean)) {
					context.addErrorMarker(expression, "Expression should return a Boolean but returns a " + expression.getResolvedType().getName() + " instead");
				}
			}
			
		}
		else {
			context.addErrorMarker(nameExpression, "Operation " + nameExpression.getName() + " only applies to collections");
		}
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

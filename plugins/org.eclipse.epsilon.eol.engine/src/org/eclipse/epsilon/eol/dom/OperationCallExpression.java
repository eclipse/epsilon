package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolNoType;

public class OperationCallExpression extends FeatureCallExpression {
	
	
	public static void main(String[] args) throws Exception {
		EolModule module = new EolModule();
		module.parse("foo();a.foo();");
	}
	
	protected AST operationCallAst = null;
	protected String operationName;
	protected NameExpression operationNameExpression = null;
	protected List<Expression> parameterExpressions = new ArrayList<Expression>();
	protected boolean contextless;
	
	public OperationCallExpression() {
		super();
	}
	
	public OperationCallExpression(boolean contextless) {
		this.contextless = contextless;
	}
	
	@Override
	public void build() {
		super.build();
		AST parametersAst = null;
		if (!contextless) {
			targetExpression = (Expression) getFirstChild();
			operationCallAst = targetExpression.getNextSibling();
			operationName = operationCallAst.getText();
			operationNameExpression = (NameExpression) operationCallAst;
			parametersAst = operationCallAst.getFirstChild();
		}
		else {
			operationName = this.getText();
			operationNameExpression = new NameExpression();
			operationNameExpression.setRegion(this.getRegion());
			operationNameExpression.setUri(this.getUri());
			operationNameExpression.setModule(this.getModule());
			
			parametersAst = getFirstChild();
			operationCallAst = this;
		}
		for (AST parameterAst : parametersAst.getChildren()) {
			parameterExpressions.add((Expression) parameterAst);
		}
		System.out.println(this.toExtendedStringTree());
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		Object targetObject;
		
		if (!contextless) {
			targetObject = context.getExecutorFactory().executeAST(targetExpression, context);
		}
		else {
			targetObject = EolNoType.NoInstance;
		}
		
		IModel owningModel = context.getModelRepository().getOwningModel(targetObject);
		
		// Non-overridable operations
		AbstractOperation operation = context.getOperationFactory().getOperationFor(operationName);
		if (operation != null && (!operation.isOverridable())){
			return operation.execute(targetObject, operationNameExpression, new ArrayList<Parameter>(), parameterExpressions, context);
		}
		
		// Operation contributor for model elements
		OperationContributor modelOperationContributor = null;
		if (owningModel != null && owningModel instanceof IOperationContributorProvider) {
			modelOperationContributor = ((IOperationContributorProvider) owningModel).getOperationContributor();
		}
		
		// Method contributors that use the unevaluated AST
		ObjectMethod objectMethodAst = null;
		
		if (modelOperationContributor != null) {
			objectMethodAst = modelOperationContributor.findContributedMethodForUnevaluatedParameters(targetObject, operationName, context);
		}
		if (objectMethodAst == null) {
			objectMethodAst = context.getOperationContributorRegistry().findContributedMethodForUnevaluatedParameters(targetObject, operationName, context);
		}
		
		if (objectMethodAst != null) {
			return wrap(objectMethodAst.execute(new Object[]{operationCallAst}, operationCallAst));
		}
		
		ArrayList<Object> parameterValues = new ArrayList<Object>();
		
		for (Expression parameter : parameterExpressions) {
			parameterValues.add(context.getExecutorFactory().executeAST(parameter, context));
		}
		
		// Execute user-defined operation (if isArrow() == false)
		if (context.getModule() instanceof IEolLibraryModule && !isArrow()){
			Operation helper = ((IEolLibraryModule) context.getModule()).getOperations().getOperation(targetObject, operationCallAst , parameterValues, context);
			if (helper != null){
				return ((IEolLibraryModule) context.getModule()).getOperations().execute(targetObject, helper, operationCallAst, parameterValues, context);
			}
		}
		
		// Method contributors that use the evaluated parameters
		ObjectMethod objectMethod = null;
		if (modelOperationContributor != null) {
			objectMethod = modelOperationContributor.findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValues.toArray(), context);
		}
		
		if (objectMethod == null) {
			objectMethod = context.getOperationContributorRegistry().findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValues.toArray(), context);
		}
		
		if (objectMethod != null) {
			return wrap(objectMethod.execute(parameterValues.toArray(), operationCallAst));
		}

		// Execute user-defined operation (if isArrow() == true)
		if (operation instanceof SimpleOperation) {
			return ((SimpleOperation) operation).execute(targetObject, parameterValues, context, operationCallAst);
		}

		throw new EolIllegalOperationException(targetObject, operationName, operationCallAst, context.getPrettyPrinterManager());
		
	}
	
	public String getOperationName() {
		return operationName;
	}
	
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	public void setContextless(boolean contextless) {
		this.contextless = contextless;
	}
	
	public boolean isContextless() {
		return contextless;
	}
	
	public List<Expression> getParameterExpressions() {
		return parameterExpressions;
	}
}

package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
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
	
	protected final ArrayList<Expression> parameterExpressions = new ArrayList<>(0);
	protected NameExpression nameExpression;
	protected boolean contextless;
	
	public OperationCallExpression() {}
	
	public OperationCallExpression(Expression targetExpression, NameExpression nameExpression, Expression... parameterExpressions) {
		this.targetExpression = targetExpression;
		this.nameExpression = nameExpression;
		this.contextless = (targetExpression == null);
		if (parameterExpressions != null) {
			this.parameterExpressions.ensureCapacity(parameterExpressions.length);
			for (Expression parameterExpression : parameterExpressions) {
				this.parameterExpressions.add(parameterExpression);
			}
		}
	}
	
	public OperationCallExpression(boolean contextless) {
		this.contextless = contextless;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		AST parametersAst = null;
		if (!contextless) {
			targetExpression = (Expression) module.createAst(cst.getFirstChild(), this);
			nameExpression = (NameExpression) module.createAst(cst.getSecondChild(), this);
			parametersAst = cst.getSecondChild().getFirstChild();
		}
		else {
			nameExpression = new NameExpression(cst.getText());
			nameExpression.setRegion(cst.getRegion());
			nameExpression.setUri(cst.getUri());
			nameExpression.setModule(cst.getModule());
			parametersAst = cst.getFirstChild();
		}
		
		List<AST> parametersChildren = parametersAst.getChildren();
		parameterExpressions.ensureCapacity(parameterExpressions.size()+parametersChildren.size());
		
		for (AST parameterAst : parametersChildren) {
			parameterExpressions.add((Expression) module.createAst(parameterAst, this));
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object targetObject;
		String operationName = nameExpression.getName();
		
		if (!contextless) {
			targetObject = context.getExecutorFactory().execute(targetExpression, context);
		}
		else {
			targetObject = EolNoType.NoInstance;
		}
				
		IModel owningModel = context.getModelRepository().getOwningModel(targetObject);
		
		// Non-overridable operations
		AbstractOperation operation = context.getOperationFactory().getOperationFor(operationName);
		if (operation != null && (!operation.isOverridable())) {
			return operation.execute(targetObject, nameExpression, new ArrayList<Parameter>(), parameterExpressions, context);
		}
		
		// Operation contributor for model elements
		OperationContributor operationContributor = null;
		if (targetObject instanceof IOperationContributorProvider) {
			operationContributor = ((IOperationContributorProvider) targetObject).getOperationContributor();
		}
		else if (owningModel != null && owningModel instanceof IOperationContributorProvider) {
			operationContributor = ((IOperationContributorProvider) owningModel).getOperationContributor();
		}
		
		// Method contributors that use the unevaluated AST
		ObjectMethod objectMethod = null;
		
		if (operationContributor != null) {
			objectMethod = operationContributor
				.findContributedMethodForUnevaluatedParameters(targetObject, operationName, parameterExpressions, context);
		}
		if (objectMethod == null) {
			objectMethod = context.getOperationContributorRegistry()
				.findContributedMethodForUnevaluatedParameters(targetObject, operationName, parameterExpressions, context);
		}
		
		if (objectMethod != null) {
			return wrap(objectMethod.execute(new Object[]{nameExpression}, nameExpression));
		}
		
		ArrayList<Object> parameterValues = new ArrayList<>(parameterExpressions.size());
		
		for (Expression parameter : parameterExpressions) {
			parameterValues.add(context.getExecutorFactory().execute(parameter, context));
		}
		
		// Execute user-defined operation (if isArrow() == false)
		if (context.getModule() instanceof IEolModule && !isArrow()) {
			OperationList operations = ((IEolModule) context.getModule()).getOperations();
			Operation helper = operations.getOperation(targetObject, nameExpression , parameterValues, context);

			if (helper != null) {
				return helper.execute(targetObject, parameterValues, context);
			}
		}
		
		Object[] parameterValuesArray = parameterValues.toArray();
		
		// Method contributors that use the evaluated parameters
		if (operationContributor != null) {
			// Try contributors that override the context's operation contributor registry
			objectMethod = operationContributor
				.findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValuesArray, context, true);
		}
		
		if (objectMethod == null) {
			objectMethod = context.getOperationContributorRegistry()
				.findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValuesArray, context);
		}
		
		if (operationContributor != null && objectMethod == null) {
			// Try contributors that do not override the context's operation contributor registry
			objectMethod = operationContributor
				.findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValuesArray, context, false);
		} 
		
		if (objectMethod != null) {
			return wrap(objectMethod.execute(parameterValuesArray, nameExpression));
		}

		// Execute user-defined operation (if isArrow() == true)
		if (operation instanceof SimpleOperation) {
			return ((SimpleOperation) operation).execute(targetObject, parameterValues, context, nameExpression);
		}

		// No operation found
		throw new EolIllegalOperationException(targetObject, operationName, nameExpression, context.getPrettyPrinterManager());
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		if (targetExpression != null) targetExpression.compile(context);
		for (Expression parameterExpression : parameterExpressions) {
			parameterExpression.compile(context);
		}
	}
	
	public String getOperationName() {
		return nameExpression.getName();
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
	
	public NameExpression getNameExpression() {
		return nameExpression;
	}
}

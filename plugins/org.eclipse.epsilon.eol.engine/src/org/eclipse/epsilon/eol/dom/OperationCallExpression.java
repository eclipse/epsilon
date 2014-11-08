package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

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
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolNoType;

public class OperationCallExpression extends FeatureCallExpression {
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		module.parse("OrderedSet{1,2,3}.sortBy(i|i);");
		//module.parse("foo(); operation foo(){'foo'.println();}");
		//module.execute();
		for (AST descendant : module.getAst().getDescendants()) {
			System.out.println(descendant.getClass().getCanonicalName() + " - " + descendant.getText());
		}
		
	}
	
	protected boolean contextless;
	
	public OperationCallExpression() {
		super();
	}
	
	public OperationCallExpression(boolean contextless) {
		this.contextless = contextless;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		AST featureCallAst;
		Object target;
		
		if (!contextless) {
			AST objectAst = getFirstChild();
			featureCallAst = objectAst.getNextSibling();
			target = context.getExecutorFactory().executeAST(objectAst, context);
		}
		else {
			featureCallAst = this;
			target = EolNoType.NoInstance;
		}
		
		AST parametersAst = featureCallAst.getFirstChild();
		String operationName = featureCallAst.getText();
		IModel owningModel = context.getModelRepository().getOwningModel(target);
		
		// Non-overridable operations
		AbstractOperation operation = context.getOperationFactory().getOperationFor(operationName);
		if (operation != null && (!operation.isOverridable())){
			return operation.execute(target, featureCallAst, context);
		}
		
		// Operation contributor for model elements
		OperationContributor modelOperationContributor = null;
		if (owningModel != null && owningModel instanceof IOperationContributorProvider) {
			modelOperationContributor = ((IOperationContributorProvider) owningModel).getOperationContributor();
		}
		
		// Method contributors that use the unevaluated AST
		ObjectMethod objectMethodAst = null;
		
		if (modelOperationContributor != null) {
			objectMethodAst = modelOperationContributor.findContributedMethodForUnevaluatedParameters(target, operationName, context);
		}
		if (objectMethodAst == null) {
			objectMethodAst = context.getOperationContributorRegistry().findContributedMethodForUnevaluatedParameters(target, operationName, context);
		}
		
		if (objectMethodAst != null) {
			return wrap(objectMethodAst.execute(new Object[]{featureCallAst}, featureCallAst));
		}
		
		//ArrayList<?> parameters = (ArrayList<?>) context.getExecutorFactory().executeAST(parametersAst, context);
		AST parameterAst = parametersAst.getFirstChild();
		ArrayList<Object> parameters = new ArrayList<Object>();
		
		while (parameterAst != null){
			parameters.add(context.getExecutorFactory().executeAST(parameterAst, context));
			parameterAst = parameterAst.getNextSibling();
		}
		
		// Execute user-defined operation (if isArrow() == false)
		if (context.getModule() instanceof IEolLibraryModule && !isArrow()){
			Operation helper = ((IEolLibraryModule) context.getModule()).getOperations().getOperation(target, featureCallAst , parameters, context);
			if (helper != null){
				return ((IEolLibraryModule) context.getModule()).getOperations().execute(target, helper, featureCallAst, parameters, context);
			}
		}
		
		// Method contributors that use the evaluated parameters
		ObjectMethod objectMethod = null;
		if (modelOperationContributor != null) {
			objectMethod = modelOperationContributor.findContributedMethodForEvaluatedParameters(target, operationName, parameters.toArray(), context);
		}
		
		if (objectMethod == null) {
			objectMethod = context.getOperationContributorRegistry().findContributedMethodForEvaluatedParameters(target, operationName, parameters.toArray(), context);
		}
		
		if (objectMethod != null) {
			return wrap(objectMethod.execute(parameters.toArray(), featureCallAst));
		}

		// Execute user-defined operation (if isArrow() == true)
		if (operation != null){
			if (operation instanceof AbstractSimpleOperation) {
				return ((AbstractSimpleOperation) operation).execute(target, parameters, context, featureCallAst);
			}
			else {
				return operation.execute(target, featureCallAst, context);
			}
		}

		throw new EolIllegalOperationException(target, operationName, featureCallAst, context.getPrettyPrinterManager());
		
	}
}

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributor;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.declarative.IteratorOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectBasedOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolAnyType;


public class PointExecutor extends AbstractExecutor{
	
	public Object execute(AST ast, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		AST objectAst = ast.getFirstChild();
		AST featureCallAst = objectAst.getNextSibling();
		Object source = context.getExecutorFactory().executeAST(objectAst, context);
		return execute(source, featureCallAst, context, returnSetter);
	}
	
	protected boolean isArrow() { return false; }
	
	public Object execute(Object source, AST featureCallAst, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		
		AST parametersAst = featureCallAst.getFirstChild();
		if (parametersAst == null) {
			
			String propertyName = featureCallAst.getText();
			if (source == null) throw new EolRuntimeException("Called feature " + propertyName + " on undefined object", featureCallAst, context.getFrameStack());
			
			if (returnSetter){
				IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(source, propertyName, context);
				setter.setAst(featureCallAst);
				return setter;
			} else{
				IPropertyGetter getter = context.getIntrospectionManager().getPropertyGetterFor(source, propertyName, context);
				
				// Added support for properties on collections
				if (source instanceof Collection<?> && !getter.hasProperty(source, propertyName)) {
					
					// Transform x.y to x.collect(_iterator | _iterator.y)
					IteratorOperation collectOperation = (IteratorOperation) getAbstractOperation(source, "collect", featureCallAst, context.getModelRepository().getOwningModel(source), context);
					AST expressionAst = new AST(new CommonToken(EolParser.POINT, "."), null);
					expressionAst.addChild(new AST(new CommonToken(EolParser.NAME, "_iterator"), null));
					expressionAst.addChild(new AST(new CommonToken(EolParser.NAME, propertyName), null));
					
					return collectOperation.execute(source, new Variable("_iterator", null, EolAnyType.Instance), expressionAst, context);
				}
				
				getter.setAst(featureCallAst);
				recordPropertyAccess(source, featureCallAst, context);
				
				return wrap(getter.invoke(source, propertyName));
			}
		
		} else {

			return executeOperation(context, source, featureCallAst);
		}
	}

	private void recordPropertyAccess(Object source, AST featureCallAst, IEolContext context) {
		// Only record property accesses that involve obtaining a property's value from an IModel
		// (and not, for example, the set of extended properties) 
		if (context.getIntrospectionManager().isModelBasedProperty(source, featureCallAst.getText(), context)) {
			context.getPropertyAccessRecorder().record(source, featureCallAst.getText());
		}
	}
	
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		return execute(ast, context, false);
		
	}
	
	public Object executeOperation(IEolContext context, Object target, AST featureCallAst) throws EolRuntimeException {
		
		AST parametersAst = featureCallAst.getFirstChild();
		String operationName = featureCallAst.getText();
		IModel owningModel = context.getModelRepository().getOwningModel(target);
		
		// Handles calls to higher-order operations (select(), collect() etc)
		if (parametersAst.getType() == EolParser.PARAMLIST) {
			AbstractOperation operation = getAbstractOperation(target, operationName, featureCallAst, owningModel, context);
			if (operation instanceof SelectBasedOperation) {
				((SelectBasedOperation) operation).setSelectOperation(
					(SelectOperation) getAbstractOperation(target, "select", featureCallAst, owningModel, context));
			}
			return operation.execute(target, featureCallAst, context);
		}
		
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
			return wrap(objectMethodAst.execute(new Object[]{featureCallAst}, featureCallAst, context.getFrameStack()));
		}
		
		ArrayList<Object> parameters = (ArrayList<Object>) context.getExecutorFactory().executeAST(parametersAst, context);
		
		// Execute user-defined operation (if isArrow() == false)
		if (context.getModule() instanceof IEolLibraryModule && !isArrow()){
			EolOperation helper = ((IEolLibraryModule) context.getModule()).getOperations().getOperation(target, featureCallAst , parameters, context);
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
			return wrap(objectMethod.execute(parameters.toArray(), featureCallAst, context.getFrameStack()));
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

		throw new EolIllegalOperationException(target, operationName, featureCallAst, context.getFrameStack(), context.getPrettyPrinterManager());
	}
	
	protected AbstractOperation getAbstractOperation(Object target, String name, AST featureCallAst, IModel owningModel, IEolContext context) throws EolIllegalOperationException {
		
		// Objects implementing the IAbstractOperationContributor interface
		// can override the default higher-order operation implementations
		if (target instanceof IAbstractOperationContributor) {
			AbstractOperation operation = ((IAbstractOperationContributor) target).getAbstractOperation(name);
			if (operation != null) return operation;
		}
		
		// Since we don't control the interface of all model elements, models
		// can also provide IAbstractOperationContributors for their model elements
		if (owningModel!=null && owningModel instanceof IAbstractOperationContributorProvider) {
			IAbstractOperationContributor contributor = ((IAbstractOperationContributorProvider) owningModel).getAbstractOperationContributor(target);
			if (contributor != null) {
				AbstractOperation operation = contributor.getAbstractOperation(name);
				if (operation != null) return operation;					
			}
		}
		
		AbstractOperation operation = context.getOperationFactory().getOperationFor(name);
		if (operation != null) {
			return operation;
		}
		else {
			throw new EolIllegalOperationException(target, name, featureCallAst, context.getFrameStack(), context.getPrettyPrinterManager());
		}
	}
	
	public Object wrap(Object o) {
		/*
		// Removed this wrap as it can be very inefficient for large iterators
		if (o instanceof Iterator) {
			List list = new EolSequence();
			Iterator it = (Iterator) o;
			while (it.hasNext()) {
				list.add(it.next());
			}
			return list;
		}
		else*/ 
		
		if (o instanceof Object[]) {
			return new ArrayList<Object>(Arrays.asList((Object[]) o));
		}
		else 
			return o;
	}
	
}

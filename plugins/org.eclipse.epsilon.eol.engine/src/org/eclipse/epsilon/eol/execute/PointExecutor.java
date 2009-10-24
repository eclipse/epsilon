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

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;
import org.eclipse.epsilon.eol.util.ReflectionUtil;


public class PointExecutor extends AbstractExecutor{
	
	public Object execute(AST ast, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		AST objectAst = ast.getFirstChild();
		AST featureCallAst = objectAst.getNextSibling();
		Object source = context.getExecutorFactory().executeAST(objectAst, context);
		return execute(source, featureCallAst, context, returnSetter);
	}
	
	public Object execute(Object source, AST featureCallAst, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		
		AST parametersAst = featureCallAst.getFirstChild();
		if (parametersAst == null) {
			
			//TODO : Add support for collection properties (un-settable?)
			//Class.all().name := Sequence{1..10};
			//FIXED : If source == null let the user know the name of the feature call that fails
			
			if (source == null) throw new EolRuntimeException("Called feature " + featureCallAst.getText() + " on undefined object", featureCallAst);
			
			if (returnSetter){
				IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(source, featureCallAst.getText(), context);
				setter.setAst(featureCallAst);
				return setter;
			} else{
				IPropertyGetter getter = context.getIntrospectionManager().getPropertyGetterFor(source, featureCallAst.getText(), context);
				getter.setAst(featureCallAst);
				return EolTypeWrapper.getInstance().wrap(getter.invoke(source, featureCallAst.getText()));
			}
		}
		//TODO : See parameters defining variables
		//else if (parametersAst.getType() == EolParser.PARAMETERSDEFININGVARS){
		//	return context.getOperationFactory().executeOperation(source, featureCallAst, context);
		//}
		else { //if (parametersAst.getType() == EolParser.PARAMETERS){

			return executeOperation(context, source, featureCallAst, true);
			
			/*
			else{
			// Non-overridable operations
			AbstractOperation operation = context.getOperationFactory().getOperationFor(featureCallAst, context);
			if (operation != null && (!operation.isOverridable())){
				return operation.execute(source, featureCallAst, context);
			}
			
			ArrayList parameters = (ArrayList) context.getExecutorFactory().executeAST(parametersAst, context);
			
			if (context.getModule() instanceof IEolLibraryModule){
				
				// Helpers
				EolOperation helper = ((IEolLibraryModule) context.getModule()).getOperations().getOperation(source, featureCallAst , parameters, context);
				if (helper != null){
					return ((IEolLibraryModule) context.getModule()).getOperations().execute(source, helper, featureCallAst, parameters, context);
				}
			}
			
			// Reflection
			
			Method method = null;
			
			// First try with unwrapped parameters
			
			method = ReflectionUtil.getMethodFor(source, featureCallAst.getText(), parameters.toArray(), true);
			if (method != null) {
				//FIXED : Do not recalculate method when calling execute() - call another execute!
				//return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, featureCallAst.getText(), parameters.toArray(), true, featureCallAst));
				return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, method, parameters.toArray(), true, featureCallAst));
			}
			
			// Then try with wrapped parameters
			method = ReflectionUtil.getMethodFor(source, featureCallAst.getText(), parameters.toArray(), false);
			if (method != null) {
				//return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, featureCallAst.getText(), parameters.toArray(), false, featureCallAst));
				return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, method, parameters.toArray(), false, featureCallAst));
			}
			
			// Operations
			// operation = context.getOperationFactory().getOperationFor(featureCallAst, context);
			if (operation != null){
				return operation.execute(source, featureCallAst, context);
			}
			*/
		}
		
		//throw new EolIllegalOperationException(source, featureCallAst.getText(), featureCallAst);
		
	}
	
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		return execute(ast, context, false);
		
	}
	
	public Object executeOperation(IEolContext context, Object source, AST featureCallAst, boolean executeHelpers) throws EolRuntimeException {
		
		AST parametersAst = featureCallAst.getFirstChild();
		
		if (parametersAst.getType() == EolParser.PARAMLIST) {
			return context.getOperationFactory().executeOperation(source, featureCallAst, context);
		}
		
		// If method starts with _ we execute it with wrapped parameters
		if (featureCallAst.getText().startsWith("_")) {
			String methodName = featureCallAst.getText().substring(1);
			ArrayList parameters = (ArrayList) context.getExecutorFactory().executeAST(parametersAst, context);
			Method method = ReflectionUtil.getMethodFor(source, methodName, parameters.toArray(), false);
			if (method != null) {
				//FIXED : Do not recalculate method when calling execute() - call another execute!
				return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, method, parameters.toArray(), false, featureCallAst));
			}
			else {
				throw new EolIllegalOperationException(source, methodName, featureCallAst);
			}
		}
	
		// Non-overridable operations
		AbstractOperation operation = context.getOperationFactory().getOperationFor(featureCallAst, context);
		if (operation != null && (!operation.isOverridable())){
			return operation.execute(source, featureCallAst, context);
		}
		
		ArrayList parameters = (ArrayList) context.getExecutorFactory().executeAST(parametersAst, context);
		
		if (context.getModule() instanceof IEolLibraryModule && executeHelpers){
			// Helpers
			EolOperation helper = ((IEolLibraryModule) context.getModule()).getOperations().getOperation(source, featureCallAst , parameters, context);
			if (helper != null){
				return ((IEolLibraryModule) context.getModule()).getOperations().execute(source, helper, featureCallAst, parameters, context);
			}
		}
		
		// Reflection
		Method method = null;
		if (ReflectionUtil.hasMethods(source, featureCallAst.getText())) {
			// First try with unwrapped parameters
			method = ReflectionUtil.getMethodFor(source, featureCallAst.getText(), parameters.toArray(), true);
			if (method != null) {
				//FIXED : Do not recalculate method when calling execute() - call another execute!
				//return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, featureCallAst.getText(), parameters.toArray(), true, featureCallAst));
				return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, method, parameters.toArray(), true, featureCallAst));
			}
			
			// Then try with wrapped parameters
			method = ReflectionUtil.getMethodFor(source, featureCallAst.getText(), parameters.toArray(), false);
			if (method != null) {
				//return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, featureCallAst.getText(), parameters.toArray(), false, featureCallAst));
				return EolTypeWrapper.getInstance().wrap(ReflectionUtil.executeMethod(source, method, parameters.toArray(), false, featureCallAst));
			}
		}
		
		// Operations
		// operation = context.getOperationFactory().getOperationFor(featureCallAst, context);
		if (operation != null){
			return operation.execute(source, featureCallAst, context);
		}
		
		throw new EolIllegalOperationException(source, featureCallAst.getText(), featureCallAst);
		
	}
	
	
}

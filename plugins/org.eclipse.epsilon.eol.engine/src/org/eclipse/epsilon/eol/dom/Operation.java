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
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.contributors.IterableOperationContributor;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolType;


public class Operation extends AnnotatableModuleElement implements ICompilableModuleElement {
	
	protected String name = "";
	protected TypeExpression contextTypeExpression;
	protected EolType contextType;
	protected TypeExpression returnTypeExpression;
	protected EolType returnType;
	protected StatementBlock body;
	protected List<Parameter> formalParameters = new ArrayList<Parameter>();

	// This field is lazily initialized by calling isCached(). If this
	// operation cannot be cached, it will stay null, to save some memory.
	protected EolMap cache;
	
	//TODO: Add guards to helpers
	//DONE: Go for context-less helpers
	public Operation(){
		
	}
	
	@Override
	public void build() {
		super.build();
		
		AST nameAst = null;
		if (getFirstChild().getType() == EolParser.TYPE) {
			contextTypeExpression = (TypeExpression) getFirstChild();
			nameAst = contextTypeExpression.getNextSibling(); 
		}
		else {
			nameAst = getFirstChild();
		}
		AST paramListAst = null;
		AST returnAst = null;
		AST bodyAst = null;
		
		if (nameAst.getNextSibling().getType() == EolParser.PARAMLIST){
			paramListAst = nameAst.getNextSibling();
		}
		
		if (paramListAst != null){ // helper with parameters
			if (paramListAst.getNextSibling().getType() == EolParser.TYPE){ // with return type
				returnAst = paramListAst.getNextSibling();
				bodyAst = returnAst.getNextSibling();
			} else { // without return type
				bodyAst = paramListAst.getNextSibling();
			}
		} else { // helper without parameters
			if (nameAst.getNextSibling().getType() == EolParser.TYPE){ //with return type
				returnAst = nameAst.getNextSibling();
				bodyAst = returnAst.getNextSibling();
			} else { // without return type
				bodyAst = nameAst.getNextSibling();
			}
		}
		
		this.body = (StatementBlock) bodyAst;
		this.name = nameAst.getText();
		this.returnTypeExpression = (TypeExpression) returnAst;
		if (paramListAst != null) {
			for (AST formalParameterAst : paramListAst.getChildren()) {
				formalParameters.add((Parameter)formalParameterAst);
			}
		}
		
	}

	@Override
	public void compile(EolCompilationContext context) {
		EolType contextType = EolNoType.Instance;
		if (contextTypeExpression != null) {
			contextTypeExpression.compile(context);
			contextType = contextTypeExpression.getCompilationType();
		}
		
		context.getFrameStack().enterLocal(FrameType.PROTECTED, this, new Variable("self", contextType));
		for (Parameter parameter : formalParameters) {
			parameter.compile(context);
		}
		body.compile(context);
		context.getFrameStack().leaveLocal(this);
	}
	
	public void clearCache() {
		if (isCached()) {
			cache.clear();
		}

		// This is important for EUnit, as it ensures that the cached
		// type information will be re-evaluated for the reloaded models
		contextType = returnType = null;
		for (Parameter formalParameter : formalParameters) {
			formalParameter.clearCache();
		}
	}
	
	@Override
	public String toString(){
		String contextTypeName = "";
		String returnTypeName = "";

		if (contextTypeExpression != null) {
			contextTypeName = " - " + contextTypeExpression.getText();// + ".";
		}
		if (returnTypeExpression != null) {
			returnTypeName = " : " + returnTypeExpression.getText();
		}
		
		return name + "(" + new IterableOperationContributor(formalParameters).concat(", ") + ")" + returnTypeName + contextTypeName;
	}

	public synchronized boolean isCached() {
		if (hasAnnotation("cached") && this.formalParameters.isEmpty()) {
			// The cache only needs to be created if we use it
			if (cache == null) {
				// Do not clobber an already existing cache
				cache = new EolMap();
			}
			return true;
		}
		return false;
	}

	public Object execute(Object self, List parameterValues, IEolContext context) throws EolRuntimeException{
		return execute(self, parameterValues, context, true);
	}
	
	
	public Object execute(Object self, List parameterValues, IEolContext context, boolean inNewStackFrame) throws EolRuntimeException{
		
		if (isCached() && cache.containsKey(self)) {
			return cache.get(self);
		}
		
		FrameStack scope = context.getFrameStack();
		
		if (inNewStackFrame) {
			scope.enterLocal(FrameType.PROTECTED, this);
			scope.put(Variable.createReadOnlyVariable("self",self));
		}
		
		for (int i=0;i<formalParameters.size();i++){
			Parameter fp = (Parameter) formalParameters.get(i);
			scope.put(new Variable(fp.getName(),parameterValues.get(i), fp.getType(context)));
		}
		
		evaluatePreConditions(context);
		
		Object result = Return.getValue(executeBody(context));

		checkResultType(result, context);
		evaluatePostConditions(context, result);
		
		if (inNewStackFrame) {
			scope.leaveLocal(this);
		}
		
		if (isCached() && !cache.containsKey(self)) {
			cache.put(self, result);
		}
		
		return result;
	}

	protected Object executeBody(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().executeAST(this.getBody(), context);
	}
	
	protected void evaluatePreConditions(IEolContext context) throws EolRuntimeException {
		for (Annotation annotation : getAnnotations("pre")) {
			if (!(annotation instanceof ExecutableAnnotation)) continue;
			
			Object satisfied = ((ExecutableAnnotation)annotation).getValue(context);
			if (satisfied instanceof Boolean) {
				if (!((Boolean) satisfied).booleanValue()) {
					throw new EolRuntimeException("Pre-condition not satisfied", annotation);
				}
			}
			else {
				throw new EolIllegalReturnException("Boolean", satisfied, annotation, context);
			}
		}
	}
	
	protected void checkResultType(Object result, IEolContext context)
			throws EolRuntimeException {
		
		if (returnTypeExpression != null && result != null) {
			if (returnType == null) {
				returnType = (EolType) context.getExecutorFactory().executeAST(returnTypeExpression, context);
			}
			if (!returnType.isKind(result)) {
				throw new EolRuntimeException(name + " is expected to return a " + returnType.getName() + ", but returned a " + result.getClass().getCanonicalName());
			}
		}
	}

	protected void evaluatePostConditions(IEolContext context, Object result) throws EolRuntimeException {
		context.getFrameStack().put(Variable.createReadOnlyVariable("_result", result));
		for (Annotation annotation : getAnnotations("post")) {
			if (!(annotation instanceof ExecutableAnnotation)) continue;
			
			Object satisfied = ((ExecutableAnnotation) annotation).getValue(context);
			if (satisfied instanceof Boolean) {
				if (!((Boolean) satisfied).booleanValue()) {
						// We can simply use the frame stack here, as we created a frame for the post-condition
						// in order to isolate the _result variable.
						throw new EolRuntimeException(
							"Post-condition not satisfied: _result was "
									+ context.getPrettyPrinterManager().print(result));
				}
			}
			else {
				throw new EolIllegalReturnException("Boolean", satisfied, annotation, context);
			}
		}
	}
	
	public List<?> getModuleElements() {
		return Collections.EMPTY_LIST;
	}
	
	public EolType getReturnType(IEolContext context) throws EolRuntimeException{
		if (returnType == null){
			if (returnTypeExpression != null){
				returnType = (EolType) context.getExecutorFactory().executeAST(returnTypeExpression,context);
			}
			else {
				returnType = EolAnyType.Instance;
			}
		}
		return returnType;
	}
	
	public EolType getContextType(IEolContext context) throws EolRuntimeException{
		if (contextType == null){
			if (contextTypeExpression != null){
				contextType = (EolType) context.getExecutorFactory().executeAST(contextTypeExpression,context);
			}
			else {
				contextType = EolNoType.Instance;
			}
		}
		return contextType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Parameter> getFormalParameters() {
		return formalParameters;
	}
	
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
	
	public TypeExpression getContextTypeExpression() {
		return contextTypeExpression;
	}
	
	public void setContextTypeExpression(TypeExpression contextTypeExpression) {
		this.contextTypeExpression = contextTypeExpression;
	}
	
	public TypeExpression getReturnTypeExpression() {
		return returnTypeExpression;
	}
	
	public void setReturnTypeExpression(TypeExpression returnTypeExpression) {
		this.returnTypeExpression = returnTypeExpression;
	}
	
}


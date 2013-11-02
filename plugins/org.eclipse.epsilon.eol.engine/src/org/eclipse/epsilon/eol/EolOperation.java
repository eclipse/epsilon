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
package org.eclipse.epsilon.eol;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.annotations.IEolAnnotation;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolType;


public class EolOperation extends AbstractModuleElement{
	
	private String name = "";
	private AST contextTypeAst;
	private EolType contextType;
	private AST returnTypeAst;
	private EolType returnType;
	private AST body;
	private EolFormalParameterList formalParameters = null;
	private AST ast;

	// This field is lazily initialized by calling isCached(). If this
	// operation cannot be cached, it will stay null, to save some memory.
	protected EolMap cache;

	public void clearCache() {
		if (isCached()) {
			cache.clear();
		}

		// This is important for EUnit, as it ensures that the cached
		// type information will be re-evaluated for the reloaded models
		contextType = returnType = null;
		formalParameters.clearCache();
	}

	/*
	class EqualsComparator implements Comparator {

		public int compare(Object arg0, Object arg1) {
			int result = 0;
			if (arg0 == null && arg1 == null) result = 0;
			if (arg0 == null || arg1 == null) result = 1;
			if (arg0.equals(arg1)) result = 0;
			else result = arg0.toString().compareTo(arg1.toString());
			return result;
		}
		
	}*/
	
	//TODO: Add guards to helpers
	//DONE: Go for context-less helpers
	public EolOperation(){
		
	}
	
	public EolOperation(AST ast){
		parse(ast);
	}
	
	public void parse(AST ast){
		
		AST nameAst = null;
		if (ast.getFirstChild().getType() == EolParser.TYPE) {
			contextTypeAst = ast.getFirstChild();
			nameAst = contextTypeAst.getNextSibling(); 
		}
		else {
			nameAst = ast.getFirstChild();
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
		
		this.ast = ast;
		this.body = bodyAst;
		//this.contextTypeName = contextTypeAst.getText();
		this.name = nameAst.getText();
		this.returnTypeAst = returnAst;
		//if (returnAst != null) this.returnTypeName = returnAst.getText();
		formalParameters = new EolFormalParameterList(paramListAst);
		
	}
	
	@Override
	public AST getAst() {
		return ast;
	}

	@Override
	public void setAst(AST ast) {
		this.ast = ast;
	}

	public AST getBody() {
		return body;
	}
	
	//public String getReturnTypeName() {
	//	return returnTypeName;
	//}

	//public void setReturnTypeName(String returnTypeName) {
	//	this.returnTypeName = returnTypeName;
	//}

	public void setBody(AST body) {
		this.body = body;
	}
	
	//public String getContextTypeName() {
	//	return contextTypeName;
	//}
	
	//public void setContextTypeName(String contextTypeName) {
	//	this.contextTypeName = contextTypeName;
	//}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public EolFormalParameterList getFormalParameters() {
		return formalParameters;
	}
	
	@Override
	public String toString(){
		String contextTypeName = "";
		String returnTypeName = "";

		if (contextTypeAst != null) {
			contextTypeName = " - " + contextTypeAst.getText();// + ".";
		}
		if (returnTypeAst != null) {
			returnTypeName = " : " + returnTypeAst.getText();
		}
		
		return name + "(" + formalParameters + ")" + returnTypeName + contextTypeName;
	}

	public void setFormalParameters(EolFormalParameterList formalParameters) {
		this.formalParameters = formalParameters;
	}

	public synchronized boolean isCached() {
		if (EolAnnotationsUtil.hasAnnotation(ast, "cached") && this.formalParameters.isEmpty()) {
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
	
	/*
	public Object execute(Object self, List parameterValues, IEolContext contect, Collection<Variable> variables) {
		
		// Adds the given extra variables to the framestack before executing
		// the operation and removes them straight afterwards...
		return null;
		
		//static x : Boolean; or
		// @static
		// var x : Integer;
		// Static variables are attached to the AST that is currently
		// executed (owner of the frame) and are created only the first
		// time...
	}
	*/
	
	public Object execute(Object self, List parameterValues, IEolContext context, boolean inNewStackFrame) throws EolRuntimeException{
		
		if (isCached() && cache.containsKey(self)) {
			return cache.get(self);
		}
		
		FrameStack scope = context.getFrameStack();
		
		if (inNewStackFrame) {
			scope.enterLocal(FrameType.PROTECTED, this.getAst());
			scope.put(Variable.createReadOnlyVariable("self",self));
		}
		
		for (int i=0;i<formalParameters.size();i++){
			EolFormalParameter fp = (EolFormalParameter) formalParameters.get(i);
			scope.put(new Variable(fp.getName(),parameterValues.get(i), fp.getType(context)));
		}
		
		evaluatePreConditions(context);
		
		Object result = null;
		
		//try {
			result = Return.getValue(executeBody(context));
			//context.getExecutorFactory().executeAST(this.getBody(), context);
		//}
		//catch (EolReturnException rex){
		//	result = rex.getReturned();
		//}

		checkResultType(result, context);
		evaluatePostConditions(context, result);
		
		if (inNewStackFrame) {
			scope.leaveLocal(this.getAst());
		}
		
		/*
		if (this.getReturnType().length() > 0 &&
			!EolTypeChecker.isOfType(result, this.getReturnType(), context)){
		}
		*/
		
		if (isCached() && !cache.containsKey(self)) {
			cache.put(self, result);
		}
		
		return result;
	}

	protected Object executeBody(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().executeAST(this.getBody(), context);
	}
	
	protected void evaluatePreConditions(IEolContext context) throws EolRuntimeException {
		for (IEolAnnotation annotation : EolAnnotationsUtil.getAnnotations(ast, "pre")) {
			Object satisfied = annotation.getValue(context);
			if (satisfied instanceof Boolean) {
				if (!((Boolean) satisfied).booleanValue()) {
					throw new EolRuntimeException("Pre-condition not satisfied", annotation.getAst());
				}
			}
			else {
				throw new EolIllegalReturnException("Boolean", satisfied, annotation.getAst(), context);
			}
		}
	}
	
	protected void checkResultType(Object result, IEolContext context)
			throws EolRuntimeException {
		if (returnTypeAst != null && result != null) {
			if (returnType == null) {
				returnType = (EolType) context.getExecutorFactory().executeAST(returnTypeAst, context);
			}
			if (!returnType.isKind(result)) {
				throw new EolRuntimeException(name + " is expected to return a " + returnType.getName() + ", but returned a " + result.getClass().getCanonicalName());
			}
		}
	}

	protected void evaluatePostConditions(IEolContext context, Object result) throws EolRuntimeException {
		context.getFrameStack().put(Variable.createReadOnlyVariable("_result", result));
		for (IEolAnnotation annotation : EolAnnotationsUtil.getAnnotations(ast, "post")) {
			Object satisfied = annotation.getValue(context);
			if (satisfied instanceof Boolean) {
				if (!((Boolean) satisfied).booleanValue()) {
					throw new EolRuntimeException("Post-condition not satisfied", annotation.getAst());
				}
			}
			else {
				throw new EolIllegalReturnException("Boolean", satisfied, annotation.getAst(), context);
			}
		}
	}
	
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public EolType getReturnType(IEolContext context) throws EolRuntimeException{
		if (returnType == null){
			if (returnTypeAst != null){
				returnType = (EolType) context.getExecutorFactory().executeAST(returnTypeAst,context);
			}
			else {
				returnType = EolAnyType.Instance;
			}
		}
		return returnType;
	}
	
	public EolType getContextType(IEolContext context) throws EolRuntimeException{
		if (contextType == null){
			if (contextTypeAst != null){
				contextType = (EolType) context.getExecutorFactory().executeAST(contextTypeAst,context);
			}
			else {
				contextType = EolNoType.Instance;
			}
		}
		return contextType;
	}
}

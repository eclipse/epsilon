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
package org.eclipse.epsilon.etl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.erl.rules.ExtensibleNamedRule;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.parse.EtlParser;
import org.eclipse.epsilon.etl.trace.TransformationTrace;
import org.eclipse.epsilon.etl.trace.Transformations;


public class TransformRule extends ExtensibleNamedRule implements ModuleElement{
	
	protected EolFormalParameter sourceParameter;
	protected List<EolFormalParameter> targetParameters = new ArrayList<EolFormalParameter>();
	protected AST guardAst = null;
	protected AST bodyAst = null;
	protected IEtlContext context;
	
	//protected boolean auto = false;
	
	public TransformRule(AST ast){
		parse(ast);
	}
	
	@Override
	public AST getSuperRulesAst() {
		return AstUtil.getChild(ast, EtlParser.EXTENDS);
	}
	
	public List<EolFormalParameter> getTargetParameters() {
		return targetParameters;
	}
	
	@Override
	public void parse(AST ast) {
		
		super.parse(ast);
		
		this.guardAst = AstUtil.getChild(ast, EtlParser.GUARD);
		this.bodyAst = AstUtil.getChild(ast, EtlParser.BLOCK);		
		
		//Parse the formal parameters
		AST sourceParameterAst = ast.getFirstChild().getNextSibling();
		sourceParameter = new EolFormalParameter(sourceParameterAst);
		
		AST targetParametersAst = sourceParameterAst.getNextSibling();
		AST targetParameterAst = targetParametersAst.getFirstChild();
		while (targetParameterAst != null){
			EolFormalParameter targetParameter = new EolFormalParameter(targetParameterAst);
			targetParameters.add(targetParameter);
			targetParameterAst = targetParameterAst.getNextSibling();
		}
		
	}
	
	public boolean hasTransformed(Object source) {
		return transformedElements.contains(source);
	}
	
	public Collection<?> getAllOfSourceType(IEtlContext context) throws EolRuntimeException{
		try {
			EolModelElementType sourceType = (EolModelElementType) sourceParameter.getType(context);
			return sourceType.getAllOfType();
		}
		catch (EolRuntimeException ex){
			ex.setAst(sourceParameter.getTypeAst());
			throw ex;
		}
	}
	
	protected EolModelElementType sourceType = null;
	
	public EolModelElementType getSourceType(IEolContext context) throws EolRuntimeException {
		if (sourceType == null) {
			sourceType = (EolModelElementType) sourceParameter.getType(context);
		}
		return sourceType;
	}
	
	/*
	public Collection getAllOfSourceKind(IEtlContext context) throws EolRuntimeException{		
		try {
			EolModelElementType sourceType = (EolModelElementType) sourceParameter.getType(context);
			return sourceType.getAllOfKind();
		}
		catch (EolRuntimeException ex){
			ex.setAst(sourceParameter.getTypeAst());
			throw ex;
		}
	}*/
	
	protected Collection<Object> rejected = new ArrayList<Object>();
	
	public boolean appliesTo(Object source, IEtlContext context, boolean asSuperRule) throws EolRuntimeException {
		return appliesTo(source, context, asSuperRule, true);
	}
	
	//TODO: Add support for rejected objects to other languages as well!
	public boolean appliesTo(Object source, IEtlContext context, boolean asSuperRule, boolean checkTypes) throws EolRuntimeException {
		
		if (hasTransformed(source)) return true;
		if (rejected.contains(source)) return false;
		
		boolean appliesToTypes;
		
		if (!checkTypes) {
			appliesToTypes = true;
		}
		else if (isGreedy() || asSuperRule) {
			appliesToTypes = getSourceType(context).isKind(source);
		}
		else {
			appliesToTypes = getSourceType(context).isType(source);
		}
		
		boolean guardSatisfied = true;
		
		if (appliesToTypes && guardAst != null){
			
			context.getFrameStack().enterLocal(FrameType.PROTECTED, guardAst);
			context.getFrameStack().put(Variable.createReadOnlyVariable(sourceParameter.getName(), source));
			context.getFrameStack().put(Variable.createReadOnlyVariable("self", this));
			
			// Control guard execution
			// context.getExecutorFactory().getExecutionController().control(guardAst, context);
			
			Object result = context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(), context);
			context.getFrameStack().leaveLocal(guardAst);
			
			if (result instanceof Return) {
				Object value = Return.getValue(result);
				if (value instanceof Boolean){
					guardSatisfied = ((Boolean) value).booleanValue();
				}
				else {
					throw new EolIllegalReturnException("Boolean", value, guardAst, context);
				}	
			}
			else {
				throw new EolNoReturnException("Boolean", guardAst, context);
			}
			
		}
		
		boolean applies = appliesToTypes && guardSatisfied;
		
		for (INamedRule superRule : getSuperRules()) {
			TransformRule rule = (TransformRule) superRule;
			if (!rule.appliesTo(source, context, true)) { applies = false; break; }
		}
		
		if (!applies) {rejected.add(source);}
		
		return applies;
	}
	
	public boolean contains(Collection<Object> col, Object o){
		Iterator<Object> it = col.iterator();
		while (it.hasNext()){
			if (it.next() == o) return true;
		}
		return false;
	}
	
	public void transformAll(IEtlContext context, List<Object> excluded) throws EolRuntimeException{
		
		Collection<?> all = null;
		if (isGreedy()) all = getSourceType(context).getAllOfKind();
		else all = getSourceType(context).getAllOfType();
		
		for (Object instance : all) {
			if (!excluded.contains(instance) && appliesTo(instance, context, false)){
				transform(instance, context);
			}
		}
		
	}
	
	public Collection<?> transform(Object source, Collection<?> targets, IEtlContext context) throws EolRuntimeException {
		transformedElements.add(source);
		executeSuperRulesAndBody(source, targets, context);
		return targets;
	}
	
	protected Set<Object> transformedElements = new HashSet<Object>();
	
	public Collection<?> transform(Object source, IEtlContext context) throws EolRuntimeException{
		
		TransformationTrace transformationTrace = context.getTransformationTrace();
		
		if (hasTransformed(source)) {
			Transformations transformations = transformationTrace.getTransformations(source);
			return transformations.getTargets(this.name);
		}
		else {
			transformedElements.add(source);
		}
		
		//Control execution
		//context.getExecutorFactory().getExecutionController().control(ast, context);
		
		Collection<Object> targets = CollectionUtil.createDefaultList();
		
		for (EolFormalParameter targetParameter : targetParameters) {
			EolType targetParameterType = (EolType) targetParameter.getType(context);
			targets.add(targetParameterType.createInstance());
		}
		
		transformationTrace.add(source, targets, this);
		
		//Profiler.INSTANCE.start(this.getName());
		executeSuperRulesAndBody(source, targets, context);
		//Profiler.INSTANCE.stop();
		
		return targets;
	}
	
	protected void executeSuperRulesAndBody(Object source, Collection<?> targets_, IEtlContext context) throws EolRuntimeException{
		
		// Control guard execution
		// context.getExecutorFactory().getExecutionController().control(ast, context);
		
		List<?> targets = CollectionUtil.asList(targets_);
		
		// Execute super-rules
		
		Iterator<INamedRule> it = superRules.iterator();
		while (it.hasNext()){
			TransformRule superRule = (TransformRule) it.next();
			superRule.transform(source, targets, context);
		}
		
		FrameStack scope = context.getFrameStack();
		Variable[] variables = {};
		scope.enterLocal(FrameType.PROTECTED, ast, variables);
		
		scope.put(Variable.createReadOnlyVariable(sourceParameter.getName(), source));
		scope.put(Variable.createReadOnlyVariable("self", this));
		
		for (int i=0; i<targetParameters.size(); i++){
			EolFormalParameter targetParameter = (EolFormalParameter) targetParameters.get(i);
			scope.put(Variable.createReadOnlyVariable(targetParameter.getName(), targets.get(i)));
		}
		
		context.getExecutorFactory().executeAST(bodyAst, context);
		
		scope.leaveLocal(ast);
		
	}
	
	public List<?> getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public String toString(){
		
		String targetTypes = "";
		Iterator<EolFormalParameter> it = targetParameters.iterator();
		while (it.hasNext()){
			EolFormalParameter fp = it.next();
			targetTypes += fp.getTypeName();
			if (it.hasNext()){
				targetTypes += ", ";
			}
		}
		
		return this.name + " (" + sourceParameter.getTypeName() + ") : " + targetTypes;
	}
	
	protected Boolean isPrimary = null;
	
	public boolean isPrimary() throws EolRuntimeException {
		if (isPrimary == null) {
			isPrimary = EolAnnotationsUtil.getBooleanAnnotationValue(ast, "primary", null);
		}
		return isPrimary;
	}
	
	public boolean canTransformExcluded(IEtlContext context) throws EolRuntimeException {
		return EolAnnotationsUtil.getBooleanAnnotationValue(ast, "excluded", context, false, true);
	}	
	
	public void dispose() {
		transformedElements.clear();
		rejected.clear();
		rejected = null;
		transformedElements = null;
	}
	
}

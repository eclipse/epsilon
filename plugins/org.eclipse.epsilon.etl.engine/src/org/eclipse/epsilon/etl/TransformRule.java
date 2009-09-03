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

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.erl.rules.ExtensibleNamedRule;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.parse.EtlParser;
import org.eclipse.epsilon.etl.trace.TransformationTrace;
import org.eclipse.epsilon.etl.trace.Transformations;


public class TransformRule extends ExtensibleNamedRule implements ModuleElement{
	
	protected EolFormalParameter sourceParameter;
	protected List<EolFormalParameter> targetParameters = new ArrayList();
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
	
	public Collection getAllOfSourceType(IEtlContext context) throws EolRuntimeException{
		try {
			EolModelElementType sourceType = (EolModelElementType) sourceParameter.getType(context);
			return sourceType.getAllOfType();
		}
		catch (EolRuntimeException ex){
			ex.setAst(sourceParameter.getTypeAst());
			throw ex;
		}
	}
	
	public Collection getAllOfSourceKind(IEtlContext context) throws EolRuntimeException{		
		try {
			EolModelElementType sourceType = (EolModelElementType) sourceParameter.getType(context);
			return sourceType.getAllOfKind();
		}
		catch (EolRuntimeException ex){
			ex.setAst(sourceParameter.getTypeAst());
			throw ex;
		}
	}
	
	protected Collection rejected = new ArrayList<Object>();
	
	public boolean appliesTo(Object source, IEtlContext context, boolean asSuperRule) throws EolRuntimeException {
		return appliesTo(source, context, asSuperRule, true);
	}
	
	//TODO: Add support for rejected objects to other languages as well!
	public boolean appliesTo(Object source, IEtlContext context, boolean asSuperRule, boolean checkTypes) throws EolRuntimeException {
		
		if (hasTransformed(source)) return true;
		if (rejected.contains(source)) return false;
		
		//IModel model = context.getModelRepository().getOwningModel(source);
		//if (model == null) return false;
		
		boolean appliesToTypes;
		
		if (!checkTypes) {
			appliesToTypes = true;
		}
		else if (isGreedy() || asSuperRule) {
			appliesToTypes = getAllOfSourceKind(context).contains(source);
		}
		else {
			appliesToTypes = getAllOfSourceType(context).contains(source);
		}
		
		boolean guardSatisfied = true;
		
		if (appliesToTypes && guardAst != null){
			
			context.getFrameStack().enter(FrameType.PROTECTED, guardAst);
			context.getFrameStack().put(Variable.createReadOnlyVariable(sourceParameter.getName(), source));
			context.getFrameStack().put(Variable.createReadOnlyVariable("self", this));
			
			try {
				context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(), context);
				context.getFrameStack().leave(guardAst);
				throw new EolNoReturnException("Boolean", guardAst, context);
			}
			catch (EolReturnException rex){
				context.getFrameStack().leave(guardAst);
				if (rex.getReturned() instanceof EolBoolean){
					guardSatisfied = ((EolBoolean) rex.getReturned()).booleanValue();
				}
				else {
					throw new EolIllegalReturnException("Boolean", rex.getReturned(), guardAst, context);
				}
			}
			
		}
		
		boolean applies = appliesToTypes && guardSatisfied;
		
		for (INamedRule superRule : getSuperRules()) {
			TransformRule rule = (TransformRule) superRule;
			if (!rule.appliesTo(source, context, true)) { applies = false; break; }
		}
		
		if (!applies) {rejected.add(source);}
		
		return applies;
		//return appliesToTypes && guardSatisfied;
	}
	
	/*
	public boolean isStandalone(EtlContext context) throws EolModelNotFoundException{
		
		if (this.isAuto()) return true;
		
		boolean concreteTargets = true;
		
		ListIterator li = targetParameters.listIterator();
		while (li.hasNext()){
			EolFormalParameter parameter = (EolFormalParameter) li.next();
			if (context.getModelRepository().existsMetaClass(parameter.getType())){
				concreteTargets = concreteTargets && 
					context.getModelRepository().isInstanciable(parameter.getType());
			}
		}
		
		if (concreteTargets) 
			return true;
		else
			return false;
	}
	*/
	
	//public boolean isAuto(){
	//	return auto;
	//}
	
	public boolean contains(Collection col, Object o){
		Iterator it = col.iterator();
		while (it.hasNext()){
			if (it.next() == o) return true;
		}
		return false;
	}
	
	public void transformAll(IEtlContext context, List<Object> excluded) throws EolRuntimeException{
		//System.err.println("Transforming all..." + this.name);
		Iterator it = getAllOfSourceKind(context).iterator();
		while (it.hasNext()){
			Object instance = it.next();
			if (!excluded.contains(instance) && appliesTo(instance, context, false)){
				//System.err.println("Applies...");
				transform(instance, context);
			}
			//else if (appliesTo(instance, context, false)){
			//	transform(instance, context);
			//}
		}
	}
	
	/*
	public void transformAll(Scope scope) throws XolRuntimeException {
			
		Collection leftInstances = scope.getModelRepository().allOfType(leftFormalParameter.getType());
		Collection rightInstances = scope.getModelRepository().allOfType(rightFormalParameter.getType());
		
		Iterator leftIterator = leftInstances.iterator();
		
		while (leftIterator.hasNext()){
			Object leftInstance = leftIterator.next();
			Iterator rightIterator = rightInstances.iterator();
			while (rightIterator.hasNext()){
				Object rightInstance = rightIterator.next();
				merge(leftInstance, rightInstance, scope);
			}
		}
	}
	*/
	
	public EolCollection transform(Object source, EolCollection targets, IEtlContext context) throws EolRuntimeException {
		executeSuperRulesAndBody(source, targets, context);
		return targets;
	}
	
	protected Set<Object> transformedElements = new HashSet<Object>();
	
	public EolCollection transform(Object source, IEtlContext context) throws EolRuntimeException{
		
		TransformationTrace transformationTrace = context.getTransformationTrace();
		
		if (hasTransformed(source)) {
			Transformations transformations = transformationTrace.getTransformations(source);
			return transformations.getTargets(this.name);
		}
		else {
			transformedElements.add(source);
		}
		
		EolCollection targets = new EolBag();
		
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
	
	protected void executeSuperRulesAndBody(Object source, EolCollection targets_, IEtlContext context) throws EolRuntimeException{
		
		EolSequence targets = targets_.asSequence();
		
		// Execute super-rules
		
		Iterator it = superRules.iterator();
		while (it.hasNext()){
			TransformRule superRule = (TransformRule) it.next();
			superRule.transform(source, targets, context);
		}
		
		FrameStack scope = context.getFrameStack();
		scope.enter(FrameType.PROTECTED, ast);
		
		scope.put(Variable.createReadOnlyVariable(sourceParameter.getName(), source));
		scope.put(Variable.createReadOnlyVariable("self", this));
		
		for (int i=0; i<targetParameters.size(); i++){
			EolFormalParameter targetParameter = (EolFormalParameter) targetParameters.get(i);
			scope.put(Variable.createReadOnlyVariable(targetParameter.getName(), targets.at(new EolInteger(i))));
		}
		
		context.getExecutorFactory().executeAST(bodyAst, context);
		
		scope.leave(ast);
		
	}
	
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public String toString(){
		
		String targetTypes = "";
		Iterator it = targetParameters.iterator();
		while (it.hasNext()){
			EolFormalParameter fp  = (EolFormalParameter) it.next();
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

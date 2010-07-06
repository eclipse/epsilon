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
package org.eclipse.epsilon.eml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.commons.util.CollectionUtil;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eml.execute.context.IEmlContext;
import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.eml.trace.MergeTrace;
import org.eclipse.epsilon.eml.trace.Merges;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.erl.rules.ExtensibleNamedRule;


public class MergeRule extends ExtensibleNamedRule implements ModuleElement{
	
	protected AST guardAst = null;
	protected AST bodyAst = null;
	protected AST superRulesAst = null;
	protected EolFormalParameter leftParameter;
	protected EolFormalParameter rightParameter;
	protected List<EolFormalParameter> targetParameters = new ArrayList<EolFormalParameter>();
	
	protected Collection allOfLeftType = null;
	protected Collection allOfRightType = null;
	protected Collection allOfLeftKind = null;
	protected Collection allOfRightKind = null;
	
	protected boolean auto = false;
	
	public MergeRule(AST ast){
		parse(ast);
	}
	
	@Override
	public void parse(AST ast) {
		
		super.parse(ast);
		
		this.guardAst = AstUtil.getChild(ast, EmlParser.GUARD);
		this.bodyAst = AstUtil.getChild(ast, EmlParser.BLOCK);
		
		//Parse the formal parameters
		AST leftParameterAst = ast.getFirstChild().getNextSibling();
		leftParameter = new EolFormalParameter(leftParameterAst);
		
		AST rightParameterAst = leftParameterAst.getNextSibling();
		rightParameter = new EolFormalParameter(rightParameterAst);
		
		AST mergedParametersAst = rightParameterAst.getNextSibling();
		AST mergedParameterAst = mergedParametersAst.getFirstChild();
		while (mergedParameterAst != null){
			EolFormalParameter mergedParameter = new EolFormalParameter(mergedParameterAst);
			targetParameters.add(mergedParameter);
			mergedParameterAst = mergedParameterAst.getNextSibling();
		}
		
	}
	
	public boolean isLazy(IEmlContext context) throws EolRuntimeException {
		return EolAnnotationsUtil.getBooleanAnnotationValue(ast, "lazy", context);
	}
	
	public boolean isPrimary(IEmlContext context) throws EolRuntimeException {
		return EolAnnotationsUtil.getBooleanAnnotationValue(ast, "primary", context);
	}
	
	public boolean appliesTo(Match match, IEmlContext context) throws EolRuntimeException{
		
		if (hasMerged(match)) return true;
		
		Object left = match.getLeft();
		Object right = match.getRight();
		
		//boolean appliesToTypes = getAllOfLeftKind(context).contains(left) && 
		//	getAllOfRightKind(context).contains(right);
		
		boolean appliesToTypes;
		
		if (!isGreedy()) {
			appliesToTypes = getAllOfLeftType(context).contains(left) && getAllOfRightType(context).contains(right);
		}
		else {
			appliesToTypes = getAllOfLeftKind(context).contains(left) && getAllOfRightKind(context).contains(right);	
		}
	
		boolean guardSatisfied = true;
		
		if (appliesToTypes && guardAst != null){
			
			context.getFrameStack().put(new Variable(leftParameter.getName(), left, leftParameter.getType(context), true));
			context.getFrameStack().put(new Variable(rightParameter.getName(), right, rightParameter.getType(context), true));
			context.getFrameStack().put(new Variable("self", this, EolAnyType.Instance, true));
			
			Object result = context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(), context);
			
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
		
		
		return appliesToTypes && guardSatisfied;
	}
	
	public Collection getAllOfRightType(IEmlContext context) throws EolRuntimeException {
		if (allOfRightType == null){
			try {
				EolModelElementType rightType = (EolModelElementType) rightParameter.getType(context);
				allOfRightType = rightType.getAllOfType();
				//rightInstances = (EolModel) rightParameter.getType(context).//context.getModelRepository().allOfClass(rightParameter.getType(),);
			}
			catch (EolModelElementTypeNotFoundException ex){
				ex.setAst(rightParameter.getTypeAst());
				throw ex;
			}
			catch (EolModelNotFoundException ex){
				ex.setAst(rightParameter.getTypeAst());
				throw ex;
			}
		}
		return allOfRightType;
	}
	
	public Collection getAllOfLeftType(IEmlContext context) throws EolRuntimeException {
		if (allOfLeftType == null){
			try {
				//leftInstances = context.getModelRepository().allOfClass(leftParameter.getType());
				EolModelElementType leftType = (EolModelElementType) leftParameter.getType(context);
				allOfLeftType = leftType.getAllOfType();
				
			}
			catch (EolModelElementTypeNotFoundException ex){
				ex.setAst(leftParameter.getTypeAst());
				throw ex;
			}
			catch (EolModelNotFoundException ex){
				ex.setAst(leftParameter.getTypeAst());
				throw ex;
			}
		}
		return allOfLeftType;
	}
	
	public Collection getAllOfRightKind(IEmlContext context) throws EolRuntimeException {
		if (allOfRightKind == null){
			try {
				EolModelElementType rightType = (EolModelElementType) rightParameter.getType(context);
				allOfRightKind = rightType.getAllOfKind();
				//rightInstances = (EolModel) rightParameter.getType(context).//context.getModelRepository().allOfClass(rightParameter.getType(),);
			}
			catch (EolModelElementTypeNotFoundException ex){
				ex.setAst(rightParameter.getTypeAst());
				throw ex;
			}
			catch (EolModelNotFoundException ex){
				ex.setAst(rightParameter.getTypeAst());
				throw ex;
			}
		}
		return allOfRightKind;
	}
	
	public Collection getAllOfLeftKind(IEmlContext context) throws EolRuntimeException {
		if (allOfLeftKind == null){
			try {
				//leftInstances = context.getModelRepository().allOfClass(leftParameter.getType());
				EolModelElementType leftType = (EolModelElementType) leftParameter.getType(context);
				allOfLeftKind = leftType.getAllOfKind();
				
			}
			catch (EolModelElementTypeNotFoundException ex){
				ex.setAst(leftParameter.getTypeAst());
				throw ex;
			}
			catch (EolModelNotFoundException ex){
				ex.setAst(leftParameter.getTypeAst());
				throw ex;
			}
		}
		return allOfLeftKind;
	}
	
	
	/*
	public void mergeAll(Scope scope) throws XolRuntimeException {
			
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
	
	public Collection merge(Match match, Collection targets, IEmlContext context) throws EolRuntimeException{
		
		MergeTrace mergeTrace =(context).getMergeTrace();
		Merges merges = mergeTrace.getMerges(match, this);
		
		if (!merges.isEmpty()) return merges.getTargets();
		
		/*
		if (auto == true){
			(context).getMergingStrategy().autoMerge(left, right, targets.asSequence().first(), context);
		}
		*/
		
		executeSuperRulesAndBody(match,targets,context);
		
		return targets;
	}

	
	public boolean hasMerged(Match match) {
		return mergedMatches.contains(match);
	}
	
	HashSet<Match> mergedMatches = new HashSet<Match>();
	
	public Collection merge(Match match, IEmlContext context) throws EolRuntimeException{
		
		MergeTrace mergeTrace =(context).getMergeTrace();
		
		if (hasMerged(match)) {
			return mergeTrace.getMerges(match, this).getTargets();
		}
		else {
			mergedMatches.add(match);
		}

		Object left = match.getLeft();
		Object right = match.getRight();
		
		Collection targets = CollectionUtil.createDefaultList();

		ListIterator li = targetParameters.listIterator();
		
		/*
		if (auto == true){
			li.next();
			Object autoMerged = (context).getMergingStrategy().autoMerge(left, right, context);
			targets.add(autoMerged);
		}
		*/
		
		while (li.hasNext()){
			EolFormalParameter targetParameter = (EolFormalParameter) li.next();
			EolType targetParameterType = (EolType) targetParameter.getType(context);
			targets.add(targetParameterType.createInstance());
			//targets.add(context.getModelRepository().
			//		createInstance(targetParameter.getType(context)));
		}

		mergeTrace.add(match,targets,this);
	
		executeSuperRulesAndBody(match, targets, context);
		
		return targets;
	}
		
	@Override
	public String toString(){
		String str = name;
		str = str + " (";
		str = str + 
		//leftParameter.getName() + ":" + leftParameter.getTypeName() + ", " +
		//rightParameter.getName() + ":" + rightParameter.getTypeName();
		leftParameter.getTypeName() + ", " +
		rightParameter.getTypeName();
		str = str + ") : ";
		ListIterator li = targetParameters.listIterator();
		while (li.hasNext()){
			EolFormalParameter targetParameter = (EolFormalParameter) li.next();
			//str += targetParameter.getName() + ":" + targetParameter.getTypeName();
			str += targetParameter.getTypeName();
			if (li.hasNext()){
				str += ", ";
			}
		}
		return str;
	}
	
	public void executeSuperRulesAndBody(Match match, Collection targets, IEmlContext context) throws EolRuntimeException{
		
		// Execute the super rules
		Iterator it = superRules.iterator();
		while (it.hasNext()){
			MergeRule superRule = (MergeRule) it.next();
			superRule.merge(match, targets, context);
		}
		
		FrameStack scope = context.getFrameStack();
		
		scope.enter(FrameType.PROTECTED, ast);
		
		scope.put(new Variable(leftParameter.getName(), match.getLeft(), leftParameter.getType(context), true));
		scope.put(new Variable(rightParameter.getName(), match.getRight(), rightParameter.getType(context), true));
		
		scope.put(Variable.createReadOnlyVariable("self",this));
		
		for (int i=0; i<targetParameters.size(); i++){
			EolFormalParameter targetParameter = (EolFormalParameter) targetParameters.get(i);
			scope.put(new Variable(targetParameter.getName(), CollectionUtil.asList(targets).get(i),targetParameter.getType(context),true));
		}
		context.getExecutorFactory().executeAST(bodyAst, context);
		
		scope.leave(ast);
		
	}

	@Override
	public AST getSuperRulesAst() {
		return AstUtil.getChild(ast, EmlParser.EXTENDS);
	}

	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
}

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
package org.eclipse.epsilon.ecl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.ecl.exceptions.EclNotApplicableSuperRuleException;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.erl.rules.ExtensibleNamedRule;


public class MatchRule extends ExtensibleNamedRule implements ModuleElement{
	
	protected AST compareAst;
	protected AST doAst;
	
	protected EolFormalParameter leftParameter;
	protected EolFormalParameter rightParameter;
	protected Collection leftInstances;
	protected Collection rightInstances;
	protected Collection allOfLeftType;
	protected Collection allOfRightType;
	
	protected ArrayList allSuperRules = null;
	
	protected AST guardAst = null;
	protected AST bodyAst = null;
	protected AST superRulesAst = null;
	
	public MatchRule(AST ast){
		parse(ast);
	}

	@Override
	public AST getSuperRulesAst() {
		return AstUtil.getChild(ast, EclParser.EXTENDS);
	}
	
	@Override
	public void parse(AST ast) {
		
		super.parse(ast);
		
		this.guardAst = AstUtil.getChild(ast, EclParser.GUARD);
		this.bodyAst = AstUtil.getChild(ast, EclParser.BLOCK);		
		
		AST leftParameterAst = ast.getFirstChild().getNextSibling();
		leftParameter = new EolFormalParameter(leftParameterAst);
		
		AST rightParameterAst = leftParameterAst.getNextSibling();
		rightParameter = new EolFormalParameter(rightParameterAst);
		
		this.compareAst = AstUtil.getChild(ast, EclParser.COMPARE);
		this.doAst = AstUtil.getChild(ast, EclParser.DO);
		
	}
	
	public boolean appliesTo(Object left, Object right, IEclContext context, boolean ofTypeOnly) throws EolRuntimeException{
		
		boolean appliesToTypes = false;
		
		if (!ofTypeOnly || isGreedy()){
			appliesToTypes = getAllOfLeftKind(context).contains(left) && getAllOfRightKind(context).contains(right);
		}
		else {
			appliesToTypes = getAllOfLeftType(context).contains(left) && getAllOfRightType(context).contains(right);
		}
		
		boolean guardSatisfied = true;
		
		if (!isAbstract() && appliesToTypes && guardAst != null){
			context.getFrameStack().put(Variable.createReadOnlyVariable(leftParameter.getName(), left));
			context.getFrameStack().put(Variable.createReadOnlyVariable(rightParameter.getName(), right));
			context.getFrameStack().put(Variable.createReadOnlyVariable("self", this));
			
			Object result = context.getExecutorFactory().executeBlockOrExpressionAst(guardAst.getFirstChild(), context);
			
			if (result instanceof Return) {
				Object value = ((Return) result).getValue();
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

	/*
	public boolean isUnique() {
		return EolAnnotationsUtil.hasAnnotation(ast, "unique");
	}
	*/
	
	/*
	public void executeOnEnterActions(IEclContext context) throws EolRuntimeException {
		for (Object o : EolAnnotationsUtil.getAnnotationsValues(ast, "onEnter", context)) {
			context.getOutputStream().println("On enter " + this.getName() + " : " + context.getPrettyPrinterManager().toString(o));
		}
	}
	*/
	
	public Collection getAllOfRightType(IEclContext context) throws EolRuntimeException {
		if (rightInstances == null){
			try {
				EolModelElementType rightType = (EolModelElementType) rightParameter.getType(context);
				rightInstances = rightType.getAllOfType();
				//rightInstances = context.getModelRepository().allOfClass(rightParameter.getType());
			}
			catch (EolRuntimeException ex){
				ex.setAst(rightParameter.getTypeAst());
				throw ex;
			}
		}
		return rightInstances;
	}
	
	public Collection getAllOfLeftType(IEclContext context) throws EolRuntimeException {
		if (leftInstances == null){
			try {
				EolModelElementType leftType = (EolModelElementType) leftParameter.getType(context);
				leftInstances = leftType.getAllOfType();
				
				//leftInstances = context.getModelRepository().allOfClass(leftParameter.getType());
			}
			catch (EolRuntimeException ex){
				ex.setAst(leftParameter.getTypeAst());
				throw ex;
			}
		}
		return leftInstances;
	}
	
	public Collection getAllOfRightKind(IEclContext context) throws EolRuntimeException {
		if (allOfRightType == null){
			try {
				EolModelElementType rightType = (EolModelElementType) rightParameter.getType(context);
				allOfRightType = rightType.getAllOfKind();
			}
			catch (EolRuntimeException ex){
				ex.setAst(rightParameter.getTypeAst());
				throw ex;
			}
		}
		return allOfRightType;
	}
	
	public Collection getAllOfLeftKind(IEclContext context) throws EolRuntimeException {
		if (allOfLeftType == null){
			try {
				EolModelElementType leftType = (EolModelElementType) leftParameter.getType(context);
				allOfLeftType = leftType.getAllOfKind();
			}
			catch (EolRuntimeException ex){
				ex.setAst(leftParameter.getTypeAst());
				throw ex;
			}
		}
		return allOfLeftType;
	}
	
	public void matchAll(IEclContext context, boolean ofTypeOnly) throws EolRuntimeException {
		Iterator leftIterator = ofTypeOnly ? getAllOfLeftType(context).iterator() 
			: getAllOfLeftKind(context).iterator();
		
		while (leftIterator.hasNext()){
			Object leftInstance = leftIterator.next();
			Iterator rightIterator = ofTypeOnly ? getAllOfRightType(context).iterator() 
					: getAllOfRightKind(context).iterator();
			while (rightIterator.hasNext()){
				Object rightInstance = rightIterator.next();
				
				if (!ofTypeOnly && context.getMatchTrace().getMatch(leftInstance, rightInstance) != null) {
					continue;
				}
				
				// Try to find a rule with ofTypeOnly = true
				if (appliesTo(leftInstance, rightInstance, context, true)){
					match(leftInstance, rightInstance, context, false, null, false);
				}
				// Else find a rule with onlyOfClass = false
				else if (appliesTo(leftInstance, rightInstance, context, false)){
					match(leftInstance, rightInstance, context, false, null, false);
				}
			}
		}
	}
	
	/**
	 * Matches left against right
	 * @param left The left object
	 * @param right The right object
	 * @param context The context in which the EML program is running
	 * @param asSuperRule Shows if the rule is executed as a super-rule of another rule
	 * @return
	 * @throws EolRuntimeException
	 */
	public Match match(Object left, Object right, IEclContext context, boolean asSuperRule, EolMap matchInfo, boolean forcedMatch) throws EolRuntimeException{
		
		MatchTrace matchTrace = context.getMatchTrace();
		MatchTrace tempMatchTrace = context.getTempMatchTrace();
		Match match = null;
		Match tempMatch = null;
		
		/*
		if (isUnique()) {
			Match uniqueMatch = matchTrace.getMatch(left, this);
			if (uniqueMatch != null) { 
				if (uniqueMatch.getRight() == right) {
					return uniqueMatch;
				}
				else {
					return context.getMatchTrace().add(left, right, false, this);
				}
			}
		}
		*/
		
		if (!asSuperRule){
		
			// See if there is a match for left<->right in the temp match trace
			tempMatch = tempMatchTrace.getMatch(left, right);
			
			// If there is no match in the temp trace, create one
			// and add it to the temp trace
			// Else, return the temp match
			if (tempMatch == null){
				//tempMatch = new Match();
				//tempMatch.setLeft(left);
				//tempMatch.setRight(right);
				//tempMatch.setMatching(true);
				//tempMatch.setConforming(true);
				tempMatch = tempMatchTrace.createMatch(left, right, true);
				tempMatch.setRule(this);
				tempMatchTrace.getMatches().add(tempMatch);
			}
			else {
				return tempMatch;
			}
			
			// See if left<->right have been already matched
			match = matchTrace.getMatch(left, right); 
			if (match != null) {
				tempMatchTrace.getMatches().remove(tempMatch);
				return match;
			}
		}
		else {
			if (!appliesTo(left, right, context, false)) {
				throw new EclNotApplicableSuperRuleException(left, right, this, context);
			}
		}
		
		// If they have not been matched, construct their Match
		
		match = new Match();
		match.setLeft(left);
		match.setRight(right);
		match.setMatching(true);
		match.setRule(this);
		
		// Execute all the super-rules
		if (superRules.size() > 0){
			Iterator it = superRules.iterator();
			boolean matching = true;
			while (it.hasNext()){
				MatchRule matchRule = (MatchRule) it.next();
				Match superRuleMatch = matchRule.match(left, right, context, true, match.getInfo(), false);
				matching = matching && superRuleMatch.isMatching();
			}
			match.setMatching(matching);
			
			if (matching == false) {
				tempMatchTrace.getMatches().remove(tempMatch);
				matchTrace.getMatches().add(match);
				return match;
			}
			
		}

		FrameStack scope = context.getFrameStack();
		scope.enterLocal(FrameType.PROTECTED, ast);
		
		// Execute the compare part of the rule
		
		EolMap info = null;
		if (asSuperRule) {info = matchInfo;}
		else {info = match.getInfo();}
		
		scope.put(Variable.createReadOnlyVariable(leftParameter.getName(), left));
		scope.put(Variable.createReadOnlyVariable(rightParameter.getName(), right));
		scope.put(Variable.createReadOnlyVariable("matchInfo", info));
		
		// Add the rule itself to the context under the name 'self'
		context.getFrameStack().put(Variable.createReadOnlyVariable("self", this));
		
		//executeOnEnterActions(context);
		
		//boolean autoMatch = false;
		
		//if (auto == true){
		//	if (context.getMatchingStrategy().appliesTo(left,right,context)){
		//		autoMatch = context.getMatchingStrategy().autoMatch(left, right, context);
		//	}
		//	context.getFrameStack().put(Variable.createReadOnlyVariable("autoCompare", new EolBoolean(autoMatch)));
		//}
		
		if (compareAst != null) {
			Object result = context.getExecutorFactory().executeBlockOrExpressionAst(compareAst.getFirstChild(),context);
			
			if (result instanceof Return) {
				Object value = ((Return) result).getValue();
				if (value instanceof Boolean){
					boolean matching = ((Boolean) value).booleanValue();
					match.setMatching(matching);
				}
				else {
					throw new EolIllegalReturnException("Boolean", value, compareAst, context);
				}	
			}
			else {
				throw new EolNoReturnException("Boolean", compareAst, context);
			}
			
		}
		else {
			//if (auto == true){
			//	match.setMatching(autoMatch);
			//}
			//else 
			if (superRules.size() == 0) {
				match.setMatching(false);
			}
		}
		
		// Execute the do part of the rule
		
		if (doAst != null && match.isMatching()){
			context.getExecutorFactory().executeBlockOrExpressionAst(doAst.getFirstChild(), context);
		}
		
		
		if (!asSuperRule){
			// Before exiting remove the temp match
			// we created from the temp match trace
			tempMatchTrace.getMatches().remove(tempMatch);
			
			// If there are temp matches, it means
			// that the matching decision is based
			// upon rules that may not eventually hold
			// Therefore, in that case we should not
			// add a permanent match
			
			//TODO : See if this affects cyclic dependencies
			if (forcedMatch || tempMatchTrace.getMatches().size() == 0){
				matchTrace.getMatches().add(match);
			}
		}
		
		scope.leaveLocal(ast);
		
		return match;
	}
	
	/*
	@Override
	public boolean isAbstract(){
		EolAst eolAst = (EolAst) ast;
		if (eolAst.getProperties().get("abstract") != null){
			return true;
		}
		else {
			return false;
		}
	}
	 */
	
	@Override
	public boolean isLazy() throws EolRuntimeException {
		// TODO Auto-generated method stub
		return super.isLazy();
	}

	@Override
	public String toString(){
		String str = name;
		str = str + " (";
		str = str + 
		leftParameter.getTypeName() + ", " +
		rightParameter.getTypeName()
		;
		str = str + ")";
		return str;
	}

	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
}

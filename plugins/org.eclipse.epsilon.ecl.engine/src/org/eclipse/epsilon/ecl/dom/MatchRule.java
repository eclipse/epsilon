/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl.dom;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.ecl.exceptions.EclNotApplicableSuperRuleException;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.erl.dom.ExtensibleNamedRule;


public class MatchRule extends ExtensibleNamedRule {
	
	protected ExecutableBlock<Boolean> compareBlock;
	protected ExecutableBlock<Void> doBlock;
	protected ExecutableBlock<Boolean> guardBlock = null;
	
	protected Parameter leftParameter;
	protected Parameter rightParameter;

	public MatchRule(){}

	@Override
	public AST getSuperRulesAst(AST cst) {
		return AstUtil.getChild(cst, EclParser.EXTENDS);
	}
	

	@SuppressWarnings("unchecked")
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		leftParameter = (Parameter) module.createAst(cst.getSecondChild(), this);
		rightParameter = (Parameter) module.createAst(cst.getThirdChild(), this);
		
		this.compareBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EclParser.COMPARE), this);
		this.doBlock = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst, EclParser.DO), this);
		this.guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EclParser.GUARD), this);
	}
	
	public boolean appliesTo(Object left, Object right, IEclContext context, boolean ofTypeOnly) throws EolRuntimeException{

		boolean appliesToTypes = getAllInstances(leftParameter, context, !(!ofTypeOnly || isGreedy())).contains(left) &&
			getAllInstances(rightParameter, context, !(!ofTypeOnly || isGreedy())).contains(right);
		
		boolean guardSatisfied = true;
		
		if (!isAbstract() && appliesToTypes && guardBlock != null){
			
			guardSatisfied = guardBlock.execute(context, 
				Variable.createReadOnlyVariable(leftParameter.getName(), left),
				Variable.createReadOnlyVariable(rightParameter.getName(), right),
				Variable.createReadOnlyVariable("self", this));
		}
		
		return appliesToTypes && guardSatisfied;
	}
	
	public void matchAll(IEclContext context, boolean ofTypeOnly) throws EolRuntimeException {
		
		for (Object leftInstance : getAllInstances(leftParameter, context, ofTypeOnly)){
			for (Object rightInstance : getAllInstances(rightParameter, context, ofTypeOnly)){
				
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
	//TOOD: Variables defined in the guard should be accessible in the compare and do parts
	public Match match(Object left, Object right, IEclContext context, boolean asSuperRule, EolMap matchInfo, boolean forcedMatch) throws EolRuntimeException{
		MatchTrace matchTrace = context.getMatchTrace();
		MatchTrace tempMatchTrace = context.getTempMatchTrace();
		Match match = null;
		Match tempMatch = null;
		
		if (!asSuperRule){
		
			// See if there is a match for left<->right in the temp match trace
			tempMatch = tempMatchTrace.getMatch(left, right);
			
			// If there is no match in the temp trace, create one
			// and add it to the temp trace
			// Else, return the temp match
			if (tempMatch == null){
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
			boolean matching = true;
			for (ExtensibleNamedRule rule : superRules) {
				MatchRule matchRule = (MatchRule) rule;
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
		scope.enterLocal(FrameType.PROTECTED, this);
		
		// Execute the compare part of the rule
		
		EolMap info = null;
		if (asSuperRule) {info = matchInfo;}
		else {info = match.getInfo();}
		
		scope.put(Variable.createReadOnlyVariable(leftParameter.getName(), left));
		scope.put(Variable.createReadOnlyVariable(rightParameter.getName(), right));
		scope.put(Variable.createReadOnlyVariable("matchInfo", info));
		scope.put(Variable.createReadOnlyVariable("self", this));
		
		if (compareBlock != null) {
			match.setMatching(compareBlock.execute(context, false));
		}
		else {
			if (superRules.size() == 0) {
				match.setMatching(false);
			}
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
		
		// Execute the do part of the rule
		if (doBlock != null && match.isMatching()){
			doBlock.execute(context, false);
			//context.getExecutorFactory().executeBlockOrExpressionAst(doAst.getFirstChild(), context);
		}
		
		scope.leaveLocal(this);
		
		return match;
	}

	@Override
	public String toString(){
		String str = getName();
		str = str + " (";
		str = str + 
		leftParameter.getTypeName() + ", " +
		rightParameter.getTypeName()
		;
		str = str + ")";
		return str;
	}

	public List<ModuleElement> getModuleElements() {
		return Collections.emptyList();
	}
}

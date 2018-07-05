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
package org.eclipse.epsilon.ecl.dom;

import java.util.Collection;
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
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.erl.dom.ExtensibleNamedRule;

public class MatchRule extends ExtensibleNamedRule {
	
	protected ExecutableBlock<Boolean> compareBlock, guardBlock;
	protected Parameter leftParameter, rightParameter;
	protected ExecutableBlock<Void> doBlock;

	@Override
	public AST getSuperRulesAst(AST cst) {
		return AstUtil.getChild(cst, EclParser.EXTENDS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		leftParameter = (Parameter) module.createAst(cst.getSecondChild(), this);
		rightParameter = (Parameter) module.createAst(cst.getThirdChild(), this);
		
		this.compareBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EclParser.COMPARE), this);
		this.doBlock = (ExecutableBlock<Void>) module.createAst(AstUtil.getChild(cst, EclParser.DO), this);
		this.guardBlock = (ExecutableBlock<Boolean>) module.createAst(AstUtil.getChild(cst, EclParser.GUARD), this);
	}
	
	public boolean appliesTo(Object left, Object right, IEclContext context, boolean ofTypeOnly) throws EolRuntimeException {
		
		boolean appliesToTypes = getAllInstances(leftParameter, context, !(!ofTypeOnly || isGreedy())).contains(left) &&
			getAllInstances(rightParameter, context, !(!ofTypeOnly || isGreedy())).contains(right);
		
		boolean guardSatisfied = true;
		
		if (!isAbstract() && appliesToTypes && guardBlock != null) {
			guardSatisfied = guardBlock.execute(context, 
				Variable.createReadOnlyVariable(leftParameter.getName(), left),
				Variable.createReadOnlyVariable(rightParameter.getName(), right),
				Variable.createReadOnlyVariable("self", this)
			);
		}
		
		return appliesToTypes && guardSatisfied;
	}
	
	public Collection<?> getLeftInstance(IEclContext context, boolean ofTypeOnly) throws EolRuntimeException {
		return getAllInstances(leftParameter, context, ofTypeOnly);
	}
	
	public Collection<?> getRightInstance(IEclContext context, boolean ofTypeOnly) throws EolRuntimeException {
		return getAllInstances(rightParameter, context, ofTypeOnly);
	}
	
	public void matchAll(IEclContext context, boolean ofTypeOnly, Object leftInstance, Object rightInstance) throws EolRuntimeException {
		if (!ofTypeOnly && context.getMatchTrace().getMatch(leftInstance, rightInstance) != null) {
			return;
		}
		
		// Try to find a rule with ofTypeOnly = true
		if (appliesTo(leftInstance, rightInstance, context, true)) {
			match(leftInstance, rightInstance, context, false, null, false);
		}
		//TODO: Why both branches do same thing?
		// Else find a rule with onlyOfClass = false
		else if (appliesTo(leftInstance, rightInstance, context, false)) {
			match(leftInstance, rightInstance, context, false, null, false);
		}
	}
	
	/**
	 * Matches left against right
	 * @param left The left object
	 * @param right The right object
	 * @param context The context in which the ECL program is running
	 * @param asSuperRule Shows if the rule is executed as a super-rule of another rule
	 * @return
	 * @throws EolRuntimeException
	 */
	//TOOD: Variables defined in the guard should be accessible in the compare and do parts
	public Match match(Object left, Object right, IEclContext context, boolean asSuperRule, EolMap<?, ?> matchInfo, boolean forcedMatch) throws EolRuntimeException {
		MatchTrace matchTrace = context.getMatchTrace();
		MatchTrace tempMatchTrace = context.getTempMatchTrace();
		Match match = null, tempMatch = null;
		
		if (!asSuperRule) {
			// See if there is a match for left<->right in the temp match trace
			// If there is no match in the temp trace, create one
			// and add it to the temp trace
			// Else, return the temp match
			if ((tempMatch = tempMatchTrace.getMatch(left, right)) == null) {
				tempMatch = new Match(left, right, true, this);
				tempMatchTrace.getMatches().add(tempMatch);
			}
			else {
				return tempMatch;
			}
			
			// See if left<->right have been already matched
			if ((match = matchTrace.getMatch(left, right)) != null) {
				tempMatchTrace.getMatches().remove(tempMatch);
				return match;
			}
		}
		else if (!appliesTo(left, right, context, false)) {
			throw new EclNotApplicableSuperRuleException(left, right, this, context);
		}
		
		// If they have not been matched, construct their Match
		match = new Match(left, right, true, this);
		
		// Execute all the super-rules
		if (!superRules.isEmpty()) {
			boolean matching = true;
			for (ExtensibleNamedRule rule : superRules) {
				MatchRule matchRule = (MatchRule) rule;
				Match superRuleMatch = matchRule.match(left, right, context, true, match.getInfo(), false);
				matching &= superRuleMatch.isMatching();
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
		
		EolMap<?, ?> info = asSuperRule ? matchInfo : match.getInfo();
		
		scope.put(
			Variable.createReadOnlyVariable(leftParameter.getName(), left),
			Variable.createReadOnlyVariable(rightParameter.getName(), right),
			Variable.createReadOnlyVariable("matchInfo", info),
			Variable.createReadOnlyVariable("self", this)
		);
		
		if (compareBlock != null) {
			match.setMatching(compareBlock.execute(context, false));
		}
		else if (superRules.isEmpty()) {
			match.setMatching(false);
		}
		
		if (!asSuperRule) {
			// Before exiting remove the temp match
			// we created from the temp match trace
			tempMatchTrace.getMatches().remove(tempMatch);
			
			// If there are temp matches, it means
			// that the matching decision is based
			// upon rules that may not eventually hold
			// Therefore, in that case we should not
			// add a permanent match
			
			//TODO : See if this affects cyclic dependencies
			if (forcedMatch || tempMatchTrace.getMatches().isEmpty()) {
				matchTrace.getMatches().add(match);
			}
		}
		
		// Execute the do part of the rule
		if (doBlock != null && match.isMatching()) {
			doBlock.execute(context, false);
			//context.getExecutorFactory().executeBlockOrExpressionAst(doAst.getFirstChild(), context);
		}
		
		scope.leaveLocal(this);
		
		return match;
	}

	@Override
	public String toString() {
		return getName()+ " (" +
		leftParameter.getTypeName() + ", " +
		rightParameter.getTypeName() + ")";
	}

	@Override
	public List<ModuleElement> getModuleElements() {
		return Collections.emptyList();
	}
}

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
package org.eclipse.epsilon.erl.rules;

import java.util.ArrayList;
import java.util.ListIterator;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.exceptions.ErlCircularRuleInheritanceException;
import org.eclipse.epsilon.erl.exceptions.ErlRuleNotFoundException;


public abstract class ExtensibleNamedRule extends NamedRule {
	
	protected ArrayList<AST> superRulesAsts = new ArrayList<AST>();	
	//protected IEolContext context;
	protected NamedRules superRules = new NamedRules();
	protected NamedRules allSuperRules = new NamedRules();
	protected Boolean isGreedy = null;
	protected Boolean isAbstract = null;
	protected Boolean isLazy = null;
	
	//public IEolContext getContext() {
	//	return context;
	//}
	
	//public void setContext(IEolContext context) {
	//	this.context = context;
	//}
	
	public boolean isGreedy() throws EolRuntimeException {
		if (isGreedy == null) {
			isGreedy = EolAnnotationsUtil.getBooleanAnnotationValue(ast, "greedy", null);
		}
		return isGreedy;
	}
	
	public boolean isAbstract() throws EolRuntimeException {
		if (isAbstract == null) {
			isAbstract = EolAnnotationsUtil.getBooleanAnnotationValue(ast, "abstract", null);
		}
		return isAbstract;
	}
	
	public boolean isLazy() throws EolRuntimeException {
		if (isLazy == null) {
			isLazy = EolAnnotationsUtil.getBooleanAnnotationValue(ast, "lazy", null);
		}
		return isLazy;
	}
	
	public void calculateSuperRules(NamedRules allRules) throws ErlRuleNotFoundException, ErlCircularRuleInheritanceException{
		
		superRules = new NamedRules();
		calculateSuperRules(this, allRules, superRules, false);
		
		allSuperRules = new NamedRules();
		calculateSuperRules(this, allRules, allSuperRules, true);
		
	}
	
	protected void calculateSuperRules(ExtensibleNamedRule rule, NamedRules allRules, NamedRules collectedRules, boolean recursive) throws ErlRuleNotFoundException, ErlCircularRuleInheritanceException {
		
		ListIterator<AST> li = rule.superRulesAsts.listIterator();
		
		while (li.hasNext()){
			AST superRuleAst = li.next();
			String superRuleName = superRuleAst.getText();
			ExtensibleNamedRule superRule = (ExtensibleNamedRule) allRules.getRule(superRuleName);
			if (superRule != null){
				if (collectedRules.getRule(superRule.getName()) != null){
					throw new ErlCircularRuleInheritanceException(superRule);
				}
				else {
					collectedRules.add(superRule);
				}
				if (recursive){
					calculateSuperRules(superRule, allRules, collectedRules, true);
				}
			}
			else {
				throw new ErlRuleNotFoundException(superRuleAst);
			}
		}
		
	}
	
	public void parse(AST ast) {
		
		this.ast = ast;
		this.name = ast.getFirstChild().getText();
		
		AST superRulesAst = getSuperRulesAst();
		if (superRulesAst != null){
			AST superRuleAst = superRulesAst.getFirstChild();
			while (superRuleAst != null){
				superRulesAsts.add(superRuleAst);
				superRuleAst = superRuleAst.getNextSibling();
			}
		}
		
	}
	
	public abstract AST getSuperRulesAst();
	
	public NamedRules getAllSuperRules() {
		return allSuperRules;
	}
	
	public NamedRules getSuperRules() {
		return superRules;
	}
	
}

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
package org.eclipse.epsilon.erl.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.erl.exceptions.ErlCircularRuleInheritanceException;
import org.eclipse.epsilon.erl.exceptions.ErlRuleNotFoundException;

public abstract class ExtensibleNamedRule extends NamedRule {
	
	protected ArrayList<NameExpression> superRulesIdentifiers = new ArrayList<NameExpression>();	
	protected List<ExtensibleNamedRule> superRules = new ArrayList<ExtensibleNamedRule>();
	protected List<ExtensibleNamedRule> allSuperRules = new ArrayList<ExtensibleNamedRule>();
	protected Boolean isGreedy = null;
	protected Boolean isAbstract = null;
	protected Boolean isLazy = null;
	protected HashMap<Parameter, Collection<?>> ofTypeCache = new HashMap<Parameter, Collection<?>>();
	protected HashMap<Parameter, Collection<?>> ofKindCache = new HashMap<Parameter, Collection<?>>();
	
	public Collection<?> getAllOfKind(Parameter parameter, IEolContext context) throws EolRuntimeException {
		return getAllInstances(parameter, context, false);
	}
	
	public Collection<?> getAllOfType(Parameter parameter, IEolContext context) throws EolRuntimeException {
		return getAllInstances(parameter, context, true);
	}
	
	public Collection<?> getAllInstances(Parameter parameter, IEolContext context, boolean ofTypeOnly) throws EolRuntimeException {
		HashMap<Parameter, Collection<?>> cache = null;
		if (ofTypeOnly) cache = ofTypeCache;
		else cache = ofKindCache;
		
		Collection<?> instances = cache.get(parameter);
		
		if (instances == null){
			try {
				EolModelElementType parameterType = (EolModelElementType) parameter.getType(context);
				if (ofTypeOnly) instances = parameterType.getAllOfType();
				else instances = parameterType.getAllOfKind();
				cache.put(parameter, instances);
			}
			catch (EolModelElementTypeNotFoundException ex){
				ex.setAst(parameter.getTypeExpression());
				throw ex;
			}
			catch (EolModelNotFoundException ex){
				ex.setAst(parameter.getTypeExpression());
				throw ex;
			}
		}
		return instances;
	}
	
	public boolean isGreedy() throws EolRuntimeException {
		if (isGreedy == null) {
			isGreedy = getBooleanAnnotationValue("greedy", null);
		}
		return isGreedy;
	}
	
	public boolean isAbstract() throws EolRuntimeException {
		if (isAbstract == null) {
			isAbstract = getBooleanAnnotationValue("abstract", null);
		}
		return isAbstract;
	}
	
	public boolean isLazy() throws EolRuntimeException {
		if (isLazy == null) {
			isLazy = getBooleanAnnotationValue("lazy", null);
		}
		return isLazy;
	}
	
	public void calculateSuperRules(List<? extends ExtensibleNamedRule> allRules) throws ErlRuleNotFoundException, ErlCircularRuleInheritanceException{
		
		superRules = new ArrayList<ExtensibleNamedRule>();
		calculateSuperRules(this, allRules, superRules, false);
		
		allSuperRules = new ArrayList<ExtensibleNamedRule>();
		calculateSuperRules(this, allRules, allSuperRules, true);
		
	}
	
	protected void calculateSuperRules(ExtensibleNamedRule rule, List<? extends ExtensibleNamedRule> allRules, List<ExtensibleNamedRule> collectedRules, boolean recursive) throws ErlRuleNotFoundException, ErlCircularRuleInheritanceException {
		
		for (AST superRuleAst : rule.superRulesIdentifiers) {
			String superRuleName = superRuleAst.getText();
			ExtensibleNamedRule superRule = (ExtensibleNamedRule) getRuleByName(allRules, superRuleName);
			if (superRule != null){
				if (getRuleByName(collectedRules, superRule.getName()) != null){
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
	
	protected NamedRule getRuleByName(List<? extends NamedRule> rules, String name) {
		for (NamedRule rule : rules) {
			if (rule.getName().equals(name)) {
				return rule;
			}
		}
		return null;
	}
	
	
	public void build() {
		super.build();
		this.name = getFirstChild().getText();
		
		AST superRulesAst = getSuperRulesAst();
		if (superRulesAst != null){
			AST superRuleAst = superRulesAst.getFirstChild();
			while (superRuleAst != null){
				superRulesIdentifiers.add((NameExpression) superRuleAst);
				superRuleAst = superRuleAst.getNextSibling();
			}
		}
		
	}
	
	public abstract AST getSuperRulesAst();
	
	public List<ExtensibleNamedRule> getAllSuperRules() {
		return allSuperRules;
	}
	
	public List<ExtensibleNamedRule> getSuperRules() {
		return superRules;
	}
	
}

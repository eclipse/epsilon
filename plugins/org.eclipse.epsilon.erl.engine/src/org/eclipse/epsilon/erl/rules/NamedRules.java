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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.erl.exceptions.ErlCircularRuleInheritanceException;
import org.eclipse.epsilon.erl.exceptions.ErlRuleNotFoundException;

public class NamedRules extends ArrayList<INamedRule>{
	
	public NamedRules(){
		
	}
	
	public INamedRule getRule(String name){
		ListIterator li = listIterator();
		while (li.hasNext()){
			INamedRule rule = (INamedRule) li.next();
			if (rule.getName().equals(name)){
				return rule;
			}
		}
		return null;
	}

	@Override
	public boolean add(INamedRule rule) {
		if (rule != null) {
			INamedRule existing = getRule(rule.getName());
			if (existing != null){ 
				remove(existing);
			}
		}
		return super.add(rule);
	}

	@Override
	public boolean addAll(Collection<? extends INamedRule> c) {
		boolean result = true;
		for (INamedRule rule : c) {
			result = add(rule) && result;
		}
		return result;
	}
	
	public List<ParseProblem> calculateSuperRules(NamedRules allRules){
		List<ParseProblem> parseProblems = new ArrayList();
		Iterator it = iterator();
		while (it.hasNext()){
			ExtensibleNamedRule rule = (ExtensibleNamedRule) it.next();
			try {
				rule.calculateSuperRules(allRules);
			} catch (ErlRuleNotFoundException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(rule.getAst().getLine());
				problem.setReason(e.getReason());
				parseProblems.add(problem);
			} catch (ErlCircularRuleInheritanceException e) {
				ParseProblem problem = new ParseProblem();
				problem.setLine(rule.getAst().getLine());
				problem.setReason(e.getReason());
				parseProblems.add(problem);
			}
		}
		return parseProblems;
	}
	
}

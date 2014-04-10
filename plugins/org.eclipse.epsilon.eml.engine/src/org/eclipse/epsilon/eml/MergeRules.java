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

import java.util.Iterator;

import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eml.execute.context.IEmlContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.rules.INamedRule;
import org.eclipse.epsilon.erl.rules.NamedRules;

public class MergeRules extends NamedRules{
	
	public MergeRules getRulesFor(Match match, IEmlContext context) throws EolRuntimeException{
		Iterator<INamedRule> li = iterator();
		
		MergeRules rules = new MergeRules();
		
		// First we try to find rules that apply to instance of type only
		while (li.hasNext()){
			MergeRule mergeRule = (MergeRule) li.next();
			if (!mergeRule.isAbstract()){
				if (mergeRule.appliesTo(match, context)){ 
						rules.add(mergeRule);
				}
			}
		}
		
		// If we have found no rules that apply to type we can try to
		// find auto rules that apply to kind
		/*
		if (rules.size() == 0) {
			li = iterator();
			while (li.hasNext()){
				MergeRule mergeRule = (MergeRule) li.next();
				if (!mergeRule.isAbstract()){
					if (mergeRule.appliesTo(match, context)){
							rules.add(mergeRule);
					}
				}
			}
		}
		*/
		
		return rules;
	}
	
	/*
	public EolCollection merge(Object left, Object right, EmlContext context) throws EolRuntimeException{
		Iterator it = getRulesFor(left, right, context).iterator();
		EolCollection targets = new EolBag();
		
		while (it.hasNext()){
			MergeRule rule = (MergeRule) it.next();
			targets.add(rule.merge(left, right, context));
		}
		
		return targets;
	}
	*/
}

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

import java.util.Iterator;

import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.rules.NamedRules;


public class MatchRules extends NamedRules {
 	
	/*
	private MatchRule getRuleFor(Object obj1, Object obj2, EclContext context) throws EolRuntimeException{
		Iterator it = iterator();
		while (it.hasNext()){
			MatchRule matchRule = (MatchRule) it.next();
			if (!matchRule.isAbstract()){
				if (matchRule.appliesTo(obj1, obj2, context, true)){
					return matchRule;
				}
				else if (matchRule.appliesTo(obj1, obj2, context, false)){
					return matchRule;
				}
			}
		}
		return null;
	}
	*/
	
	public MatchRules getRulesFor(Object obj1, Object obj2, IEclContext context, boolean ofClassOnly) throws EolRuntimeException {
		Iterator it = iterator();
		MatchRules rules = new MatchRules();
		while (it.hasNext()){
			MatchRule matchRule = (MatchRule) it.next();
			if (!matchRule.isAbstract()){
				if (matchRule.appliesTo(obj1, obj2, context, ofClassOnly)){
					rules.add(matchRule);
				}
			}
		}
		return rules;
	}
	
}

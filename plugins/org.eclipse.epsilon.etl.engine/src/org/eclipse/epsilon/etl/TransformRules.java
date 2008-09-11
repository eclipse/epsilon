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

import java.util.Iterator;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.rules.NamedRules;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public class TransformRules extends NamedRules{
	
	public TransformRules getRulesFor(Object source, IEtlContext context) throws EolRuntimeException{
		Iterator it = iterator();
		TransformRules rules = new TransformRules();
		
		// First try to find rules that apply to the type
		while (it.hasNext()){
			TransformRule rule = (TransformRule) it.next();
			if (!rule.isAbstract()){
				if (rule.appliesTo(source, context, false)){
					rules.add(rule);
				}
			}
		}
		
		/*
		// If no such rules found try to find rules that apply to the kind
		if (rules.size() == 0) {
			it = iterator();
			while (it.hasNext()){
				TransformRule rule = (TransformRule) it.next();
				if (!rule.isAbstract()){
					if (rule.appliesTo(source, context, false)){
						rules.add(rule);
					}
				}
			}
		}
		*/
		
		return rules;
	}
	
}

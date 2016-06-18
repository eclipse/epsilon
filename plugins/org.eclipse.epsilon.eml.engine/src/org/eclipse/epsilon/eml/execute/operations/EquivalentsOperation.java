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
package org.eclipse.epsilon.eml.execute.operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eml.execute.context.IEmlContext;
import org.eclipse.epsilon.eml.strategy.IMergingStrategy;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;


public class EquivalentsOperation extends SimpleOperation {
	
	@Override
	public Object execute(Object source, List<?> parameters, IEolContext context,
			ModuleElement ast) throws EolRuntimeException {
		
		if (source == null) return null;
		
		List<String> rules = null;
		if (parameters.size() > 0) {
			rules = new ArrayList<String>();
			for (Object parameter : parameters) {
				rules.add(StringUtil.toString(parameter));
			}
		}
		
		IEmlContext emlContext = (IEmlContext) context;
		IMergingStrategy strategy = emlContext.getMergingStrategy();
		
		if (source instanceof Collection){
			return strategy.getEquivalents((Collection<?>) source, emlContext, rules);
		} else {
			return strategy.getEquivalents(source, emlContext, rules);
		}
	}
}


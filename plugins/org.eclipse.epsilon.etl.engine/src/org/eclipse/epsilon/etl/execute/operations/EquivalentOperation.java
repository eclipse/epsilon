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
package org.eclipse.epsilon.etl.execute.operations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;


public class EquivalentOperation extends AbstractSimpleOperation {
	
	@Override
	public Object execute(Object source, List parameters, IEolContext context,
			AST ast) throws EolRuntimeException {
		
		if (source == null) return null;
		
		List<String> rules = null;
		if (parameters.size() > 0) {
			rules = new ArrayList<String>();
			for (Object parameter : parameters) {
				rules.add(StringUtil.toString(parameter));
			}
		}
		
		IEtlContext etlContext = (IEtlContext) context;
		ITransformationStrategy strategy = etlContext.getTransformationStrategy();
		
		if (source instanceof EolCollection){
			EolCollection eolCollection = (EolCollection) source;
			return strategy.getEquivalent(eolCollection.getStorage(), etlContext, rules);
		} else {
			return strategy.getEquivalent(source, etlContext, rules);
		}
	}
}

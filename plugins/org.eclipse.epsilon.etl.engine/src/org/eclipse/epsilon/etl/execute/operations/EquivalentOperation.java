/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.etl.execute.operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;


public class EquivalentOperation extends SimpleOperation {
	
	@Override
	public Object execute(Object source, List<?> parameters, IEolContext context,
			ModuleElement ast) throws EolRuntimeException {
		
		if (source == null) return null;
		
		List<String> rules = null;
		if (parameters.size() > 0) {
			rules = new ArrayList<>();
			for (Object parameter : parameters) {
				rules.add(StringUtil.toString(parameter));
			}
		}
		
		IEtlContext etlContext = (IEtlContext) context;
		ITransformationStrategy strategy = etlContext.getTransformationStrategy();
		
		if (source instanceof Collection){
			return strategy.getEquivalent((Collection<?>) source, etlContext, rules);
		} else {
			return strategy.getEquivalent(source, etlContext, rules);
		}
	}
}

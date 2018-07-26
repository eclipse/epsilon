/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl.execute.operations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;

public class MatchesOperation extends SimpleOperation {
	
	protected boolean matchInstances(Object left, Object right, IEclContext context, boolean forcedMatch) throws EolRuntimeException{
		Match match = context.getModule().match(left, right, forcedMatch);
		return match.isMatching();
	}

	@Override
	public Boolean execute(Object source, List<?> parameters,
			IEolContext context_, ModuleElement ast) throws EolRuntimeException {
		
		IEclContext context = (IEclContext) context_;
		Object parameter = parameters.get(0);
		if (source == null && parameter == null) return true;
		
		if (source instanceof Collection && parameter instanceof Collection){
			
			Collection<?> leftCol = (Collection<?>) source;
			Collection<?> rightCol = (Collection<?>) parameter;

			Collection<?> leftColFlat = CollectionUtil.flatten(leftCol);
			Collection<?> rightColFlat = CollectionUtil.flatten(rightCol);
			
			if (leftColFlat.size() != rightColFlat.size()) {
				return false;
			}
			
			Iterator<?> lit = leftColFlat.iterator();
			Iterator<?> rit = rightColFlat.iterator();
			
			boolean match = true;
			
			while (lit.hasNext() && match) {
				match = match && (matchInstances(lit.next(), rit.next(), context, false));
			}
			
			return match;
		}
		else if (source instanceof Collection ^ parameter instanceof Collection) {
			return false;
		}
		else {
			return matchInstances(source, parameter, context, false);
		}
	}
}

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
import java.util.Set;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolOrderedSet;

public class MatchesOperation extends SimpleOperation {
	
	protected boolean matchInstances(Object left, Object right, IEclContext context, boolean forcedMatch) throws EolRuntimeException {
		Match match = context.getModule().match(left, right, forcedMatch);
		return match.isMatching();
	}

	@Override
	public Boolean execute(Object source, List<?> parameters,
			IEolContext context_, ModuleElement ast) throws EolRuntimeException {
		
		IEclContext context = (IEclContext) context_;
		Object parameter = parameters.get(0);
		
		if (source == parameter) return true;
		
		if (source instanceof Collection && parameter instanceof Collection) {
			// This implementation finds proof by counter-example.
			// "Innocent until proven guilty"
			
			Collection<?> leftCol = (Collection<?>) source;
			Collection<?> rightCol = (Collection<?>) parameter;		
			if (leftCol.equals(rightCol)) return true;
			
			Collection<?> leftColFlat = CollectionUtil.flatten(leftCol);
			Collection<?> rightColFlat = CollectionUtil.flatten(rightCol);	
			if (leftColFlat.equals(rightColFlat)) return true;
			
			boolean match = true;
			
			if (leftColFlat.size() != rightColFlat.size()) {
				match = false;
			}
			// Unordered collection
			else if (leftCol instanceof Set || leftCol instanceof EolBag && !(leftCol instanceof EolOrderedSet) &&
				rightCol instanceof Set || rightCol instanceof EolBag && !(rightCol instanceof EolOrderedSet)) {

				for (Object left : leftColFlat) {
					match = false;
					for (Object right : rightColFlat) {
						if (match = matchInstances(left, right, context, false)) {
							break;
						}
					}
					if (!match) break;
				}
				
			}
			// Respect ordering
			else {
				Iterator<?> lit = leftColFlat.iterator();
				Iterator<?> rit = rightColFlat.iterator();
				
				while (lit.hasNext() && (match = matchInstances(lit.next(), rit.next(), context, false))) {
					continue;
				}
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

/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - refactoring
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class SelectOperation extends FirstOrderOperation {
	
	/**
	 * 
	 * @param isSelect
	 * @param returnOnMatch
	 * @param target
	 * @param operationNameExpression
	 * @param iterators
	 * @param expressions
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	public Collection<?> execute(boolean isSelect, boolean returnOnMatch, Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context)  throws EolRuntimeException {
		
		final Collection<Object> source = resolveSource(target, iterators, context);
		final CheckedEolPredicate<Object> predicate = resolvePredicate(operationNameExpression, iterators, expressions, context);
		final Collection<Object> result = EolCollectionType.createSameType(source);
		
		final boolean isRejectOne = !isSelect && returnOnMatch;
		if (isRejectOne) {
			result.addAll(source);
		}
		
		for (Object item : source) {
			boolean bodyResult = predicate.testThrows(item);

			if (isRejectOne && bodyResult) {
				result.remove(item);
				return result;
			}
			else if (!isRejectOne && ((isSelect && bodyResult) || (!isSelect && !bodyResult))) {
				result.add(item);
				if (returnOnMatch) {
					return result;
				}
			}
		}
		
		return result;
	}
	
	@Override
	public Collection<?> execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		return execute(true, false, target, operationNameExpression, iterators, expressions, context);
	}
	
}

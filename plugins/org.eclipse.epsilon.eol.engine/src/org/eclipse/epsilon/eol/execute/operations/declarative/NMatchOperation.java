/*********************************************************************
* Copyright (c) 2018 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;

/**
 * Returns true if exactly <i>n</i> elements match the predicate.
 * This is therefore a short-circuiting operation.
 * @author Sina Madani
 * @since 1.6
 */
public class NMatchOperation extends FirstOrderOperation {

	private final int n;
	
	/**
	 * nMatch operation where target matches is specified on a per-invocation basis.
	 */
	public NMatchOperation() {
		n = -1;	// Negative signifies that no initial value is specified
	}
	
	/**
	 * nMatch operation with the target matches pre-specified.
	 * 
	 * @param n The number of target matches.
	 * @throws IllegalArgumentException If n is less than zero.
	 */
	public NMatchOperation(int n) throws IllegalArgumentException {
		if ((this.n = n) < 0)
			throw new IllegalArgumentException("Target matches can't be negative!");
	}

	@Override
	public final Boolean execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		int targetMatches;
		if (n >= 0) {
			targetMatches = n;
		}
		else if (expressions.size() > 1) {
			Object userDefinedN = expressions.get(1).execute(context);
			if (userDefinedN instanceof Integer) {
				targetMatches = (int) userDefinedN;
			}
			else {
				String actualType = userDefinedN != null ? userDefinedN.getClass().getTypeName() : "null";
				throw new EolIllegalOperationParametersException("nMatch", "Integer", actualType, expressions.get(1));
			}
		}
		else {
			throw new EolIllegalOperationParametersException("nMatch");
		}
		
		final Collection<Object> source = resolveSource(target, iterators, context);
		final int sourceSize = source.size();
		if (sourceSize < targetMatches) return false;

		return execute(sourceSize, targetMatches, source, operationNameExpression, iterators, expressions, context);
	}
	
	protected boolean execute(int sourceSize, int targetMatches, Collection<Object> source, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		
		CheckedEolPredicate<Object> predicate = resolvePredicate(operationNameExpression, iterators, expressions, context);
		
		int currentIndex = 0, currentMatches = 0;
		
		for (Object item : source) {
			++currentIndex;
			
			// Short-circuit if we exceeded the number OR already failed to meet threshold
			if (predicate.testThrows(item) && (++currentMatches > targetMatches ||
				// # of remaining elements  vs   # of remaining matches
				(sourceSize - currentIndex) < (targetMatches - currentMatches))
			) {
				return false;
			}
		}
		
		return currentMatches == targetMatches;
	}
}

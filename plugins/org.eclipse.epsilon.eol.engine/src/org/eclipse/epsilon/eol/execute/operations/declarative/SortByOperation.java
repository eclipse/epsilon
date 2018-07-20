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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.*;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class SortByOperation extends CollectOperation {
	
	@Override
	public EolSequence<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		final List<?> source = CollectionUtil.asList(target);
		final List<?> collected = CollectionUtil.asList(super.execute(target, iterator, expression, context));
		final int colSize = collected.size();
		assert colSize == source.size();
		
		DecoratedObject[] decoratedObjects = new DecoratedObject[colSize];
		
		Iterator<?> sourceIter = source.iterator(), collectedIter = collected.iterator();
		for (int i = 0; i < colSize; i++) {
			decoratedObjects[i] = new DecoratedObject(sourceIter.next(), collectedIter.next());
		}
		
		// This will automatically become a sequential sort if array size is small.
		Arrays.parallelSort(decoratedObjects, new DecoratedObjectComparator(context.getPrettyPrinterManager()));
		
		// Build a new collection of the original collection elements
		// ordered by the result of sorting the collected items
		final EolSequence<Object> result = new EolSequence<>(decoratedObjects.length);
		
		for (DecoratedObject decorated : decoratedObjects) {
			result.add(decorated.object);
		}
		
		return result;
	}
	
	protected static class DecoratedObjectComparator implements Comparator<DecoratedObject> {
		
		protected PrettyPrinterManager p;
		
		public DecoratedObjectComparator(PrettyPrinterManager p) {
			this.p = p;
		}
		
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		public int compare(DecoratedObject do1, DecoratedObject do2) {

			Object o1 = do1.decoration;
			Object o2 = do2.decoration;

			if (o1 instanceof Number && o2 instanceof Number) {
				if (NumberUtil.greaterThan((Number) o2, (Number) o1)) return -1;
				else if (NumberUtil.greaterThan((Number) o1, (Number) o2)) return 1;
				else return 0;
			}
			else if (o1 instanceof Comparable && o2 instanceof Comparable) {
				return ((Comparable) o1).compareTo(o2);
			}
			else {
				return p.print(o1).compareTo(p.print(o2));
			}
		}
	}
	
	protected static class DecoratedObject {
		public final Object object, decoration;
		
		public DecoratedObject(Object object, Object decoration) {
			this.object = object;
			this.decoration = decoration;
		}
	}
}

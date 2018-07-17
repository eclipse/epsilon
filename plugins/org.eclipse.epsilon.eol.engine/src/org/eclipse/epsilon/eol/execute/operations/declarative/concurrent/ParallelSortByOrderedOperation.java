package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.declarative.SortByOperation.DecoratedObject;
import org.eclipse.epsilon.eol.execute.operations.declarative.SortByOperation.DecoratedObjectComparator;
import org.eclipse.epsilon.eol.types.EolSequence;

public class ParallelSortByOrderedOperation extends ParallelCollectOrderedOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		final List<?> source = CollectionUtil.asList(target);
		final List<?> collected = CollectionUtil.asList(super.execute(target, iterator, expression, context));
		final int colSize = collected.size();
		
		DecoratedObject[] decoratedObjects = new DecoratedObject[colSize];
		
		int i = 0;
		for (Iterator<?> sourceIter = source.iterator(), collectedIter = collected.iterator(); i < colSize; i++) {
			decoratedObjects[i] = new DecoratedObject(sourceIter.next(), collectedIter.next());
		}
		
		Arrays.parallelSort(decoratedObjects, new DecoratedObjectComparator(context.getPrettyPrinterManager()));
		
		// Build a new collection of the original collection elements
		// ordered by the result of sorting the collected items
		final Collection<Object> result = new EolSequence<>(decoratedObjects.length);
		
		for (DecoratedObject decorated : decoratedObjects) {
			result.add(decorated.object);
		}
		
		return result;
	}
	
}

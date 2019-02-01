/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.MapByOperation;
import org.eclipse.epsilon.eol.function.CheckedEolFunction;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolSequence;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelMapByOperation extends MapByOperation {

	@Override
	public EolMap<Object, EolSequence<Object>> execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context_) throws EolRuntimeException {
		
		Collection<?> source = resolveSource(target, iterators, context_);
		if (source.isEmpty()) return new EolMap<>();
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		Collection<Future<Entry<?, ?>>> jobResults = new ArrayList<>(source.size());
		Expression expression = expressions.get(0);
		CheckedEolFunction<Object, ?> function = resolveFunction(operationNameExpression, iterators, expression, context);
		EolExecutorService executor = context.beginParallelTask(expression);
		
		for (Object item : source) {
			jobResults.add(executor.submit(() -> new SimpleEntry<>(function.applyThrows(item), item)));
		}
		
		Collection<Entry<?, ?>> intermediates = executor.collectResults(jobResults);
		context.endParallelTask(expression);
		
		return intermediates.stream()
			.collect(Collectors.toMap(
				Entry::getKey,
				entry -> {
					EolSequence<Object> value = new EolSequence<>();
					value.add(entry.getValue());
					return value;
				},
				(oldVal, newVal) -> {
					oldVal.addAll(newVal);
					return oldVal;
				},
				EolMap::new
			)
		);
	}
}

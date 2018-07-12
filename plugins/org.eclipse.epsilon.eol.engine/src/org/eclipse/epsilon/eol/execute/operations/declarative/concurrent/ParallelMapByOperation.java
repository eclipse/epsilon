package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.MapByOperation;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolSequence;

public class ParallelMapByOperation extends MapByOperation {

	@Override
	public EolMap<?, Collection<Object>> execute(Object target, Variable iterator, Expression expression,
			IEolContext context_) throws EolRuntimeException {
		
		IEolContextParallel context = context_ instanceof IEolContextParallel ?
			(EolContextParallel) context_ : new EolContextParallel(context_);
		context.goParallel();

		Collection<?> source = CollectionUtil.asCollection(target);
		EolExecutorService executor = context.newExecutorService();
		Collection<Future<Entry<?, ?>>> futures = new ArrayList<>(source.size());
		
		for (Object item : source) {
			if (iterator.getType() == null || iterator.getType().isKind(item)) {
				futures.add(executor.submit(() -> {
					
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						new Variable(iterator.getName(), item, iterator.getType(), true)
					);
					
					Object bodyResult = context.getExecutorFactory().execute(expression, context);
					
					scope.leaveLocal(expression);
					return new SimpleEntry<>(bodyResult, item);
				}));
			}
		}
		
		return executor.collectResults(futures, true)
			.stream()
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

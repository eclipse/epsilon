package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.Future;
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
import org.eclipse.epsilon.eol.execute.operations.declarative.FirstOrderOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class ParallelSelectOperation extends SelectOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
		IEolContext context_, final boolean returnOnMatch, final boolean isSelect) throws EolRuntimeException {
		
		if (returnOnMatch) {
			FirstOrderOperation delegate = isSelect ? new ParallelSelectOneOperation() : new ParallelRejectOneOperation();	
			Object result = delegate.execute(target, iterator, expression, context_);
			
			return isSelect ? Collections.singleton(result) : (Collection<?>) result;
		}
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		Collection<Object> resultsCol = EolCollectionType.createSameType(source);
		EolExecutorService executor = context.getAndCacheExecutorService();
		Collection<Future<Optional<?>>> futures = new ArrayList<>(source.size());
		
		for (Object item : source) {
			futures.add(executor.submit(() -> {
				Optional<?> intermediateResult = null;
				if (iterator.getType() == null || iterator.getType().isKind(item)) {
					
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						Variable.createReadOnlyVariable(iterator.getName(), item)
					);
					
					Object bodyResult = context.getExecutorFactory().execute(expression, context);
					
					if (bodyResult instanceof Boolean) {
						boolean brBool = (boolean) bodyResult;
						if ((isSelect && brBool) || (!isSelect && !brBool)) {
							intermediateResult = Optional.ofNullable(item);
						}
					}
					
					scope.leaveLocal(expression);
				}
				return intermediateResult;
			}));
		}
		
		executor.collectResults(futures, false)
			.stream()
			.filter(opt -> opt != null)
			.map(opt -> opt.orElse(null))
			.forEach(resultsCol::add);
		
		return resultsCol;
	}
}

package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
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
import org.eclipse.epsilon.eol.execute.operations.declarative.NMatchOperation;

public class ParallelNMatchOperation extends NMatchOperation {
	
	public ParallelNMatchOperation(int targetMatches) {
		super(targetMatches);
	}
	
	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context_) throws EolRuntimeException {
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		if (source.size() < targetMatches) return false;
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);

		AtomicInteger currentMatches = new AtomicInteger(), currentIndex = new AtomicInteger();
		EolExecutorService executor = context.getExecutorService();
		Object condition = executor.getExecutionStatus().register();
		Collection<Future<?>> jobs = new ArrayList<>(source.size());
		
		for (Object item : source) {
			currentIndex.incrementAndGet();
			jobs.add(executor.submit(() -> {
				if (iterator.getType() == null || iterator.getType().isKind(item)) {
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						Variable.createReadOnlyVariable(iterator.getName(), item)
					);
					
					Object bodyResult = null;
					try {
						bodyResult = context.getExecutorFactory().execute(expression, context);
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, executor);
					}
					
					if (bodyResult instanceof Boolean && (boolean) bodyResult) { 
						int currentMatchesCached = currentMatches.incrementAndGet();
						if (
							currentMatchesCached > targetMatches ||
							currentIndex.get() > targetMatches && (currentMatchesCached < targetMatches)
						)
							
							executor.getExecutionStatus().completeSuccessfully(condition);
					}
					
					scope.leaveLocal(expression);
				}
			}));
			
		}
		
		// Prevent unnecessary evaluation of remaining jobs once we have the result
		executor.shortCircuitCompletion(jobs, condition);

		return currentMatches.get() == targetMatches;
	}
}

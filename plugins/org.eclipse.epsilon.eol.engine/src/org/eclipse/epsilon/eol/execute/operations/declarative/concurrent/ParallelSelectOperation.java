package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolType;

public class ParallelSelectOperation extends SelectOperation {
	
	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression, IEolContext context_,
		boolean isSelect, boolean returnOnMatch) throws EolRuntimeException {
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		Collection<Object> resultsCol = EolCollectionType.createSameType(source);
		
		if (source.isEmpty()) return resultsCol;
		
		boolean isRejectOne = !isSelect && returnOnMatch;
		if (isRejectOne) {
			resultsCol.addAll(source);
		}
		
		EolType iteratorType = iterator.getType();
		String iteratorName = iterator.getName();
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		Collection<Future<Optional<?>>> futures = new ArrayList<>(source.size());
		EolExecutorService executor = context.beginParallelJob(expression);
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				futures.add(executor.submit(() -> {
					
					Optional<?> intermediateResult = null;
						
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						new Variable(iteratorName, item, iteratorType, true)
					);
					
					Object bodyResult = context.getExecutorFactory().execute(expression, context);
					
					if (bodyResult instanceof Boolean) {
						boolean brBool = (boolean) bodyResult;
						boolean shortCircuit = false;
						
						if (isRejectOne && brBool || (!isRejectOne && ((isSelect && brBool) || (!isSelect && !brBool)))) {
							intermediateResult = Optional.ofNullable(item);
							shortCircuit = returnOnMatch;
						}
						
						if (shortCircuit) {
							scope.leaveLocal(expression);
							// "item" will be the result
							executor.getExecutionStatus().completeSuccessfully(intermediateResult);
							return intermediateResult;
						}
					}
					
					scope.leaveLocal(expression);
					return intermediateResult;
				}));
			}
		}
		
		if (returnOnMatch) {
			Optional<?> result = executor.shortCircuitCompletionTyped(futures);
			
			if (result != null) {
				Object actualResult = result.orElse(null);		
				if (isRejectOne) {
					resultsCol.remove(actualResult);
				}
				else {
					resultsCol.add(actualResult);
				}
			}
		}
		else {
			executor.collectResults(futures)
				.stream()
				.filter(opt -> opt != null)
				.map(opt -> opt.orElse(null))
				.forEach(resultsCol::add);
		}
		
		context.exitParallelNest();
		
		return resultsCol;
	}
}

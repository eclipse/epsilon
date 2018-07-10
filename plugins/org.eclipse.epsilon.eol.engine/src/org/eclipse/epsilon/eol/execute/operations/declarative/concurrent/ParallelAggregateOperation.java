package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.AggregateOperation;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolType;

public class ParallelAggregateOperation extends AggregateOperation {
	
	@Override
	public EolMap<?, ?> execute(Object target,
			NameExpression operationNameExpression, List<Parameter> iterators,
			List<Expression> expressions, IEolContext context_)
			throws EolRuntimeException {
		
		Parameter iterator = iterators.get(0);
		EolType iteratorType = iterator.getType(context_);
		Expression keyExpression = expressions.get(0);
		Expression valueExpression = expressions.get(1);
		Expression initialExpression = expressions.size() > 2 ? expressions.get(2) : null;
		Collection<?> source = CollectionUtil.asCollection(target);
		Map<Object, Object> resultsMap = ConcurrencyUtils.concurrentMap();
		
		IEolContextParallel context = context_ instanceof IEolContextParallel ?
			(EolContextParallel) context_ : new EolContextParallel(context_);
		context.goParallel();
		
		EolExecutorService executor = context.newExecutorService();

		for (Object item : source) {
			executor.execute(() -> {
				if (iteratorType == null || iteratorType.isKind(item)) {
					
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, keyExpression,
						Variable.createReadOnlyVariable(iterator.getName(), item)
					);
					
					try {
						Object total, keyResult = context.getExecutorFactory().execute(keyExpression, context);
						
						if (resultsMap.containsKey(keyResult)) {
							total = resultsMap.get(keyResult);
						}
						else {
							total = context.getExecutorFactory().execute(initialExpression, context);
						}
						
						scope.put(Variable.createReadOnlyVariable("total", total));
						Object valueResult = context.getExecutorFactory().execute(valueExpression, context);
						resultsMap.put(keyResult, valueResult);
						scope.leaveLocal(keyExpression);
					}
					catch (EolRuntimeException exception) {
						context.handleException(exception, executor);
					}
				}
			});
		}
		
		executor.awaitCompletion();
		
		EolMap<Object, Object> asEol = new EolMap<>();
		asEol.putAll(resultsMap);
		return asEol;
	}

}

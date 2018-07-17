package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
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

public class ParallelSelectOneOperation extends FirstOrderOperation {
	
	final boolean isSelect;
	boolean hasResult;
	
	public ParallelSelectOneOperation() {
		isSelect = true;
	}
	
	ParallelSelectOneOperation(boolean select) {
		this.isSelect = select;
	}
	
	@Override
	public Object execute(Object target, Variable iterator, Expression expression,
			IEolContext context_) throws EolRuntimeException {
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		
		EolExecutorService executor = context.newExecutorService();
		ConcurrentExecutionStatus execStatus = executor.getExecutionStatus();
		
		for (Object item : source) {
			executor.execute(() -> {
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
					
					if (bodyResult instanceof Boolean) {
						boolean brBool = (boolean) bodyResult;
						if ((brBool && isSelect) || (!brBool && !isSelect)) {
							hasResult = true;
							// "item" will be the result
							execStatus.completeSuccessfully(item);
						}
					}
					
					scope.leaveLocal(expression);
				}
			});
			
		}
		
		Object result = executor.awaitCompletion();
		// Prevent unnecessary evaluation of remaining jobs once we have the result
		executor.shutdownNow();

		//context.endParallel();
		return result;
	}

}

package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class NMatchOperation extends FirstOrderOperation {

	protected final int targetMatches;
	
	public NMatchOperation(int targetMatches) {
		this.targetMatches = targetMatches;
	}
	
	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		Collection<Object> source = CollectionUtil.asCollection(target);
		int currentMatches = 0;
		FrameStack scope = context.getFrameStack();
		
		for (Object item : source) {
			if (iterator.getType() == null || iterator.getType().isKind(item)) {
				scope.enterLocal(FrameType.UNPROTECTED, expression,
					Variable.createReadOnlyVariable(iterator.getName(), item)
				);
				
				Object bodyResult = context.getExecutorFactory().execute(expression, context);
				if (bodyResult instanceof Boolean && (boolean) bodyResult && ++currentMatches > targetMatches) {
					scope.leaveLocal(expression);
					return false;
				}
				scope.leaveLocal(expression);
			}
		}
		
		return currentMatches == targetMatches;
	}

}

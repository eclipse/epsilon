package org.eclipse.epsilon.emc.simulink.operations;

import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.util.collection.AbstractSimulinkCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkElementCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.StateflowBlockCollection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;

public class SimulinkCollectOperation extends CollectOperation {

	protected MatlabEngine engine;

	public SimulinkCollectOperation(MatlabEngine engine){
		this.engine = engine;
	}
	
	@Override
	public Collection<?> execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators,
			List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		AbstractSimulinkCollection<?, ?, ?> targetList;
		if (target instanceof AbstractSimulinkCollection 
				&& ! (target instanceof StateflowBlockCollection || target instanceof SimulinkElementCollection)) {
			targetList = (AbstractSimulinkCollection<?,?,?>) target;
			
			List<?> handles = targetList.getPrimitive();
			if (areExpressionsValid(expressions)) {
				PropertyCallExpression expression = (PropertyCallExpression) expressions.get(0);
				try{
					return (Collection<?>) engine.evalWithSetupAndResult("handles=?;", "get_param(handles, '?');", handles, expression.getName());
				} catch (Exception e) {
					e.printStackTrace();
					// TODO
				}
			}
			
					
		}		
		
		return super.execute(target, operationNameExpression, iterators, expressions, context);		
	}
	
	protected boolean areExpressionsValid(List<Expression> expressions){
		if (expressions.size()==1) {			
			if ((expressions.get(0) instanceof PropertyCallExpression)) {
				return true;
			}
		}
		return false;
	}
	
}
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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;

public class SimulinkSelectOperation extends SelectOperation {

	protected MatlabEngine engine;

	public SimulinkSelectOperation(MatlabEngine engine){
		this.engine = engine;
	}

	@Override
	public Collection<?> execute(boolean returnOnMatch, Object target, NameExpression operationNameExpression,
			List<Parameter> iterators, Expression expression, IEolContext context) throws EolRuntimeException {
		
		AbstractSimulinkCollection<?, ?, ?> targetList;
		if (target instanceof AbstractSimulinkCollection 
				&& ! (target instanceof StateflowBlockCollection || target instanceof SimulinkElementCollection)) {
			targetList = (AbstractSimulinkCollection<?,?,?>) target;
			
			createIteratorVariable(null, iterators.get(0), context);
			//targetList.get(0);
			
		}		
		
		return super.execute(returnOnMatch, target, operationNameExpression, iterators, expression, context);
	}
}

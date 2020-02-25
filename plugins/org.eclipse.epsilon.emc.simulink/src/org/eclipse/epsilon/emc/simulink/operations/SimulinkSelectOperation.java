package org.eclipse.epsilon.emc.simulink.operations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.collection.AbstractSimulinkCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkBlockCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkElementCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkLineCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkPortCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.StateflowBlockCollection;
import org.eclipse.epsilon.eol.dom.DoubleEqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;

public class SimulinkSelectOperation extends SelectOperation {

	protected MatlabEngine engine;
	protected SimulinkModel model;

	public SimulinkSelectOperation(MatlabEngine engine, SimulinkModel model){
		this.engine = engine;
		this.model = model;
	}

	@Override
	public Collection<?> execute(boolean returnOnMatch, Object target, NameExpression operationNameExpression,
			List<Parameter> iterators, Expression expression, IEolContext context) throws EolRuntimeException {
		
		AbstractSimulinkCollection<?, ?, ?> targetList;
		if (target instanceof AbstractSimulinkCollection 
				&& ! (target instanceof StateflowBlockCollection || target instanceof SimulinkElementCollection)) {
			targetList = (AbstractSimulinkCollection<?,?,?>) target;
			
			List<?> handles = targetList.getPrimitive();
			if (expression instanceof DoubleEqualsOperatorExpression) {
				String propCallEx = null;
				Expression first = ((DoubleEqualsOperatorExpression) expression).getFirstOperand();
				Expression second = ((DoubleEqualsOperatorExpression) expression).getSecondOperand();
				if (first instanceof PropertyCallExpression) {
					propCallEx =  ((PropertyCallExpression) first).getNameExpression().getName();
				} else if (second instanceof PropertyCallExpression) {
					propCallEx =  ((PropertyCallExpression) second).getNameExpression().getName();
				}
				String value = null;
				if (first instanceof StringLiteral) {
					value =  ((StringLiteral) first).getValue();
				} else if (second instanceof StringLiteral) {
					value =  ((StringLiteral) second).getValue();
				}
				if (propCallEx != null && value != null) {					
					try{
						Object result = engine.evalWithSetupAndResult("handles=?;", "find_system(handles, '?','?');", handles, propCallEx, value);
						return wrap(result, (AbstractSimulinkCollection<?,?,?>) target);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO
					}
				}
			} else if (expression instanceof OperationCallExpression) {
				
			}			
		}		
		
		return super.execute(returnOnMatch, target, operationNameExpression, iterators, expression, context);
	}
	
	protected boolean areExpressionsValid(Expression expression){
		if ((expression instanceof OperationCallExpression)) {
			return true;
		}
		if ((expression instanceof DoubleEqualsOperatorExpression)) {
			return true;
		}
		return false;
	}
	
	protected AbstractSimulinkCollection wrap(Object result, AbstractSimulinkCollection target){
		if (target instanceof SimulinkBlockCollection) {
			return new SimulinkBlockCollection(result, model);
		} else if (target instanceof SimulinkPortCollection) {
			return new SimulinkPortCollection(result, model);
		} else if (target instanceof SimulinkLineCollection) {
			return new SimulinkPortCollection(result, model);
		} else {
			return new SimulinkElementCollection(result, model);
		}
	}
}

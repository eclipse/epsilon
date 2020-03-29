/*********************************************************************
 * Copyright (c) 2008 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.operations;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.emc.simulink.util.collection.StateflowBlockCollection;
import org.eclipse.epsilon.eol.dom.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.NotOperatorExpression;
import org.eclipse.epsilon.eol.dom.OperatorExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;

public class StateflowSelectOperation extends SelectOperation {

	protected MatlabEngine engine;

	public StateflowSelectOperation(MatlabEngine engine){
		this.engine = engine;
	}
	
	@Override
	public Collection<?> execute(boolean returnOnMatch, Object target, NameExpression operationNameExpression,
			List<Parameter> iterators, Expression expression, IEolContext context) throws EolRuntimeException {

		StateflowBlockCollection targetList;
		if (target instanceof StateflowBlockCollection) {
			if (isExpressionOptimisable(expression)) {
				if (expression instanceof NotOperatorExpression) {
					expression = ((NotOperatorExpression) expression).getFirstOperand();
				}
				targetList = (StateflowBlockCollection) target;
				
				List<?> handles = targetList.getPrimitive();
				String cellArray = handles.stream().map(e->new Integer(((Double)e).intValue()).toString()).collect(Collectors.joining(";","{","}"));
				
				if (expression instanceof EqualsOperatorExpression ) {
					String propCallEx = null;
					Expression first = ((OperatorExpression) expression).getFirstOperand();
					Expression second = ((OperatorExpression) expression).getSecondOperand();
					if (first instanceof PropertyCallExpression) {
						propCallEx =  ((PropertyCallExpression) first).getNameExpression().getName();
					} else if (second instanceof PropertyCallExpression) {
						propCallEx =  ((PropertyCallExpression) second).getNameExpression().getName();
					}
					// FIXME consider cases where value is not a string 
					String value = null;
					if (first instanceof StringLiteral) {
						value =  ((StringLiteral) first).getValue();
					} else if (second instanceof StringLiteral) {
						value =  ((StringLiteral) second).getValue();
					}
					if (propCallEx != null && value != null) {
						SimulinkModel model = targetList.getManager().getModel(); 
						try{
							StateflowUtil.modelHandleAsM(model);
							String setup = "handles=cell2mat(arrayfun(@(a) m.find('Id',a),cell2mat(?), 'UniformOutput', false));";
							engine.eval(setup, cellArray);
							Object result = engine.evalWithResult("get(handles.find('?','?'),'Id');", propCallEx, value);
							if (result instanceof Collection) {
								result = engine.evalWithResult("cell2mat(result);");
							}
							return new StateflowBlockCollection(result, model);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO
						}
					}
				}	
			}
		}		
		return super.execute(returnOnMatch, target, operationNameExpression, iterators, expression, context);
	}
	

	protected boolean isExpressionOptimisable(Expression expression){
		if (expression instanceof NotOperatorExpression) {
			expression = ((NotOperatorExpression) expression).getFirstOperand();
		}
		if ((expression instanceof EqualsOperatorExpression) && 
				(
					(((OperatorExpression) expression).getFirstOperand() instanceof PropertyCallExpression) 
					|| (((OperatorExpression) expression).getSecondOperand() instanceof PropertyCallExpression) 
				) 
				&& (
					(((OperatorExpression) expression).getFirstOperand() instanceof StringLiteral) 
					|| (((OperatorExpression) expression).getSecondOperand() instanceof StringLiteral)
				)
		){
			return true;
		}
		return false;
	}
}

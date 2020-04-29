/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;

public class AssignmentStatement extends Statement {
	
	protected Expression targetExpression;
	protected Expression valueExpression;
	
	public AssignmentStatement() {}
	
	public AssignmentStatement(Expression targetExpression, Expression valueExpression) {
		this.targetExpression = targetExpression;
		this.valueExpression = valueExpression;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		targetExpression = (Expression) module.createAst(cst.getFirstChild(), this);
		valueExpression = (Expression) module.createAst(cst.getSecondChild(), this);
		
		switch (cst.getText()) {
			case "+=":
				valueExpression = new PlusOperatorExpression(targetExpression, valueExpression);
				break;
			case "-=":
				valueExpression = new MinusOperatorExpression(targetExpression, valueExpression);
				break;
			case "/=":
				valueExpression = new DivOperatorExpression(targetExpression, valueExpression);
				break;
			case "*=":
				valueExpression = new TimesOperatorExpression(targetExpression, valueExpression);
				break;
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {	
		ExecutorFactory executorFactory = context.getExecutorFactory();
		
		Object valueExpressionResult;
			
		if (targetExpression instanceof PropertyCallExpression) {
			PropertyCallExpression pce = (PropertyCallExpression) targetExpression;
			Object source = executorFactory.execute(pce.getTargetExpression(), context);
			String property = pce.getName();
			IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(source, property, context);
			valueExpressionResult = executorFactory.execute(valueExpression, context);
			Object value = getValueEquivalent(source, valueExpressionResult, context);
			setter.invoke(source, property, value, context);
		}
		else {
			Object targetExpressionResult = targetExpression instanceof NameExpression ?
				((NameExpression) targetExpression).execute(context, true) :
				executorFactory.execute(targetExpression, context);
			
			if (targetExpressionResult instanceof Variable) {
				Variable variable = (Variable) targetExpressionResult;
				valueExpressionResult = executorFactory.execute(valueExpression, context);
				try {
					Object value = getValueEquivalent(variable.getValue(), valueExpressionResult, context);
					variable.setValue(value, context);
				}
				catch (EolRuntimeException ex) {
					ex.setAst(targetExpression);
					throw ex;
				}
			}
			else {
				throw new EolRuntimeException("Internal error. Expected either a SetterMethod or a Variable and got an " + targetExpressionResult + " instead", this);
			}
		}
		
		return valueExpressionResult;
	}
	
	protected Object getValueEquivalent(Object source, Object value, IEolContext context) throws EolRuntimeException {
		return value;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
		valueExpression.compile(context);
	}
	
	public Expression getTargetExpression() {
		return targetExpression;
	}
	
	public void setTargetExpression(Expression targetExpression) {
		this.targetExpression = targetExpression;
	}
	
	public Expression getValueExpression() {
		return valueExpression;
	}
	
	public void setValueExpression(Expression valueExpression) {
		this.valueExpression = valueExpression;
	}
}

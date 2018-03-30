package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;

public class AssignmentStatement extends Statement {
	
	protected Expression targetExpression, valueExpression;
	
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
		
		String text = cst.getText();
		if (text.equals("+=")) {
			valueExpression = new PlusOperatorExpression(targetExpression, valueExpression);
		}
		else if (text.equals("-=")) {
			valueExpression = new MinusOperatorExpression(targetExpression, valueExpression);			
		}
		else if (text.equals("/=")) {
			valueExpression = new DivOperatorExpression(targetExpression, valueExpression);			
		}
		else if (text.equals("*=")) {
			valueExpression = new TimesOperatorExpression(targetExpression, valueExpression);			
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		// Executing the targetExpression can return either a Variable
		// or a SetterMethod with one argument (set method)
		// Executing the valueExpression will return an Object
		
		Object targetExpressionResult;
		
		if (targetExpression instanceof PropertyCallExpression) {
			targetExpressionResult = ((PropertyCallExpression) targetExpression).execute(context, true);
		}
		else if (targetExpression instanceof NameExpression) {
			targetExpressionResult = ((NameExpression) targetExpression).execute(context, true);
		}
		else {
			targetExpressionResult = context.getExecutorFactory().execute(targetExpression, context);
		}
		
		Object valueExpressionResult = context.getExecutorFactory().execute(valueExpression, context);
		
		if (targetExpressionResult instanceof IPropertySetter) {
			IPropertySetter setter = (IPropertySetter) targetExpressionResult;
			try {
				Object value = getValueEquivalent(setter.getObject(), valueExpressionResult, context);
				setter.invoke(value);
			}
			catch (EolRuntimeException ex) {
				if (ex.getAst() == null) {
					ex.setAst(setter.getAst());
				}
				throw ex;
			}
		}
		else if (targetExpressionResult instanceof Variable) {
			Variable variable = (Variable) targetExpressionResult;
			try {
				Object value = getValueEquivalent(variable.getValue(), valueExpressionResult, context);
				variable.setValue(value, context);
			}
			catch (EolRuntimeException ex){
				ex.setAst(targetExpression);
				throw ex;
			}
		}
		else {
			throw new EolRuntimeException("Internal error. Expected either a SetterMethod or a Variable and got an " + targetExpressionResult + " instead", this);
		}
		
		return null;
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

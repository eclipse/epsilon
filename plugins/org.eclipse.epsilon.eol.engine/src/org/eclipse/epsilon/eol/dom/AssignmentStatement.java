package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
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
	public void build() {
		super.build();
		targetExpression = (Expression) getFirstChild();
		valueExpression = (Expression) getSecondChild();
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		// Executing the targetExpression can return either a Variable
		// or a SetterMethod with one argument (set method)
		// Executing the valueExpression will return an object
		
		Object targetExpressionResult = null;
		
		if (targetExpression instanceof PropertyCallExpression) {
			targetExpressionResult = ((PropertyCallExpression) targetExpression).execute(context, true);
		}
		else if (targetExpression instanceof NameExpression) {
			targetExpressionResult = ((NameExpression) targetExpression).execute(context, true);
		}
		else {
			targetExpressionResult = context.getExecutorFactory().executeAST(targetExpression, context);
		}
		
		Object valueExpressionResult = context.getExecutorFactory().executeAST(valueExpression, context);
		
		if (targetExpressionResult instanceof IPropertySetter){
			IPropertySetter setter = (IPropertySetter) targetExpressionResult;
			try {
				Object value = getValueEquivalent(setter.getObject(), valueExpressionResult, context);
				
				setter.invoke(value);
			}
			catch (EolRuntimeException ex){
				if (ex.getAst() == null) {
					ex.setAst(setter.getAst());
				}
				throw ex;
			}
		} else if (targetExpressionResult instanceof Variable){
			Variable variable = (Variable) targetExpressionResult;
			try {
				Object value = getValueEquivalent(variable.getValue(), valueExpressionResult, context);
				variable.setValue(value, context);
			}
			catch (EolRuntimeException ex){
				ex.setAst(targetExpression);
				throw ex;
			}
		} else {
			throw new EolRuntimeException("Internall error. Expected either a SetterMethod or a Variable and got an " + targetExpressionResult + "instead", this);
		}
		
		return null;
		
	}
	
	public Object getValueEquivalent(Object source, Object value, IEolContext context) throws EolRuntimeException {
		return value;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
	}
	
}

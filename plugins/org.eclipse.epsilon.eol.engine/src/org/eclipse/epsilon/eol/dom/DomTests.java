package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.execute.context.EolContext;

public class DomTests {
	
	public static void main(String[] args) throws Exception {
		EolContext context = new EolContext();
		ExpressionStatement expressionStatement = new ExpressionStatement();
		OperationCallExpression operationCallExpression = new OperationCallExpression();
		expressionStatement.setExpression(operationCallExpression);
		operationCallExpression.setTargetExpression(new StringLiteral("hello"));
		operationCallExpression.setOperationName("errln1");
		operationCallExpression.getParameterExpressions().add(new IntegerLiteral(5));
		expressionStatement.execute(context);
	}
	
}

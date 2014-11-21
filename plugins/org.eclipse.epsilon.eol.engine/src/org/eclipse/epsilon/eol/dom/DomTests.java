package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.execute.context.EolContext;

public class DomTests {
	
	public static void main(String[] args) throws Exception {
		
		//ForStatement forStatement = new ForStatement();
		EolContext context = new EolContext();
		ExpressionStatement expressionStatement = new ExpressionStatement();
		OperationCallExpression operationCallExpression = new OperationCallExpression();
		expressionStatement.setExpression(operationCallExpression);
		operationCallExpression.setTarget(new StringLiteral("hello"));
		operationCallExpression.setOperationName("errln1");
		operationCallExpression.getParameters().add(new IntegerLiteral(5));
		expressionStatement.execute(context);
	}
	
}

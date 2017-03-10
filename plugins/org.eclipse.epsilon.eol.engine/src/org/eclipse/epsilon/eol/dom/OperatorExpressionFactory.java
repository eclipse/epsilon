package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;

public class OperatorExpressionFactory {
	
	public OperatorExpression createOperatorExpression(AST ast) {
		String operator = ast.getText();
		if (operator.equals("=")) {
			return new EqualsOperatorExpression();
		}
		else if (operator.equals("==")) {
			return new DoubleEqualsOperatorExpression();
		}
		else if (operator.equals("<>")) {
			return new NotEqualsOperatorExpression();
		}
		else if (operator.equals("+")) {
			return new PlusOperatorExpression();
		}
		else if (operator.equals("-")) {
			if (ast.getChildCount() == 2) {
				return new MinusOperatorExpression();
			}
			else {
				return new NegativeOperatorExpression();
			}
		}
		else if (operator.equals("*")) {
			return new TimesOperatorExpression();
		}
		else if (operator.equals("/")) {
			return new DivOperatorExpression();
		}
		else if (operator.equals("<")) {
			return new LessThanOperatorExpression();
		}
		else if (operator.equals(">")) {
			return new GreaterThanOperatorExpression();
		}
		else if (operator.equals("<=")) {
			return new LessEqualOperatorExpression();
		}
		else if (operator.equals(">=")) {
			return new GreaterEqualOperatorExpression();
		}
		else if (operator.equals("and")) {
			return new AndOperatorExpression();
		}
		else if (operator.equals("or")) {
			return new OrOperatorExpression();
		}
		else if (operator.equals("not")) {
			return new NotOperatorExpression();
		}
		else if (operator.equals("xor")) {
			return new XorOperatorExpression();
		}
		else if (operator.equals("implies")) {
			return new ImpliesOperatorExpression();
		}
		else if (operator.equals("++")) {
			return new PostfixOperatorExpression(true);
		}
		else if (operator.equals("--")) {
			return new PostfixOperatorExpression(false);
		}
		
		throw new RuntimeException("Unknown operator: " + operator);
	}
	
}

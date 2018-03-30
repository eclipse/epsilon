package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public abstract class OperatorExpression extends Expression {

	protected Expression firstOperand, secondOperand;
	protected String operator;
	
	public OperatorExpression() {}
	
	public OperatorExpression(Expression firstOperand, Expression secondOperand) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.firstOperand = (Expression) module.createAst(cst.getFirstChild(), this);
		this.secondOperand = (Expression) module.createAst(cst.getSecondChild(), this);
		this.operator = cst.getText();
	}
		
	@Override
	public void compile(EolCompilationContext context) {
		firstOperand.compile(context);
		if (secondOperand != null) { secondOperand.compile(context); }
		
		if (isBooleanOperator(operator)) {
			for (Expression operand : getOperands()) {
				if (operand.hasResolvedType() && operand.getResolvedType() != EolPrimitiveType.Boolean) {
					context.addErrorMarker(operand, "Boolean expected instead of " + operand.getResolvedType());
				}
			}
			resolvedType = EolPrimitiveType.Boolean;
		}
		
		if (StringUtil.isOneOf(operator, "<", ">", ">=", "<=", "*", "/", "-")) {
			for (Expression operand : getOperands()) {
				if (operand.hasResolvedType() && 
						operand.getResolvedType() != EolPrimitiveType.Integer 
						&& operand.getResolvedType() != EolPrimitiveType.Real) {
					
					context.addErrorMarker(operand, "Number expected instead of " + operand.getResolvedType());
				}
			}
		}
		
		if (StringUtil.isOneOf(operator, "==", "=", "<>", "<", ">", ">=", "<=")) {
			resolvedType = EolPrimitiveType.Boolean;
		}	
	}
	
	public List<Expression> getOperands() {
		List<Expression> operands = new ArrayList<>();
		operands.add(firstOperand);
		if (secondOperand != null) operands.add(secondOperand);
		return operands;
	}
	
	public boolean isBooleanOperator(String operator) {
		return StringUtil.isOneOf(operator, "and", "or", "xor", "not", "implies");
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public Expression getFirstOperand() {
		return firstOperand;
	}
	
	public void setFirstOperand(Expression firstOperand) {
		this.firstOperand = firstOperand;
	}
	
	public Expression getSecondOperand() {
		return secondOperand;
	}
	
	public void setSecondOperand(Expression secondOperand) {
		this.secondOperand = secondOperand;
	}
}

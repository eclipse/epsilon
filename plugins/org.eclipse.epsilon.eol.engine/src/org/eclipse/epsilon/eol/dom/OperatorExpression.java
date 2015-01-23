package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.IterableOperationContributor;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolObjectComparator;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class OperatorExpression extends Expression {

	private IEolContext context;
	protected Expression firstOperand;
	protected Expression secondOperand;
	protected String operator;
	
	public OperatorExpression() {}
	
	public OperatorExpression(String operator, Expression firstOperand, Expression secondOperand) {
		this.operator = operator;
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}
	
	@Override
	public void build() {
		super.build();
		this.firstOperand = (Expression) getFirstChild();
		this.secondOperand = (Expression) getSecondChild();
		this.operator = getText();
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		this.context = context;
		Object operand1 = null; 
		Object operand2 = null;
		
		if (isBooleanOperator(operator)){
			if (operator.compareTo("and") == 0){
				return and();
			}
			else if (operator.compareTo("or") == 0){
				return or();
			}
			else if (operator.compareTo("xor") == 0){
				return xor();
			}
			else if (operator.compareTo("implies") == 0){
				return implies();
			}
			else if (operator.compareTo("not") == 0){
				return not();
			}
		}
		else {
			operand1 = context.getExecutorFactory().executeAST(firstOperand, context);
			
			if (secondOperand != null){
				operand2 = context.getExecutorFactory().executeAST(secondOperand, context);
			}
			
			if (operator.compareTo("+") == 0){
				return add(operand1, operand2);
			}
			else if (operator.compareTo("-") == 0){
				if (operand2 != null){
					return subtract(operand1, operand2);
				}
				else {
					return negative(operand1);
				}
			}
			else if (operator.compareTo("*") == 0){
				return multiply(operand1, operand2);
			}
			else if (operator.compareTo("/") == 0){
				return divide(operand1, operand2);
			}
			else if (operator.compareTo("<") == 0){
				return lessThan(operand1, operand2);
			}
			else if (operator.compareTo(">") == 0){
				return greaterThan(operand1, operand2);
			}
			else if (operator.compareTo("=") == 0){
				return equals(operand1, operand2);
			}
			else if (operator.compareTo("==") == 0){
				return equals(operand1, operand2);
			}
			else if (operator.compareTo("<>") == 0){
				return !equals(operand1, operand2);
			}
			else if (operator.compareTo(">=") == 0){
				return greaterEqualThan(operand1, operand2);
			}
			else if (operator.compareTo("<=") == 0){
				return lessEqualThan(operand1, operand2);
			}
		}
		return null;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		firstOperand.compile(context);
		if (secondOperand != null) { secondOperand.compile(context); }
		System.out.println("Compile");
		
		if (isBooleanOperator(operator)) {
			for (Expression operand : getOperands()) {
				if (operand.hasResolvedType() && operand.getResolvedType() != EolPrimitiveType.Boolean) {
					context.addErrorMarker(operand, "Boolean expected instead of " + operand.getResolvedType());
				}
			}
			resolvedType = EolPrimitiveType.Boolean;
		}
		
		if (operatorIsOneOf("<", ">", ">=", "<=", "*", "/", "-")) {
			for (Expression operand : getOperands()) {
				if (operand.hasResolvedType() && 
						operand.getResolvedType() != EolPrimitiveType.Integer 
						&& operand.getResolvedType() != EolPrimitiveType.Real) {
					
					context.addErrorMarker(operand, "Number expected instead of " + operand.getResolvedType());
				}
			}
		}
		
		if (operatorIsOneOf("==", "=", "<>", "<", ">", ">=", "<=")) {
			resolvedType = EolPrimitiveType.Boolean;
		}
		
	}
	
	protected boolean operatorIsOneOf(String... candidates) {
		for (String candidate : candidates) {
			if (candidate.equals(operator)) return true;
		}
		return false;
	}
	
	public List<Expression> getOperands() {
		List<Expression> operands = new ArrayList<Expression>();
		operands.add(firstOperand);
		if (secondOperand != null) operands.add(secondOperand);
		return operands;
	}
	
	protected Object negative(Object o) {
		if (o instanceof Number){
			return NumberUtil.negative((Number) o);
		}
		return o;
	}
	
	
	@SuppressWarnings("unchecked")
	protected Object add(Object o1, Object o2){
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.add((Number) o1, (Number) o2);
		}
		else if (o1 instanceof Collection && o2 instanceof Collection){
			return EolCollectionType.join((Collection<Object>) o1, (Collection<Object>)o2);
		}
		
		// If we can do nothing more, we concat their string representations
		PrettyPrinterManager prettyPrinterManager = context.getPrettyPrinterManager();	
		return prettyPrinterManager.print(o1) + prettyPrinterManager.print(o2);

	}

	protected Object subtract(Object o1, Object o2){
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.subtract((Number) o1, (Number) o2);
		}
		else if (o1 instanceof Collection && o2 instanceof Collection){
			return new IterableOperationContributor((Collection<?>) o1).excludingAll((Collection<?>) o2);
		}
		
		return null;
	}

	protected Object multiply(Object o1, Object o2){
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.multiply((Number) o1, (Number) o2);
		}
		return new Integer(0);
	}

	protected Object divide(Object o1, Object o2) throws EolRuntimeException {
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.divide((Number) o1, (Number) o2);
		}
		throw new EolRuntimeException("Cannot divide " + context.getPrettyPrinterManager().toString(o1) + " by " + context.getPrettyPrinterManager().toString(o2));
	}
	
	protected boolean greaterThan(Object o1, Object o2){
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.greaterThan((Number) o1, (Number) o2);
		}
		return false;
	}
	
	protected boolean lessThan(Object o1, Object o2){
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.lessThan((Number) o1, (Number) o2);
		}
		return false;
	}
	
	protected boolean equals(Object o1, Object o2){
		return EolObjectComparator.equals(o1, o2);
	}
	
	protected boolean greaterEqualThan(Object o1, Object o2){
		return greaterThan(o1,o2) || equals(o1,o2);
	}
	
	protected boolean lessEqualThan(Object o1, Object o2){
		return lessThan(o1,o2) || equals(o1,o2);
	}

	protected boolean and() throws EolRuntimeException{
		
		Object o1 = context.getExecutorFactory().executeAST(firstOperand,context);
		
		if (o1 instanceof Boolean) {
			Boolean b1 = (Boolean) o1;
			if (b1.booleanValue() == false) {
				return false;
			}
			else {
				Object o2 = context.getExecutorFactory().executeAST(secondOperand,context);
				if (o2 instanceof Boolean){
					return (Boolean) o2;
				}
				else {
					throw new EolRuntimeException("Operator 'and' applies only to operands of type Boolean", this);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'and' applies only to operands of type Boolean", this);
		}
		
	}

	protected boolean or() throws EolRuntimeException{
		
		Object o1 = context.getExecutorFactory().executeAST(firstOperand,context);
		
		if (o1 instanceof Boolean) {
			Boolean b1 = (Boolean) o1;
			if (b1.booleanValue() == true) {
				return true;
			}
			else {
				Object o2 = context.getExecutorFactory().executeAST(secondOperand,context);
				if (o2 instanceof Boolean){
					return (Boolean) o2;
				}
				else {
					throw new EolRuntimeException("Operator 'or' applies only to operands of type Boolean", this);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'or' applies only to operands of type Boolean", this);
		}
		
	}

	protected boolean implies() throws EolRuntimeException{
		
		Object o1 = context.getExecutorFactory().executeAST(firstOperand,context);
		
		if (o1 instanceof Boolean) {
			Boolean b1 = (Boolean) o1;
			if (b1.booleanValue() == false) {
				return true;
			}
			else {
				Object o2 = context.getExecutorFactory().executeAST(secondOperand,context);
				if (o2 instanceof Boolean){
					return ((Boolean) o2) && ((Boolean) o1);
				}
				else {
					throw new EolRuntimeException("Operator 'implies' applies only to operands of type Boolean", this);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'implies' applies only to operands of type Boolean", this);
		}
		
	}
	
	protected boolean xor() throws EolRuntimeException{
		Object o1 = context.getExecutorFactory().executeAST(firstOperand,context);
		Object o2 = context.getExecutorFactory().executeAST(secondOperand,context);
		if (o1 instanceof Boolean && o2 instanceof Boolean){
			return ((Boolean) o1) ^ ((Boolean) o2);
		} else {
			throw new EolRuntimeException("Operator 'xor' applies only to Booleans", this);
		}
	}
	
	protected Boolean not() throws EolRuntimeException{
		Object o1 = context.getExecutorFactory().executeAST(firstOperand,context);
		if (o1 instanceof Boolean){
			return !((Boolean) o1);
		} else {
			throw new EolRuntimeException("Operator 'not' applies only to Booleans", this);
		}
	}
	
	public boolean isBooleanOperator(String operator){
		return operatorIsOneOf("and", "or", "xor", "not", "implies");
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

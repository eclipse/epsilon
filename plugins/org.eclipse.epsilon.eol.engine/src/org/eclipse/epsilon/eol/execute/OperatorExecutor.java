/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolReal;
import org.eclipse.epsilon.eol.types.EolString;


public class OperatorExecutor extends AbstractExecutor{
	
	private AST ast = null;
	private IEolContext context;
	
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		this.ast = ast;
		this.context = context;
		String operator = ast.getText();
		AST operand1Ast = ast.getFirstChild();
		AST operand2Ast = operand1Ast.getNextSibling();
		Object operand1 = null; 
		Object operand2 = null;
		
		
		if (isBooleanOperator(operator)){
			if (operator.compareTo("and") == 0){
				return and(operand1Ast, operand2Ast);
			}
			else if (operator.compareTo("or") == 0){
				return or(operand1Ast, operand2Ast);
			}
			else if (operator.compareTo("xor") == 0){
				return xor(operand1Ast, operand2Ast);
			}
			else if (operator.compareTo("implies") == 0){
				return implies(operand1Ast, operand2Ast);
			}
			else if (operator.compareTo("not") == 0){
				return not(operand1Ast);
			}
		}
		else {
			operand1 = context.getExecutorFactory().executeAST(operand1Ast, context);
			
			if (operand2Ast != null){
				operand2 = context.getExecutorFactory().executeAST(operand2Ast, context);
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
				return equals(operand1, operand2).not();
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
	
	private Object negative(Object o) {
		if (o instanceof EolInteger){
			return ((EolInteger) o).negative();
		}
		else if (o instanceof EolReal){
			return ((EolReal) o).negative();
		}
		return o;
	}
	
	
	private Object add(Object o1, Object o2){
		if (o1 instanceof EolInteger && o2 instanceof EolInteger){
			return ((EolInteger) o1).add((EolInteger)o2);
		}
		else if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).add((EolReal)o2);
		}
		else if (o1 instanceof EolCollection && o2 instanceof EolCollection){
			return ((EolCollection) o1).includingAll((EolCollection)o2);
		}
		
		// If we can do nothing more, we concat their string
		// representations
		
		PrettyPrinter prettyPrinter1 = context.getPrettyPrinterManager().getPrettyPrinterFor(o1);
		PrettyPrinter prettyPrinter2 = context.getPrettyPrinterManager().getPrettyPrinterFor(o2);	
		return new EolString(prettyPrinter1.print(o1) + prettyPrinter2.print(o2));
	}

	private Object subtract(Object o1, Object o2){
		if (o1 instanceof EolInteger && o2 instanceof EolInteger){
			return ((EolInteger) o1).subtract((EolInteger)o2);
		}
		else if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).subtract((EolReal)o2);
		}
		else if (o1 instanceof EolCollection && o2 instanceof EolCollection){
			return ((EolCollection) o1).excludingAll((EolCollection)o2);
		}
		
		return null;
	}

	private Object multiply(Object o1, Object o2){
		if (o1 instanceof EolInteger && o2 instanceof EolInteger){
			return ((EolInteger) o1).multiply((EolInteger)o2);
		}
		else if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).multiply((EolReal)o2);
		}
		return new Integer(0);
	}

	private Object divide(Object o1, Object o2) throws EolRuntimeException {
		if (o1 instanceof EolInteger && o2 instanceof EolInteger){
			return ((EolInteger) o1).divide((EolInteger)o2);
		}
		else if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).divide((EolReal)o2);
		}
		throw new EolRuntimeException("Cannot divide " + context.getPrettyPrinterManager().toString(o1) + " by " + context.getPrettyPrinterManager().toString(o2));
	}
	
	public EolBoolean greaterThan(Object o1, Object o2){
		if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).greaterThan((EolReal)o2);
		}
		return EolBoolean.FALSE;
	}
	
	public EolBoolean lessThan(Object o1, Object o2){
		if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).lessThan((EolReal)o2);
		}
		return EolBoolean.FALSE;
	}
	
	public EolBoolean equals(Object o1, Object o2){
		
		if (o1 == null || o2 == null) return EolBoolean.FALSE;
		
		return new EolBoolean(o1.equals(o2));
		
		/*
		if (o1 instanceof EolReal && o2 instanceof EolReal){
			return ((EolReal) o1).equalsValue((EolReal)o2);
		}
		else if (o1 instanceof EolString && o2 instanceof EolString){
			return ((EolString) o1).equalsValue((EolString)o2);
		}
		else if (o1 instanceof EolBoolean && o2 instanceof EolBoolean){
			return ((EolBoolean) o1).equals((EolBoolean) o2);
		} else if (o1 instanceof EolCollection && o2 instanceof EolCollection){
			return ((EolCollection) o1).equalsValue((EolCollection) o2);
		}
		else{
			return new EolBoolean(o1 == o2);
		}*/		
	}
	
	public EolBoolean greaterEqualThan(Object o1, Object o2){
		return greaterThan(o1,o2).or(equals(o1,o2));
	}
	
	public EolBoolean lessEqualThan(Object o1, Object o2){
		return lessThan(o1,o2).or(equals(o1,o2));
	}

	public EolBoolean and(AST operand1Ast, AST operand2Ast) throws EolRuntimeException{
		
		Object o1 = context.getExecutorFactory().executeAST(operand1Ast,context);
		
		if (o1 instanceof EolBoolean) {
			EolBoolean b1 = (EolBoolean) o1;
			if (b1.booleanValue() == false) {
				return EolBoolean.FALSE;
			}
			else {
				Object o2 = context.getExecutorFactory().executeAST(operand2Ast,context);
				if (o2 instanceof EolBoolean){
					return (EolBoolean) o2;
				}
				else {
					throw new EolRuntimeException("Operator 'and' applies only to operands of type Boolean", ast);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'and' applies only to operands of type Boolean", ast);
		}
		
	}

	public EolBoolean or(AST operand1Ast, AST operand2Ast) throws EolRuntimeException{
		
		Object o1 = context.getExecutorFactory().executeAST(operand1Ast,context);
		
		if (o1 instanceof EolBoolean) {
			EolBoolean b1 = (EolBoolean) o1;
			if (b1.booleanValue() == true) {
				return EolBoolean.TRUE;
			}
			else {
				Object o2 = context.getExecutorFactory().executeAST(operand2Ast,context);
				if (o2 instanceof EolBoolean){
					return (EolBoolean) o2;
				}
				else {
					throw new EolRuntimeException("Operator 'or' applies only to operands of type Boolean", ast);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'or' applies only to operands of type Boolean", ast);
		}
		
	}

	public EolBoolean implies(AST operand1Ast, AST operand2Ast) throws EolRuntimeException{
		
		Object o1 = context.getExecutorFactory().executeAST(operand1Ast,context);
		
		if (o1 instanceof EolBoolean) {
			EolBoolean b1 = (EolBoolean) o1;
			if (b1.booleanValue() == false) {
				return EolBoolean.TRUE;
			}
			else {
				Object o2 = context.getExecutorFactory().executeAST(operand2Ast,context);
				if (o2 instanceof EolBoolean){
					return ((EolBoolean) o2).and((EolBoolean) o1);
				}
				else {
					throw new EolRuntimeException("Operator 'implies' applies only to operands of type Boolean", ast);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'implies' applies only to operands of type Boolean", ast);
		}
		
	}
	
	public EolBoolean xor(AST operand1Ast, AST operand2Ast) throws EolRuntimeException{
		Object o1 = context.getExecutorFactory().executeAST(operand1Ast,context);
		Object o2 = context.getExecutorFactory().executeAST(operand2Ast,context);
		if (o1 instanceof EolBoolean && o2 instanceof EolBoolean){
			return ((EolBoolean) o1).xor((EolBoolean) o2);
		} else {
			throw new EolRuntimeException("Operator 'xor' applies only to Booleans", ast);
		}
	}
	
	public EolBoolean not(AST operand1Ast) throws EolRuntimeException{
		Object o1 = context.getExecutorFactory().executeAST(operand1Ast,context);
		if (o1 instanceof EolBoolean){
			return ((EolBoolean) o1).not();
		} else {
			throw new EolRuntimeException("Operator 'not' applies only to Booleans", ast);
		}
	}
	
	public boolean isBooleanOperator(String operator){
		return operator.equals("and") ||
			operator.equals("or") ||
			operator.equals("xor") ||
			operator.equals("not") ||
			operator.equals("implies");
	}
	
}

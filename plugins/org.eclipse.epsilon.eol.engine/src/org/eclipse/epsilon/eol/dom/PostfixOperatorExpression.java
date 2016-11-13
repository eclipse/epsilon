package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class PostfixOperatorExpression extends OperatorExpression {
	
	protected boolean increase;
	protected AssignmentStatement assignmentStatement;
	
	public PostfixOperatorExpression(boolean increase){
		this.increase = increase;
	}
	
	public PostfixOperatorExpression(Expression operand, boolean increase) {
		super(operand, null);
		this.increase = increase;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		Expression valueExpression = null;
		if (increase) valueExpression = new PlusOperatorExpression(firstOperand, new IntegerLiteral(1));
		else valueExpression = new MinusOperatorExpression(firstOperand, new IntegerLiteral(1));
		assignmentStatement = new AssignmentStatement(firstOperand, valueExpression);		
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {		
		context.getExecutorFactory().execute(assignmentStatement, context);
		return context.getExecutorFactory().execute(firstOperand, context);
	}

}

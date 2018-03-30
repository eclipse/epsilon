package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class IfStatement extends Statement {
	
	protected Expression conditionExpression;
	protected StatementBlock thenStatementBlock;
	protected StatementBlock elseStatementBlock;
	
	public IfStatement() {}
	
	public IfStatement(Expression conditionExpression, StatementBlock thenStatementBlock, StatementBlock elseStatementBlock) {
		this.conditionExpression = conditionExpression;
		this.thenStatementBlock = thenStatementBlock;
		this.elseStatementBlock = elseStatementBlock;
	}

	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		conditionExpression = (Expression) module.createAst(cst.getFirstChild(), this);
		thenStatementBlock = toStatementBlock(module.createAst(cst.getSecondChild(), this));
		if (cst.getChildCount() == 3) elseStatementBlock = toStatementBlock(module.createAst(cst.getThirdChild(), this));
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
		Object condition = context.getExecutorFactory().execute(conditionExpression, context);
		
		if (!(condition instanceof Boolean)) throw new EolIllegalReturnException("Boolean", condition, conditionExpression, context);
		
		Object result = null;
		
		if ((boolean) condition) {
			result = context.getExecutorFactory().execute(thenStatementBlock, context);
		}
		else if (elseStatementBlock != null) {
			result = context.getExecutorFactory().execute(elseStatementBlock, context);
		}
		
		context.getFrameStack().leaveLocal(this);
		return result;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		conditionExpression.compile(context);
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, thenStatementBlock);
		thenStatementBlock.compile(context);
		context.getFrameStack().leaveLocal(thenStatementBlock);
		
		if (elseStatementBlock != null) {
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, elseStatementBlock);
			elseStatementBlock.compile(context);
			context.getFrameStack().leaveLocal(elseStatementBlock);
		}
		
		if (conditionExpression.hasResolvedType() && conditionExpression.getResolvedType() != EolPrimitiveType.Boolean) {
			context.getMarkers().add(new ModuleMarker(conditionExpression, "Condition must be a Boolean", Severity.Error));
		}
		
	}
	
	public Expression getConditionExpression() {
		return conditionExpression;
	}
	
	public void setConditionExpression(Expression conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	
	public StatementBlock getThenStatementBlock() {
		return thenStatementBlock;
	}
	
	public void setThenStatementBlock(StatementBlock thenStatementBlock) {
		this.thenStatementBlock = thenStatementBlock;
	}
	
	public StatementBlock getElseStatementBlock() {
		return elseStatementBlock;
	}
	
	public void setElseStatementBlock(StatementBlock elseStatementBlock) {
		this.elseStatementBlock = elseStatementBlock;
	}
}

package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExecutableBlock<T> extends AbstractExecutableModuleElement {
	
	protected AST body = null;
	protected Class<?> expectedResultClass = null;
	protected String role = "";
	
	public ExecutableBlock(Class<?> expectedResultClass) {
		this.expectedResultClass = expectedResultClass;
	}
	
	@Override
	public void build() {
		super.build();
		if (this.getType() == EolParser.BLOCK) {
			body = this;
		}
		else {
			role = getText();
			body = getFirstChild();
		}
	}
	
	public AST getBody() {
		return body;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public T execute(IEolContext context, Variable... variables) throws EolRuntimeException {
		return execute(context, true, variables);
	}
	
	@Override
	public T execute(IEolContext context) throws EolRuntimeException {
		return execute(context, new Variable[]{});
	}
	
	protected Object executeBlockOrExpressionAst(AST ast, IEolContext context) throws EolRuntimeException {
		if (ast == null) return null;
		
		if (ast instanceof ExecutableBlock<?>) {
			AST statementAst = ast.getFirstChild();
			while (statementAst != null){
				context.getFrameStack().setCurrentStatement(statementAst);
				Object result = context.getExecutorFactory().executeAST(statementAst, context);
				if (result instanceof Return) {
					return result;
				}
				statementAst = statementAst.getNextSibling();
			}
			return null;
		}
		else if (ast instanceof StatementBlock) {
			return context.getExecutorFactory().executeAST(ast, context);
		}
		else {
			return new Return(context.getExecutorFactory().executeAST(ast,context));
		}
		
	}
	
	public T execute(IEolContext context, boolean inNewFrame, FrameType frameType, Variable... variables) throws EolRuntimeException {
		if (inNewFrame) context.getFrameStack().enterLocal(frameType, this);
		for (Variable variable : variables) {
			context.getFrameStack().put(variable);
		}
		
		Object result = executeBlockOrExpressionAst(getBody(), context);
		
		if (inNewFrame) context.getFrameStack().leaveLocal(this);
		
		if (result instanceof Return) {
			Object value = Return.getValue(result);
			if (getExpectedResultClass().isInstance(value)) {
				return (T) value;
			}
			else if (getExpectedResultClass() == String.class && !(value instanceof String)) {
				return (T) (value + "");
			}
			else if (value == null && getExpectedResultClass() == Void.class) {
				return null;
			}
			else if (getExpectedResultClass() == null) {
				return (T) result;
			}
			else {
				throw new EolIllegalReturnException(getExpectedResultClass().getSimpleName(), value, this, context);
			}	
		}
		else if (getExpectedResultClass() != Void.class){
			throw new EolNoReturnException(getExpectedResultClass().getSimpleName(), this, context);
		}
		else return null;		
	}
	
	public T execute(IEolContext context, boolean inNewFrame, Variable... variables) throws EolRuntimeException {
		return execute(context, inNewFrame, FrameType.PROTECTED, variables);
	}
	
	protected Class<?> getExpectedResultClass() {
		return expectedResultClass;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
}

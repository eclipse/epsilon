package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExecutableBlock<T> extends AbstractModuleElement implements IExecutableModuleElement {
	
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
	public Object execute(IEolContext context) throws EolRuntimeException {
		return execute(context, new Variable[]{});
	}
	
	protected Object executeBlockOrExpressionAst(AST ast, IEolContext context) throws EolRuntimeException {
		if (ast == null) return null;
		
		if (ast instanceof ExecutableBlock<?> || ast instanceof StatementBlock) {
			return StatementBlock.execute(ast, context);
		}
		else {
			return new Return(context.getExecutorFactory().executeAST(ast,context));
		}
		
	}
	
	public T execute(IEolContext context, boolean inNewFrame, Variable... variables) throws EolRuntimeException {
		
		if (inNewFrame) context.getFrameStack().enterLocal(FrameType.PROTECTED, this);
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
	
	protected Class<?> getExpectedResultClass() {
		return expectedResultClass;
	}
	
}

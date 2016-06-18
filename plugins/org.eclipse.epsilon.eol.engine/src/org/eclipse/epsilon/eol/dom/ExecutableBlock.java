package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExecutableBlock<T> extends AbstractExecutableModuleElement {
	
	protected IExecutableModuleElement body = null;
	protected Class<?> expectedResultClass = null;
	protected String role = "";
	protected String text = "";
	
	public ExecutableBlock(Class<?> expectedResultClass) {
		this.expectedResultClass = expectedResultClass;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		text = cst.getText();
		if (cst.getType() == EolParser.BLOCK) {
			StatementBlock statementBlock = new StatementBlock();
			statementBlock.setParent(this);
			this.getChildren().add(statementBlock);
			for (AST childAst : cst.getChildren()) {
				ModuleElement childModuleElement = module.createAst(childAst, statementBlock);
				if (childModuleElement instanceof Statement) {
					statementBlock.getStatements().add((Statement) childModuleElement);
				}
				else if (childModuleElement instanceof Expression) {
					// Turn the expression into an expression statement so that it can be added to the statementBlock
					ExpressionStatement expressionStatement = new ExpressionStatement((Expression) childModuleElement);
					expressionStatement.setParent(statementBlock);
					statementBlock.getChildren().add(expressionStatement);
					statementBlock.getStatements().add(expressionStatement);
				}
			}
			body = statementBlock;
		}
		else {
			role = cst.getText();
			body = (IExecutableModuleElement) module.createAst(cst.getFirstChild(), this);
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public IExecutableModuleElement getBody() {
		return body;
	}
	
	public void setBody(IExecutableModuleElement body) {
		this.body = body;
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
	
	protected Object executeBlockOrExpressionAst(IExecutableModuleElement ast, IEolContext context) throws EolRuntimeException {
		
		if (ast == null) return null;
		
		if (ast instanceof StatementBlock) {
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
		return execute(context, inNewFrame, FrameType.UNPROTECTED, variables);
	}
	
	protected Class<?> getExpectedResultClass() {
		return expectedResultClass;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
}

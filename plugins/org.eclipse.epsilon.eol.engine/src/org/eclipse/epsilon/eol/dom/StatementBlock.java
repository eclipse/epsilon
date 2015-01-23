package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class StatementBlock extends AbstractExecutableModuleElement {
	
	protected List<Statement> statements = new ArrayList<Statement>();
	
	public StatementBlock(Statement...statements) {
		for (Statement statement : statements) {
			this.statements.add(statement);
		}
	}
	
	@Override
	public void build() {
		super.build();
		for (AST ast : getChildren()) {
			if (ast instanceof Statement) {
				statements.add((Statement) ast);
			}
			else {
				statements.add(new ExpressionStatement((Expression) ast));
			}
		}
	}
	
	public List<Statement> getStatements() {
		return statements;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		for (Statement statement : statements) {
			context.getFrameStack().setCurrentStatement(statement);
			Object result = context.getExecutorFactory().executeAST(statement, context);
			if (result instanceof Return) {
				return result;
			}
		}
		return null;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		for (Statement statement : statements) {
			System.out.println(statement.getClass());
			statement.compile(context);
		}
	}

	@Override
	public String toString(){
		return "{...}";
	}
}

package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class StatementBlock extends AbstractExecutableModuleElement {
	
	protected final ArrayList<Statement> statements = new ArrayList<>();
	
	public StatementBlock(Statement... statements) {
		if (statements != null) {
			this.statements.ensureCapacity(statements.length);
			for (Statement statement : statements) {
				this.statements.add(statement);
			}
		}
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		List<AST> children = cst.getChildren();
		statements.ensureCapacity(statements.size()+children.size());
		for (AST ast : children) {
			ModuleElement moduleElement = module.createAst(ast, this);
			if (moduleElement instanceof Statement) {
				statements.add((Statement) moduleElement);
			}
			else {
				ExpressionStatement expressionStatement = new ExpressionStatement((Expression) moduleElement);
				expressionStatement.setParent(this);
				this.getChildren().add(expressionStatement);
				statements.add(expressionStatement);
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
			Object result = context.getExecutorFactory().execute(statement, context);
			if (result instanceof Return) {
				return result;
			}
		}
		return null;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		for (Statement statement : statements) {
			statement.compile(context);
		}
	}

	@Override
	public String toString() {
		return "{...}";
	}
}

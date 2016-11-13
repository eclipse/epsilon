package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolUserException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ThrowStatement extends Statement {
	
	protected Expression thrown;
	
	public ThrowStatement() {}
	
	public ThrowStatement(Expression thrown) {
		setThrown(thrown);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		thrown = (Expression) module.createAst(cst.getFirstChild(), this);
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object thrownObject = null;
		if (thrown != null){
			thrownObject = context.getExecutorFactory().execute(thrown, context);
		}
		throw new EolUserException(thrownObject, this);	
	}
	
	public Expression getThrown() {
		return thrown;
	}
	
	public void setThrown(Expression thrown) {
		this.thrown = thrown;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		thrown.compile(context);
	}
	
}

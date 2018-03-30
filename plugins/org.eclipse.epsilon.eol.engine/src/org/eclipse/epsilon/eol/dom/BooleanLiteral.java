package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class BooleanLiteral extends LiteralExpression {
	
	protected boolean value;
	
	public BooleanLiteral() {}
	
	public BooleanLiteral(boolean value) {
		setValue(value);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		try {
			value = Boolean.parseBoolean(cst.getText());
		}
		catch (Exception ex) {
			value = false;
		}
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return getValue();
	}
	
	public boolean getValue() {
		return value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		resolvedType = EolPrimitiveType.Boolean;
	}
}

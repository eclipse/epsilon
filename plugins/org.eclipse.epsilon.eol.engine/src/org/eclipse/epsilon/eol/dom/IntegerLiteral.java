package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class IntegerLiteral extends LiteralExpression {
	
	protected Number value;
	
	public IntegerLiteral() {}
	
	public IntegerLiteral(Number value) {
		setValue(value);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		String text = "";
		if (cst.getText().endsWith("l")) {
			text = cst.getText().substring(0, cst.getText().length() - 1);
			value = Long.parseLong(text);
		}
		else {
			value = Integer.parseInt(cst.getText());
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return getValue();
	}
	
	public Number getValue() {
		return value;
	}
	
	public void setValue(Number value) {
		//TODO: Throw exception if value is not an integer or a long
		this.value = value;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		resolvedType = EolPrimitiveType.Integer;
	}
	
}

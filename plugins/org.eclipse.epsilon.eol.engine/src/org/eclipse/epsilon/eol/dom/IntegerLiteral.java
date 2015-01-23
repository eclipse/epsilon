package org.eclipse.epsilon.eol.dom;

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
	public void build() {
		super.build();
		String text = "";
		if (getText().endsWith("l")) {
			text = getText().substring(0, getText().length() - 1);
			value = Long.parseLong(text);
		}
		else {
			value = Integer.parseInt(getText());
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

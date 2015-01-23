package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
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
	public void build() {
		super.build();
		try {
			value = new Boolean(getText()).booleanValue();
		}
		catch (Exception ex){
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
	public void compile(IEolCompilationContext context) {
		resolvedType = EolPrimitiveType.Boolean;
	}
	
}

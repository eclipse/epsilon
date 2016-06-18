package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EnumerationLiteralExpression extends LiteralExpression {

	protected String enumerationLiteral;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		enumerationLiteral = cst.getText();
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return context.getModelRepository().getEnumerationValue(enumerationLiteral);
	}
	
	public String getEnumerationLiteral() {
		return enumerationLiteral;
	}
	
	public void setEnumerationLiteral(String enumerationLiteral) {
		this.enumerationLiteral = enumerationLiteral;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
}

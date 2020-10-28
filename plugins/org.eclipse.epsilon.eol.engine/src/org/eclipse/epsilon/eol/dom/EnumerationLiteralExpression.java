/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EnumerationLiteralExpression extends LiteralExpression<Object> {

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
	public void compile(IEolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
	public void accept(IEolVisitor visitor) {
		visitor.visit(this);
	}
}

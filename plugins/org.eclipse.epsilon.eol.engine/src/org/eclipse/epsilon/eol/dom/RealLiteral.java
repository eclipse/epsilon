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
import org.eclipse.epsilon.eol.types.EolPrimitiveType;


public class RealLiteral extends LiteralExpression<Number> {
		
	public RealLiteral() {
		super();
	}
	
	public RealLiteral(Number value) {
		super(value);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		String text = "";
		boolean doublePrecision = false;
		if (cst.getText().endsWith("f")) {
			text = cst.getText().substring(0, cst.getText().length() - 1);
			doublePrecision = false;
		}
		else if (cst.getText().endsWith("d")) {
			text = cst.getText().substring(0, cst.getText().length() - 1);
			doublePrecision = true;		
		}
		else {
			text = cst.getText();
			doublePrecision = false;			
		}
		
		if (doublePrecision) {
			value = Double.valueOf(text);
		}
		else {
			value = Float.valueOf(text);
		}
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		resolvedType = EolPrimitiveType.Real;
	}
	
}

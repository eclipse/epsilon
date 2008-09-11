/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.annotations;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;


public class EolExecutableAnnotation implements IEolAnnotation {
	
	protected String name;
	protected AST ast;
	protected AST expressionAst;
	
	public EolExecutableAnnotation(AST ast) {
		this.ast = ast;
		this.name = ast.getFirstChild().getText();
		this.expressionAst = ast.getFirstChild().getNextSibling();
	}
	
	public AST getAst() {
		return ast;
	}

	public String getName() {
		return name;
	}

	public Object getValue(IEolContext context) throws EolRuntimeException {
		return EolTypeWrapper.getInstance().unwrap(
				context.getExecutorFactory().executeAST(expressionAst, context));
	}

	public boolean hasValue() {
		return true;
	}
	
}

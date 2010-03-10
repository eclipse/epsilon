/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.types.EglComplexType;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.TypeExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EglTypeExecutor extends TypeExecutor {

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		if (ast.getText().equals("Template")){
			return EglComplexType.Template;
		
		} else {
			return super.execute(ast, context);
		}
	}

}

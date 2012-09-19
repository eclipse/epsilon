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
package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;


public class EolModuleExecutor extends EolBasicProgramExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		
		super.execute(ast, context);
		
		// Execute the block		
		AST blockAst = AstUtil.getChild(ast, EolParser.BLOCK);
		
		if (blockAst!= null){
			return Return.getValue(context.getExecutorFactory().executeAST(blockAst, context));
		}

		return null;
	}

}

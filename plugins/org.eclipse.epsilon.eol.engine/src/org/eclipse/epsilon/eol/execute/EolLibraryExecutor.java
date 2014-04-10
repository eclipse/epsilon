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

import java.util.Iterator;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;


public class EolLibraryExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		
		// Find the imports
		Iterator<AST> it = AstUtil.getChildren(ast, EolParser.IMPORT).iterator();
		while (it.hasNext()){
			context.getExecutorFactory().executeAST(it.next(), context);
		}
		
		// Then parse the helpers
		it = AstUtil.getChildren(ast, EolParser.HELPERMETHOD).iterator();
		while (it.hasNext()){
			EolOperation helper = new EolOperation((AST)it.next());
			//helper.setSourceFile(this.getSourceFile());
			((IEolLibraryModule)context.getModule()).getDeclaredOperations().add(helper);
		//	context.getExecutorFactory().executeAST((AST) it.next(), context);
		}
		
		return null;
	}

}

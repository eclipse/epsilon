/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/

package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolMap;

public class MapExecutor extends AbstractExecutor {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		assert ast.getType() == EolParser.MAP;
		final EolMap map = new EolMap();
		final AST keyvalListAST = ast.getFirstChild();

		if (keyvalListAST == null) {
			return map;
		}

		assert keyvalListAST.getType() == EolParser.KEYVALLIST;
		for (AST keyvalAst : keyvalListAST.getChildren()) {
			assert keyvalAst.getType() == EolParser.KEYVAL;
			final AST keyAst = keyvalAst.getFirstChild();
			final AST valAst = keyAst.getNextSibling();
			final Object key = context.getExecutorFactory().executeAST(keyAst, context);
			final Object val = context.getExecutorFactory().executeAST(valAst, context);
			map.put(key, val);
		}

		return map;
	}
}

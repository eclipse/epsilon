/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.util;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolParserUtil {
	
	public static boolean isPointOrArrow(AST ast) {
		return ast.getType() == EolParser.POINT ||
			ast.getType() == EolParser.ARROW;
	}
	
	public static boolean isProperty(AST ast) {
		return ast.getType() == EolParser.FEATURECALL && 
		ast.getFirstChild() == null && ast.getParent() != null
		&& isPointOrArrow(ast.getParent()) && ast.getParent().getChild(1) == ast;
	}
	
	public static boolean isOperationCall(AST ast) {
		return ast.getType() == EolParser.FEATURECALL && 
		ast.getFirstChild() != null;	
	}
	
}

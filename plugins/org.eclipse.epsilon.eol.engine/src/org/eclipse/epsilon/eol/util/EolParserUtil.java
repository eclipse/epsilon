package org.eclipse.epsilon.eol.util;

import org.eclipse.epsilon.commons.parse.AST;
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

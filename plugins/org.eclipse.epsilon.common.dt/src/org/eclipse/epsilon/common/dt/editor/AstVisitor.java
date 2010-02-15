package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.epsilon.commons.parse.AST;

class AstVisitor {
	public int startLine = 0;
	public int startColumn = 0;
	public int endLine = 0;
	public int endColumn = 0;
	
	protected void visit(AST ast){
		if (ast == null) return;
		if (ast.getLine() < startLine ||
				(ast.getLine() == startLine 
						&& ast.getColumn() < startColumn)) {
			startLine = ast.getLine();
			startColumn = ast.getColumn();
		}
		if (ast.getLine() > endLine ||
				(ast.getLine() == endLine 
						&& ast.getColumn() > endColumn)) {
			endLine = ast.getLine();
			endColumn = ast.getColumn();
		}		
		AST child = ast.getFirstChild();
		while (ast!=null){
			visit(child);
			ast = ast.getNextSibling();
		}
	}
}

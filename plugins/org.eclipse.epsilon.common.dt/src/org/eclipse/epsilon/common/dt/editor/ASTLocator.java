package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.epsilon.commons.parse.AST;

public interface ASTLocator {

	public ASTLocation getLocation(AST ast);
	
}

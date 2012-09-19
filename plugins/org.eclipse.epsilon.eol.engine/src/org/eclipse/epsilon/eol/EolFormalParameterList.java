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
package org.eclipse.epsilon.eol;

import java.util.ArrayList;
import java.util.ListIterator;

import org.eclipse.epsilon.common.parse.AST;


public class EolFormalParameterList extends ArrayList{
	
	protected AST ast;
	
	public EolFormalParameterList(AST ast){
		parse(ast);
	}

	public void clearCache() {
		for (Object o : this) {
			if (o instanceof EolFormalParameter) {
				((EolFormalParameter)o).clearCache();
			}
		}
	}

	public void parse(AST ast){
		this.ast = ast;
		if (ast == null) return;
		AST formalParameterAst = ast.getFirstChild();
		while (formalParameterAst != null){
			add(new EolFormalParameter(formalParameterAst));
			formalParameterAst = formalParameterAst.getNextSibling();
		}
	}
	
	@Override
	public String toString(){
		ListIterator li = listIterator();
		String str = "";
		while (li.hasNext()){
			EolFormalParameter fp = (EolFormalParameter) li.next();
			str += fp.toString();
			if (li.hasNext()){
				str += ", ";
			}
		}
		return str;
	}
	
}

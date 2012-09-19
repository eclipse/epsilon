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
package org.eclipse.epsilon.eol.parse;

import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.tree.Tree;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.StaticFieldNameResolver;
import org.eclipse.epsilon.common.util.AstUtil;


public class V2V3Comparator {
	
	HashMap<String, String> equivalents = new HashMap<String, String>();
	
	StaticFieldNameResolver r2;
	StaticFieldNameResolver r3;
	
	public V2V3Comparator(Class v2, Class v3) {
		r2 = new StaticFieldNameResolver(v2);
		r3 = new StaticFieldNameResolver(v3);
	}
	
	protected void put(String v2, String v3) {
		equivalents.put(v2, v3);
	}
	
	public void compare(AST ast, Tree tree) {
		String v2Type = r2.getField(ast.getType());
		String v3Type = r3.getField(tree.getType());
		
		if (v2Type == v3Type && compare(ast.getText(), tree.getText())) {
			
			List<AST> astChildren = AstUtil.getChildren(ast); 
			
			for (AST child : AstUtil.getChildren(ast)) {
				
			}
			
		}
		else {
			
		}
		
	}
	
	public boolean compare (String v2, String v3) {
		
		if (v2.equalsIgnoreCase(v3) || equivalents.get(v2) == v3) {
			return true;
		}
		else {
			return false;
		}
		
	}
}

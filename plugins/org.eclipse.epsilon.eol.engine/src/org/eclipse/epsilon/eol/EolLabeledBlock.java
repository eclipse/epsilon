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

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;

public class EolLabeledBlock extends AbstractModuleElement{
	
	protected String label = "";
	protected String name = "";
	
	public String getLabel() {
		return label;
	}
	
	public EolLabeledBlock(AST ast, String label) {
		this.label = label;
		//if (ast != null && ast.getFirstChild() != null) {
		//	this.ast = ast.getFirstChild();
		//}
		
		int childrenCount = AstUtil.getChildrenCount(ast);
		if (childrenCount == 2) {
			this.name = AstUtil.getChildAt(ast, 0).getText();
			this.ast = AstUtil.getChildAt(ast, 1);
		}
		else if (childrenCount == 1) {
			this.ast = AstUtil.getChildAt(ast, 0);			
		}
		
	}
	
	public String getName() { 
		return this.name;
	}
	
	//public void setLabel(String label) {
	//	this.label = label;
	//}

	//public EolLabeledBlock(AST ast, String label){
	//	setAst(ast);
	//	this.label = label;
	//}
	
	public List<?> getChildren() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString(){
		return label + " " + name;
	}
	
}

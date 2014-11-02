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
package org.eclipse.epsilon.erl.dom;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;

public class NamedRule extends AnnotatableModuleElement {
	
	protected String name = "";
	protected AST body = null;
	
	public NamedRule() {}
	
	@Override
	public void build() {
		super.build();
		int childrenCount = AstUtil.getChildrenCount(this);
		if (childrenCount == 2) {
			this.name = AstUtil.getChildAt(this, 0).getText();
			this.body = AstUtil.getChildAt(this, 1);
		}
		else if (childrenCount == 1) {
			this.body = AstUtil.getChildAt(this, 0);			
		}
	}
	
	public String getName() { 
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public AST getBody() {
		return body;
	}
	
	public List<?> getModuleElements() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString(){
		return name;
	}
}
